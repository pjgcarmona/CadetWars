//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.pictures;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class Picture implements Shape, Movable {
    private BufferedImage image;
    private JLabel label = new JLabel();
    private String source;
    private double x;
    private double y;
    private double xGrow;
    private double yGrow;

    public Picture() {
    }

    public Picture(double var1, double var3) {
        this.image = new BufferedImage((int)Math.round(var1), (int)Math.round(var3), 1);
        this.label.setIcon(new ImageIcon(this.image));
        this.label.setText("");
    }

    public Picture(double var1, double var3, String var5) {
        this.x = var1;
        this.y = var3;
        this.load(var5);
    }

    public Picture(int[][] var1) {
        this.image = new BufferedImage(var1[0].length, var1.length, 1);

        for(int var2 = 0; var2 < this.image.getWidth(); ++var2) {
            for(int var3 = 0; var3 < this.image.getHeight(); ++var3) {
                int var4 = var1[var3][var2];
                if (var4 < 0) {
                    var4 = 0;
                }

                if (var4 > 255) {
                    var4 = 255;
                }

                int var5 = var4 * 65793;
                this.image.setRGB(var2, var3, var5);
            }
        }

        this.label.setIcon(new ImageIcon(this.image));
        this.label.setText("");
    }

    public void load(String var1) {
        try {
            this.source = var1;
            if (var1.startsWith("http://")) {
                this.image = ImageIO.read((new URL(var1)).openStream());
            } else {
                URL var2 = this.getClass().getResource(var1.startsWith("/") ? var1 : "/" + var1);
                if (var2 != null) {
                    this.image = ImageIO.read(var2.openStream());
                } else {
                    this.image = ImageIO.read(new File(var1));
                }
            }

            this.label.setIcon(new ImageIcon(this.image));
            this.label.setText("");
        } catch (Exception var3) {
            this.image = null;
            this.label.setIcon((Icon)null);
            var3.printStackTrace();
        }

        Canvas.getInstance().repaint();
    }

    public int getX() {
        return (int)Math.round(this.x - this.xGrow);
    }

    public int getY() {
        return (int)Math.round(this.y - this.yGrow);
    }

    public int getMaxX() {
        return this.getX() + this.getWidth();
    }

    public int getMaxY() {
        return this.getY() + this.getHeight();
    }

    public int getWidth() {
        return (int)Math.round((double)(this.image == null ? 0 : this.image.getWidth()) + 2.0 * this.xGrow);
    }

    public int getHeight() {
        return (int)Math.round((double)(this.image == null ? 0 : this.image.getHeight()) + 2.0 * this.yGrow);
    }

    public int pixels() {
        return this.image == null ? 0 : this.image.getWidth() * this.image.getHeight();
    }

    public int[][] getGrayLevels() {
        if (this.image == null) {
            return new int[0][0];
        } else {
            int[][] var1 = new int[this.getHeight()][this.getWidth()];

            for(int var2 = 0; var2 < var1.length; ++var2) {
                for(int var3 = 0; var3 < var1[var2].length; ++var3) {
                    int var4 = this.image.getRGB(var3, var2);
                    var1[var2][var3] = (int)(0.2989 * (double)(var4 >> 16 & 255) + 0.5866 * (double)(var4 >> 8 & 255) + 0.1144 * (double)(var4 & 255));
                }
            }

            return var1;
        }
    }

    public String toString() {
        int var10000 = this.getX();
        return "Picture[x=" + var10000 + ",y=" + this.getY() + ",width=" + this.getWidth() + ",height=" + this.getHeight() + ",source=" + this.source + "]";
    }

    public Color getColorAt(int var1) {
        if (this.image != null && var1 >= 0 && var1 < this.pixels()) {
            return this.getColorAt(var1 % this.image.getWidth(), var1 / this.image.getWidth());
        } else {
            throw new IndexOutOfBoundsException("" + var1);
        }
    }

    public void setColorAt(int var1, Color var2) {
        if (this.image != null && var1 >= 0 && var1 < this.pixels()) {
            this.setColorAt(var1 % this.image.getWidth(), var1 / this.image.getWidth(), var2);
        } else {
            throw new IndexOutOfBoundsException("" + var1);
        }
    }

    public Color getColorAt(int var1, int var2) {
        if (this.image != null && var1 >= 0 && var1 < this.image.getWidth() && var2 >= 0 && var2 < this.image.getHeight()) {
            int var3 = this.image.getRGB(var1, var2) & 16777215;
            return new Color(var3 / 65536, var3 / 256 % 256, var3 % 256);
        } else {
            throw new IndexOutOfBoundsException("(" + var1 + "," + var2 + ")");
        }
    }

    public void setColorAt(int var1, int var2, Color var3) {
        if (this.image != null && var1 >= 0 && var1 < this.image.getWidth() && var2 >= 0 && var2 < this.image.getHeight()) {
            this.image.setRGB(var1, var2, var3.getRed() * 65536 + var3.getGreen() * 256 + var3.getBlue());
            Canvas.getInstance().repaint();
        } else {
            throw new IndexOutOfBoundsException("(" + var1 + "," + var2 + ")");
        }
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

    public void draw() {
        Canvas.getInstance().show(this);
    }

    public void delete() {
        Canvas.getInstance().hide(this);
    }

    public void paintShape(Graphics2D var1) {
        if (this.image != null) {
            Dimension var2 = this.label.getPreferredSize();
            if (var2.width > 0 && var2.height > 0) {
                this.label.setBounds(0, 0, var2.width, var2.height);
                var1.translate(this.getX(), this.getY());
                var1.scale(((double)this.image.getWidth() + 2.0 * this.xGrow) / (double)var2.width, ((double)this.image.getHeight() + 2.0 * this.yGrow) / (double)var2.height);
                this.label.paint(var1);
            }
        }

    }
}
