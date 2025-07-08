package grafoapp;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Graph graph = new Graph();
            GraphPanel graphPanel = new GraphPanel();
            MainWindow window = new MainWindow();

            window.getGraphContainer().add(graphPanel, BorderLayout.CENTER);
            new GraphController(graph, graphPanel, window);

            window.setVisible(true);
        });
    }
}
