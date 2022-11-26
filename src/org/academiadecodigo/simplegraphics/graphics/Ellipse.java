//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.graphics;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse implements Shape, Colorable, Fillable, Movable {
    private Color color;
    private boolean filled;
    private double x;
    private double y;
    private double width;
    private double height;

    public Ellipse(double var1, double var3, double var5, double var7) {
        this.color = Color.BLACK;
        this.filled = false;
        this.x = var1;
        this.y = var3;
        this.width = var5;
        this.height = var7;
    }

    public int getX() {
        return (int)Math.round(this.x);
    }

    public int getY() {
        return (int)Math.round(this.y);
    }

    public int getWidth() {
        return (int)Math.round(this.width);
    }

    public int getHeight() {
        return (int)Math.round(this.height);
    }

    public void translate(double var1, double var3) {
        this.x += var1;
        this.y += var3;
        Canvas.getInstance().repaint();
    }

    public void grow(double var1, double var3) {
        this.width += 2.0 * var1;
        this.height += 2.0 * var3;
        this.x -= var1;
        this.y -= var3;
        Canvas.getInstance().repaint();
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color var1) {
        this.color = var1;
        Canvas.getInstance().repaint();
    }

    public void draw() {
        this.filled = false;
        Canvas.getInstance().show(this);
    }

    public void delete() {
        Canvas.getInstance().hide(this);
    }

    public void fill() {
        this.filled = true;
        Canvas.getInstance().show(this);
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void paintShape(Graphics2D var1) {
        Ellipse2D.Double var2 = new Ellipse2D.Double((double)this.getX(), (double)this.getY(), (double)this.getWidth(), (double)this.getHeight());
        var1.setColor(new java.awt.Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue()));
        if (this.filled) {
            var1.fill(var2);
        } else {
            var1.draw(var2);
        }

    }

    public String toString() {
        int var10000 = this.getX();
        return "Rectangle[x=" + var10000 + ",y=" + this.getY() + ",width=" + this.getWidth() + ",height=" + this.getHeight() + "]";
    }
}
