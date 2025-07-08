package grafoapp;

import javax.swing.*;

public class GraphController {
    private final Graph graph;
    private final GraphPanel graphPanel;
    private final MainWindow mainWindow;

    public GraphController(Graph graph, GraphPanel graphPanel, MainWindow mainWindow) {
        this.graph = graph;
        this.graphPanel = graphPanel;
        this.mainWindow = mainWindow;

        mainWindow.getAddVertexButton().addActionListener(e -> {
            String v = JOptionPane.showInputDialog("Nombre del vértice:");
            if (v != null && !v.isBlank()) {
                graph.addVertex(v.trim());
                graphPanel.setGraph(graph);
            }
        });

        mainWindow.getAddEdgeButton().addActionListener(e -> {
            String from = JOptionPane.showInputDialog("Vértice origen:");
            String to = JOptionPane.showInputDialog("Vértice destino:");
            if (from != null && to != null) {
                graph.addEdge(from.trim(), to.trim());
                graphPanel.setGraph(graph);
            }
        });

        mainWindow.getShowMatrixButton().addActionListener(e -> {
            int[][] matrix = graph.getAdjacencyMatrix();
            var vertices = graph.getVertices();

            StringBuilder sb = new StringBuilder("Matriz de adyacencia:\n   ");
            for (String v : vertices) sb.append(v).append(" ");
            sb.append("\n");

            for (int i = 0; i < matrix.length; i++) {
                sb.append(vertices.get(i)).append("  ");
                for (int j = 0; j < matrix.length; j++) {
                    sb.append(matrix[i][j]).append("  ");
                }
                sb.append("\n");
            }

            mainWindow.getMatrixTextArea().setText(sb.toString());
        });
    }
}
