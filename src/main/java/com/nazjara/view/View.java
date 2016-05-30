package com.nazjara.view;

import com.nazjara.controller.Controller;
import com.nazjara.controller.EventListener;
import com.nazjara.model.GameObjects;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(620, 500);
        setLocationRelativeTo(null);
        setTitle("Sokoban          LEVEL 1  /  60");
        setVisible(true);
    }

    public void setTitle(int level)
    {
        this.setTitle(String.format("Sokoban          LEVEL %d  /  60",level+1));
    }

    public void setEventListener(EventListener eventListener)
    {
        field.setEventListener(eventListener);
    }

    public void update()
    {
        field.repaint();
    }

    public GameObjects getGameObjects()
    {
        return controller.getGameObjects();
    }

    public void completed(int level)
    {
        this.update();
        if(level < 60) {
            JOptionPane.showMessageDialog(null, String.format("You have completed %d level", level), "Congratulations!", 1);
            controller.startNextLevel();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You have completed the game!", "Congratulations!", 1);
            System.exit(0);
        }
    }
}
