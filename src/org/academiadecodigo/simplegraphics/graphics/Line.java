//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.graphics;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Line implements Shape, Colorable, Movable {
    private Color color;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double var1, double var3, double var5, double var7) {
        this.color = Color.BLACK;
        this.x1 = var1;
        this.x2 = var5;
        this.y1 = var3;
        this.y2 = var7;
    }

    public int getX() {
        return (int)Math.round(Math.min(this.x1, this.x2));
    }

    public int getY() {
        return (int)Math.round(Math.min(this.y1, this.y2));
    }

    public int getWidth() {
        return (int)Math.round(Math.abs(this.x2 - this.x1));
    }

    public int getHeight() {
        return (int)Math.round(Math.abs(this.y2 - this.y1));
    }

    public void translate(double var1, double var3) {
        this.x1 += var1;
        this.y1 += var3;
        this.x2 += var1;
        this.y2 += var3;
        Canvas.getInstance().repaint();
    }

    public void grow(double var1, double var3) {
        if (this.x1 <= this.x2) {
            this.x1 -= var1;
            this.x2 += var1;
        } else {
            this.x1 += var1;
            this.x2 -= var1;
        }

        if (this.y1 <= this.y2) {
            this.y1 -= var3;
            this.y2 += var3;
        } else {
            this.y1 += var3;
            this.y2 -= var3;
        }

        Canvas.getInstance().repaint();
    }

    public void setColor(Color var1) {
        this.color = var1;
        Canvas.getInstance().repaint();
    }

    public Color getColor() {
        return this.color;
    }

    public void draw() {
        Canvas.getInstance().show(this);
    }

    public void delete() {
        Canvas.getInstance().hide(this);
    }

    public void paintShape(Graphics2D var1) {
        if (this.color != null) {
            var1.setColor(new java.awt.Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue()));
            Line2D.Double var2 = new Line2D.Double(this.x1, this.y1, this.x2, this.y2);
            var1.draw(var2);
        }

    }

    public String toString() {
        return "Line[x1=" + this.x1 + ",y1=" + this.y1 + ",x2=" + this.x2 + ",y2=" + this.y2 + "]";
    }
}
