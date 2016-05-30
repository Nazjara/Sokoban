package com.nazjara.model;

import com.nazjara.controller.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nazar on 10.03.2016.
 */
public class LevelLoader
{
    public LevelLoader()
    {

    }

    public GameObjects getLevel(int level)
    {
        Set<Home> homes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Player player = null;
        int x;
        int y = Model.FIELD_SELL_SIZE / 2;
        ArrayList<String> list = Controller.getListWithLevels();
        try
        {
            int startIndex = list.indexOf(String.format("Maze: %d", level))+1;
            int finishIndex;
            if(level == 60)
                finishIndex = list.size()-1;
            else
                finishIndex = list.indexOf(String.format("Maze: %d", level+1))-1;
            for(int q = startIndex; q < finishIndex; q++)
            {
                char[]arr = list.get(q).toCharArray();
                x = Model.FIELD_SELL_SIZE / 2;
                for(char i : arr)
                {
                    switch (i)
                    {
                        case 'X': walls.add(new Wall(x,y));
                            break;
                        case '*': boxes.add(new Box(x,y));
                            break;
                        case '.': homes.add(new Home(x,y));
                            break;
                        case '&': homes.add(new Home(x,y));
                            boxes.add(new Box(x,y));
                            break;
                        case '@': player = new Player(x,y);
                            break;
                    }
                    x+=Model.FIELD_SELL_SIZE;
                }
                y+=Model.FIELD_SELL_SIZE;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new GameObjects(walls,boxes,homes,player);
    }
}
