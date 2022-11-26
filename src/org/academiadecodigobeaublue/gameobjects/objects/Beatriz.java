package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Beatriz extends GameObjects {
    public Beatriz() {
        super(36,50);
        this.picture = new Picture(getX(), getY(), "Beatriz2.png");
    }
}
