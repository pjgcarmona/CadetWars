//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tester implements KeyboardHandler, MouseHandler {
    public Tester() {
    }

    public static void main(String[] var0) throws InterruptedException {
        Tester var1 = new Tester();
        var1.test();
    }

    public void test() throws InterruptedException {
        Keyboard var1 = new Keyboard(this);
        KeyboardEvent var2 = new KeyboardEvent();
        var2.setKey(32);
        var2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        var1.addEventListener(var2);
        Mouse var3 = new Mouse(this);
        var3.addEventListener(MouseEventType.MOUSE_CLICKED);
        var3.addEventListener(MouseEventType.MOUSE_MOVED);
        Rectangle var4 = new Rectangle(10.0, 10.0, 400.0, 400.0);
        var4.setColor(Color.BLACK);
        var4.draw();
        Rectangle var5 = new Rectangle(50.0, 50.0, 100.0, 100.0);
        var5.setColor(Color.RED);
        var5.fill();
        Ellipse var6 = new Ellipse(30.0, 30.0, 50.0, 60.0);
        var6.setColor(Color.YELLOW);
        var6.fill();
        Line var7 = new Line(200.0, 200.0, 300.0, 250.0);
        var7.setColor(Color.BLUE);
        var7.draw();
        Text var8 = new Text(20.0, 180.0, "Simple Graphics");
        var8.setColor(Color.MAGENTA);
        var8.draw();
        Picture var9 = new Picture(20.0, 220.0, "http://static0.bigstockphoto.com/thumbs/3/5/2/small2/25346960.jpg");
        var9.draw();
        Thread.sleep(2000L);
        var5.translate(100.0, 0.0);
        var6.translate(20.0, 20.0);
        var7.translate(20.0, -10.0);
        var8.translate(20.0, 20.0);
        var9.translate(40.0, 0.0);
        Thread.sleep(2000L);
        var5.grow(10.0, 10.0);
        var6.grow(-20.0, -20.0);
        var7.grow(10.0, 10.0);
        var8.grow(5.0, 5.0);
        var9.grow(-50.0, -50.0);
        Thread.sleep(2000L);
        var8.setText("Academia de Codigo");
    }

    public void keyPressed(KeyboardEvent var1) {
        System.out.println("SPACE KEY PRESSED");
    }

    public void keyReleased(KeyboardEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
        System.out.println(var1);
    }

    public void mouseMoved(MouseEvent var1) {
        System.out.println(var1);
    }
}
