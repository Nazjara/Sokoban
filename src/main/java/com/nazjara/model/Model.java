package com.nazjara.model;

import com.nazjara.controller.EventListener;

import static com.nazjara.model.Direction.*;

/**
 * Created by Nazar on 09.03.2016.
 */
public class Model
{
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader();
    public static final int FIELD_SELL_SIZE = 20;

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level)
    {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        if(currentLevel == 60)
            eventListener.levelCompleted(60);
        else
        {
            currentLevel++;
            restart();
        }
    }

    public void startPreviousLevel()
    {
        if(currentLevel != 1)
        {
            currentLevel--;
            restart();
        }
    }

    public void move(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        if(checkWallCollision(player,direction))
            return;
        if(checkBoxCollision(direction))
            return;
        if(direction.equals(UP))
            player.move(0,-FIELD_SELL_SIZE);
        else if(direction.equals(DOWN))
            player.move(0,FIELD_SELL_SIZE);
        else if(direction.equals(RIGHT))
            player.move(FIELD_SELL_SIZE,0);
        else
            player.move(-FIELD_SELL_SIZE,0);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {
        for(Wall wall : gameObjects.getWalls())
        {
            if(gameObject.isCollision(wall,direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        for(Box box : gameObjects.getBoxes())
        {
            if(player.isCollision(box,direction))
            {
                if(checkWallCollision(box,direction))
                    return true;
                else
                {
                    gameObjects.getBoxes().remove(box);
                    for(Box box1: gameObjects.getBoxes())
                    {
                        if(box.isCollision(box1,direction))
                        {
                            gameObjects.getBoxes().add(box);
                            return true;
                        }
                    }
                    gameObjects.getBoxes().add(box);
                }
                if(direction.equals(UP))
                    box.move(0,-FIELD_SELL_SIZE);
                else if(direction.equals(DOWN))
                    box.move(0,FIELD_SELL_SIZE);
                else if(direction.equals(RIGHT))
                    box.move(FIELD_SELL_SIZE,0);
                else
                    box.move(-FIELD_SELL_SIZE,0);
                return false;
            }
        }
        return false;
    }

    public void checkCompletion()
    {
        int match = 0;
        for(Home home : gameObjects.getHomes())
        {
            for(Box box : gameObjects.getBoxes())
            {
                if(box.getX() == home.getX() && box.getY() == home.getY())
                    match++;
            }
        }
        if(match == gameObjects.getHomes().size())
        {
            eventListener.levelCompleted(currentLevel);
        }

    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}
