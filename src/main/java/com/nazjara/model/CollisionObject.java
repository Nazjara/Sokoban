package com.nazjara.model;

import java.awt.*;

/**
 * Created by Nazar on 10.03.2016.
 */
public class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {

    }

    public boolean isCollision(GameObject gameObject, Direction direction)
    {
        int x1 = gameObject.getX();
        int y1 = gameObject.getY();
        int x2 = this.getX();
        int y2 = this.getY();
        switch (direction)
        {
            case UP:    y2 = this.getY()-Model.FIELD_SELL_SIZE;
                        break;
            case DOWN:  y2 = this.getY()+Model.FIELD_SELL_SIZE;
                        break;
            case LEFT:  x2 = this.getX()-Model.FIELD_SELL_SIZE;
                        break;
            case RIGHT:  x2 = this.getX()+Model.FIELD_SELL_SIZE;
                         break;
        }
        return x1 == x2 && y1 == y2;
    }
}
