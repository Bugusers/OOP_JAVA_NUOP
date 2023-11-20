package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectanglePointApp {
    private static JTextField rectX1Field;
    private static JTextField rectY1Field;
    private static JTextField rectX2Field;
    private static JTextField rectY2Field;
    private static JTextField pointXField;
    private static JTextField pointYField;

    private static JFrame resultFrame;
    private static JPanel resultPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RectanglePointApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Rectangle Point App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(mainPanel);

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        mainPanel.add(panel, BorderLayout.CENTER);
        placeComponents(panel);

        resultFrame = new JFrame("Result");
        resultFrame.setSize(400, 400);
        resultPanel = new DrawingPanel();
        resultFrame.add(resultPanel);
        resultFrame.setResizable(false);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        rectX1Field = new JTextField();
        rectY1Field = new JTextField();
        rectX2Field = new JTextField();
        rectY2Field = new JTextField();
        pointXField = new JTextField();
        pointYField = new JTextField();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFocusPainted(false);
        calculateButton.setBackground(new Color(68, 138, 255));
        calculateButton.setForeground(Color.WHITE);

        panel.add(createLabelAndTextField("Rectangle Vertex 1 X:", rectX1Field));
        panel.add(createLabelAndTextField("Rectangle Vertex 1 Y:", rectY1Field));
        panel.add(createLabelAndTextField("Rectangle Vertex 2 X:", rectX2Field));
        panel.add(createLabelAndTextField("Rectangle Vertex 2 Y:", rectY2Field));
        panel.add(createLabelAndTextField("Point X:", pointXField));
        panel.add(createLabelAndTextField("Point Y:", pointYField));
        panel.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDraw();
            }
        });
    }

    private JPanel createLabelAndTextField(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new GridLayout(1, 2, 5, 5));
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    private void calculateAndDraw() {
        try {
            double rectX1 = Double.parseDouble(rectX1Field.getText());
            double rectY1 = Double.parseDouble(rectY1Field.getText());
            double rectX2 = Double.parseDouble(rectX2Field.getText());
            double rectY2 = Double.parseDouble(rectY2Field.getText());
            double pointX = Double.parseDouble(pointXField.getText());
            double pointY = Double.parseDouble(pointYField.getText());

            boolean isInside = isPointInsideRectangle(rectX1, rectY1, rectX2, rectY2, pointX, pointY);

            resultPanel.removeAll();
            resultPanel.add(new JLabel(isInside ? "Point is inside the rectangle" : "Point is outside the rectangle"));
            resultPanel.repaint();
            resultFrame.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(resultFrame, "Invalid input. Please enter valid numbers.");
        }
    }

    private boolean isPointInsideRectangle(double x1, double y1, double x2, double y2, double pointX, double pointY) {
        double rectLeft = Math.min(x1, x2);
        double rectRight = Math.max(x1, x2);
        double rectTop = Math.max(y1, y2);
        double rectBottom = Math.min(y1, y2);

        return (pointX >= rectLeft && pointX <= rectRight && pointY <= rectTop && pointY >= rectBottom);
    }

    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawCoordinateSystem(g);

            double rectX1 = Double.parseDouble(rectX1Field.getText());
            double rectY1 = Double.parseDouble(rectY1Field.getText());
            double rectX2 = Double.parseDouble(rectX2Field.getText());
            double rectY2 = Double.parseDouble(rectY2Field.getText());
            double pointX = Double.parseDouble(pointXField.getText());
            double pointY = Double.parseDouble(pointYField.getText());

            drawRectangle(g, rectX1, rectY1, rectX2, rectY2);
            drawPoint(g, pointX, pointY);
        }

        private void drawCoordinateSystem(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawLine(200, 0, 200, 400);
            g.drawLine(0, 200, 400, 200);
        }


        private static void drawRectangle(Graphics g, double upperLeftX, double upperLeftY, double lowerRightX, double lowerRightY) {
            g.setColor(Color.BLUE);

            double minX = Math.min(upperLeftX, lowerRightX);
            double minY = Math.min(upperLeftY, lowerRightY);
            double maxX = Math.max(upperLeftX, lowerRightX);
            double maxY = Math.max(upperLeftY, lowerRightY);

            int rectX = (int) (minX * 20) + 200;
            int rectY = 200 - (int) (maxY * 20);
            int rectWidth = (int) ((maxX - minX) * 20);
            int rectHeight = (int) ((maxY - minY) * 20);

            g.drawRect(rectX, rectY, rectWidth, rectHeight);
        }

        private static void drawPoint(Graphics g, double x, double y) {
            g.setColor(Color.RED);
            int pointX = (int) (x * 20) + 200;
            int pointY = 200 - (int) (y * 20);
            g.fillOval(pointX - 3, pointY - 3, 6, 6);
        }
    }
}