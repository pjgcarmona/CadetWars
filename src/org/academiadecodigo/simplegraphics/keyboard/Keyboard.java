//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Keyboard implements KeyListener {
    KeyboardHandler handler;
    List<KeyboardEvent> keyboardEventArrayList;

    public Keyboard(KeyboardHandler var1) {
        Canvas.getInstance().addKeyListener(this);
        this.handler = var1;
        this.keyboardEventArrayList = new ArrayList();
    }

    public void addEventListener(KeyboardEvent var1) {
        this.keyboardEventArrayList.add(var1);
    }

    public void removeEventListener(KeyboardEvent var1) {
        this.keyboardEventArrayList.remove(var1);
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void keyPressed(KeyEvent var1) {
        if (this.handler != null) {
            Iterator var2 = this.keyboardEventArrayList.iterator();

            while(var2.hasNext()) {
                KeyboardEvent var3 = (KeyboardEvent)var2.next();
                if (var3.getKeyboardEventType() == KeyboardEventType.KEY_PRESSED && var3.getKey() == var1.getKeyCode()) {
                    this.handler.keyPressed(var3);
                }
            }

        }
    }

    public void keyReleased(KeyEvent var1) {
        if (this.handler != null) {
            Iterator var2 = this.keyboardEventArrayList.iterator();

            while(var2.hasNext()) {
                KeyboardEvent var3 = (KeyboardEvent)var2.next();
                if (var3.getKeyboardEventType() == KeyboardEventType.KEY_RELEASED && var3.getKey() == var1.getKeyCode()) {
                    this.handler.keyReleased(var3);
                }
            }

        }
    }
}
