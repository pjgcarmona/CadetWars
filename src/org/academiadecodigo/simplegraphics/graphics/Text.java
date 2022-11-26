//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.JLabel;

public class Text implements Shape, Colorable, Movable {
    private Color color;
    private JLabel label;
    private double x;
    private double y;
    private double xGrow;
    private double yGrow;

    public Text(double var1, double var3, String var5) {
        this.color = Color.BLACK;
        this.label = new JLabel();
        this.x = var1;
        this.y = var3;
        this.label.setText(var5);
    }

    public int getX() {
        return (int)Math.round(this.x - this.xGrow);
    }

    public int getY() {
        return (int)Math.round(this.y - this.yGrow);
    }

    public int getWidth() {
        return (int)Math.round(this.label.getPreferredSize().getWidth() + 2.0 * this.xGrow);
    }

    public int getHeight() {
        return (int)Math.round(this.label.getPreferredSize().getHeight() + 2.0 * this.yGrow);
    }

    public void translate(double var1, double var3) {
        this.x += var1;
        this.y += var3;
        Canvas.getInstance().repaint();
    }

    public void grow(double var1, double var3) {
        this.xGrow += var1;
        this.yGrow += var3;
        Canvas.getInstance().repaint();
    }

    public void setColor(Color var1) {
        this.color = var1;
        Canvas.getInstance().repaint();
    }

    public void setText(String var1) {
        this.label.setText(var1);
        Canvas.getInstance().repaint();
    }

    public void draw() {
        Canvas.getInstance().show(this);
    }

    public void delete() {
        Canvas.getInstance().hide(this);
    }

    public String toString() {
        int var10000 = this.getX();
        return "Text[x=" + var10000 + ",y=" + this.getY() + ",message=" + this.label.getText() + "]";
    }

    public void paintShape(Graphics2D var1) {
        if (this.color != null) {
            this.label.setForeground(new java.awt.Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue()));
            Dimension var2 = this.label.getPreferredSize();
            if (var2.width > 0 && var2.height > 0) {
                this.label.setBounds(0, 0, var2.width, var2.height);
                var1.translate(this.getX(), this.getY());
                var1.scale((double)(this.getWidth() / var2.width), (double)(this.getHeight() / var2.height));
                this.label.paint(var1);
            }
        }

    }

    public Color getColor() {
        return this.color;
    }
}
