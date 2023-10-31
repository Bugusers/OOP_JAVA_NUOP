package lab7;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int x1 = 10, y1 = 10, x2 = 50, y2 = 30; // Координати вершин прямокутника
        int px = 20, py = 20; // Координати точки

        JFrame frame = new JFrame("Визначення локації точки в прямокутнику");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectanglePointLocation panel = new RectanglePointLocation(x1, y1, x2, y2, px, py);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}