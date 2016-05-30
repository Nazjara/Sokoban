package com.nazjara.model;

import com.sun.javafx.scene.control.skin.ColorPalette;

import java.awt.*;

/**
 * Created by Nazar on 10.03.2016.
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(getX()+x);
        this.setY(getY()+y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.yellow);
        graphics.fill3DRect(this.getX(),this.getY(),this.getWidth(),this.getHeight(),true);
    }
}
