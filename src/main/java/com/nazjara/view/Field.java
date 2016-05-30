package com.nazjara.view;

import com.nazjara.controller.EventListener;
import com.nazjara.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Created by Nazar on 10.03.2016.
 */
public class Field extends JPanel
{
    private View view;
    private EventListener eventListener;

    public Field(View view)
    {
        this.view = view;
        KeyHandler handler = new KeyHandler();
        addKeyListener(handler);
        setFocusable(true);
    }

    public class KeyHandler extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_LEFT: eventListener.move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT: eventListener.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP: eventListener.move(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN: eventListener.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_R: eventListener.restart();
                    break;
                case KeyEvent.VK_N: eventListener.startNextLevel();
                    break;
                case KeyEvent.VK_P: eventListener.startPreviousLevel();
                    break;
            }
        }
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,620,500);
        GameObjects gameObjects = view.getGameObjects();
        Set<GameObject> set =  gameObjects.getAll();
        for(GameObject obj : set)
        {
            obj.draw(g);
        }
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
}
