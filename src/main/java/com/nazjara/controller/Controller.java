package com.nazjara.controller;

import com.nazjara.model.Direction;
import com.nazjara.model.GameObjects;
import com.nazjara.model.Model;
import com.nazjara.model.TextFileLoader;
import com.nazjara.view.View;

import java.util.ArrayList;

/**
 * Created by Nazar on 09.03.2016.
 */
public class Controller implements EventListener
{
    private View view;
    private Model model;
    private static TextFileLoader fileLoader;

    public Controller()
    {
        fileLoader = new TextFileLoader();
        this.view = new View(this);
        this.model = new Model();
        model.restart();
        view.init();
        view.setEventListener(this);
        model.setEventListener(this);
    }

    public static void main(String[]args)
    {
        Controller controller = new Controller();
    }

    public static ArrayList<String> getListWithLevels()
    {
        return fileLoader.getList();
    }

    @Override
    public void move(Direction direction)
    {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart()
    {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel()
    {
        model.startNextLevel();
        view.update();
        view.setTitle(model.getCurrentLevel()-1);
    }

    @Override
    public void startPreviousLevel()
    {
        model.startPreviousLevel();
        view.update();
        view.setTitle(model.getCurrentLevel()-1);
    }

    @Override
    public void levelCompleted(int level)
    {
        view.completed(level);
    }

    public GameObjects getGameObjects()
    {
        return model.getGameObjects();
    }

}
