package com.gameoflife;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * Created by cihan on 15/11/2016.
 */
public class Cell {

    private final int x;
    private final int y;
    private final List<Integer> generations;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.generations = Lists.newArrayList();
        generations.add(value);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue(){
        return getValue(generations.size()-1);
    }

    public int setValue(int val){
        return generations.set(generations.size()-1,val);
    }

    public void setNextValue(int val){
         generations.add(val);
    }

    public int getValue(int generation){
        return generations.get(generation);
    }

}
