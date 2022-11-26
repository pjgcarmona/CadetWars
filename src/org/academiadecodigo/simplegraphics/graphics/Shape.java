//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.graphics;

import java.awt.Graphics2D;

public interface Shape {
    int getX();

    int getY();

    int getWidth();

    int getHeight();

    void draw();

    void delete();

    void grow(double var1, double var3);

    void paintShape(Graphics2D var1);
}
