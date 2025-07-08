package grafoapp;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final JButton addVertexButton = new JButton("Agregar Vértice");
    private final JButton addEdgeButton = new JButton("Agregar Arista");
    private final JButton showMatrixButton = new JButton("Mostrar Matriz");
    private final JTextArea matrixTextArea = new JTextArea(5, 20);
    private final JPanel graphContainer = new JPanel(new BorderLayout());

    public MainWindow() {
        setTitle("Editor de Grafos");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.add(addVertexButton);
        topPanel.add(addEdgeButton);
        topPanel.add(showMatrixButton);

        JScrollPane scrollPane = new JScrollPane(matrixTextArea);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(graphContainer, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    public JButton getAddVertexButton() {
        return addVertexButton;
    }

    public JButton getAddEdgeButton() {
        return addEdgeButton;
    }

    public JButton getShowMatrixButton() {
        return showMatrixButton;
    }

    public JTextArea getMatrixTextArea() {
        return matrixTextArea;
    }

    public JPanel getGraphContainer() {
        return graphContainer;
    }
}
