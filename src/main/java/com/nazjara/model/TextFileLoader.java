package com.nazjara.model;

import com.nazjara.controller.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Nazar on 24.05.2016.
 */
public class TextFileLoader
{
    private ArrayList<String> list;

    public TextFileLoader()
    {
        list = new ArrayList<>();
        getAllLevels(list);
    }

    public ArrayList<String> getList()
    {
        return list;
    }

    public void getAllLevels(ArrayList<String> list)
    {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Controller.class.getResourceAsStream("/levels.txt"))))
        {
            String s;
            while ((s = reader.readLine()) != null)
            {
                list.add(s);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
