package com.nazjara.controller;

import com.nazjara.model.Direction;

/**
 * Created by Nazar on 10.03.2016.
 */
public interface EventListener
{
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void startPreviousLevel();
    void levelCompleted(int level);
}
