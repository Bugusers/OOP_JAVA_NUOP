package lab7;

import java.awt.*;
import javax.swing.*;

public class RectanglePointLocation extends JPanel {
    // Координати вершин прямокутника
    int x1, y1, x2, y2;
    // Координати точки
    int px, py;

    public RectanglePointLocation(int x1, int y1, int x2, int y2, int px, int py) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.px = px;
        this.py = py;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Накресліть прямокутник
        g.drawRect(x1, y1, x2 - x1, y2 - y1);

        // Накресліть точку
        g.setColor(Color.RED);
        g.fillOval(px - 2, py - 2, 4, 4);

        // Визначте сторону прямокутника, на якій лежить точка
        String location = getPointLocation();

        // Виведіть текст завдання та відповідь
        g.setColor(Color.BLACK);
//        g.drawString("Задано координати вершин прямокутника і координати точки:", 10, 20);
//        g.drawString("Вершина A (" + x1 + ", " + y1 + ")", 10, 40);
//        g.drawString("Вершина B (" + x2 + ", " + y1 + ")", 10, 60);
//        g.drawString("Вершина C (" + x2 + ", " + y2 + ")", 10, 80);
//        g.drawString("Вершина D (" + x1 + ", " + y2 + ")", 10, 100);
//        g.drawString("Точка P (" + px + ", " + py + ")", 10, 120);
//        g.drawString("Точка лежить на стороні: " + location, 10, 140);
    }

    private String getPointLocation() {
        if (px < x1 || px > x2 || py < y1 || py > y2) {
            return "поза прямокутником";
        } else if (px == x1 || px == x2 || py == y1 || py == y2) {
            return "на граничній стороні";
        } else {
            return "всередині прямокутника";
        }
    }


}