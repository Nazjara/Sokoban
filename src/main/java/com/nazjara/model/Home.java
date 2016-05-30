package com.nazjara.model;

import java.awt.*;

/**
 * Created by Nazar on 10.03.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
        //this.setHeight(2);
        //this.setWidth(2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.BLUE);
        graphics.draw3DRect(this.getX(),this.getY(),this.getWidth(),this.getHeight(),false);
    }
}
