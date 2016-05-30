package com.nazjara.model;

import java.awt.*;

/**
 * Created by Nazar on 10.03.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.GRAY);
        graphics.fill3DRect(this.getX(),this.getY(),this.getWidth(),this.getHeight(),false);
    }
}
