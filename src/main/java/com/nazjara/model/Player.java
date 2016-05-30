package com.nazjara.model;

import java.awt.*;

/**
 * Created by Nazar on 10.03.2016.
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
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
        graphics.setColor(Color.RED);
        graphics.fillOval(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
