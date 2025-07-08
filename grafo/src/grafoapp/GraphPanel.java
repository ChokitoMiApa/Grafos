package grafoapp;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraphPanel extends JPanel {
    private Graph graph;
    private final Map<String, Point> positions = new HashMap<>();
    private final Random rand = new Random();

    public void setGraph(Graph graph) {
        this.graph = graph;
        generatePositions();
        repaint();
    }

    private void generatePositions() {
        positions.clear();
        int width = getWidth();
        int height = getHeight();

        for (String v : graph.getVertices()) {
            int x = 50 + rand.nextInt(Math.max(width - 100, 100));
            int y = 50 + rand.nextInt(Math.max(height - 100, 100));
            positions.put(v, new Point(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (graph == null) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        // Dibujar aristas
        for (Map.Entry<String, Set<String>> entry : graph.getAdjList().entrySet()) {
            String from = entry.getKey();
            Point p1 = positions.get(from);
            for (String to : entry.getValue()) {
                Point p2 = positions.get(to);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        // Dibujar vértices
        for (Map.Entry<String, Point> entry : positions.entrySet()) {
            String v = entry.getKey();
            Point p = entry.getValue();

            g2.setColor(Color.CYAN);
            g2.fillOval(p.x - 15, p.y - 15, 30, 30);
            g2.setColor(Color.BLACK);
            g2.drawOval(p.x - 15, p.y - 15, 30, 30);
            g2.drawString(v, p.x - 10, p.y + 5);
        }
    }
}
