package com.gameoflife;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;

import static com.google.common.base.Preconditions.*;

/**
 * Created by cihan on 15/11/2016.
 */
@ParametersAreNonnullByDefault
public final class GameOfLife {

    private final Table<Integer,Integer,Cell> board;
    private final int maxGeneration;
    private int currentGeneration;

    public GameOfLife(int row, int column, int maxGeneration, int[][] initialLiveCells) {
        checkArgument(row>0,"row should be bigger than 0");
        checkArgument(column>0,"column should be bigger than 0");
        checkArgument(maxGeneration>=0,"maxGeneration should be bigger than 0");
        checkArgument(initialLiveCells.length>0,"initial live cells should not be empty");
        this.currentGeneration = 0;

        board = HashBasedTable.create(row+10,column+10);
        this.maxGeneration = maxGeneration;

        for (int x=-10; x<row;x++){
            for (int y=0; y<column;y++){
                if(!board.contains(x,y)){
                    board.put(x,y,new Cell(x,y,0));
                }
            }
        }

        Arrays.stream(initialLiveCells).forEach(c->{
            checkArgument( c[0] >=0 && c[1] >=0 && c[0]<row && c[1] < column,"initial board is wrong");
            board.get(c[0],c[1]).setValue(1);
        });

    }

    int getAliveNeighbourCount(int x, int y ){
        int count =0;
        for(Direction d: Direction.values()){
            Cell c = board.get(x+d.dx,y+d.dy);
            count+= c!=null?c.getValue(currentGeneration):0;
        }

        return count;
    }

    public boolean processNextGeneration() {

        if(currentGeneration < maxGeneration ){
            board.values().forEach(c -> {

                int aliveNeighbourCount = getAliveNeighbourCount(c.getX(),c.getY());

                if(c.getValue()==1){
                    if(aliveNeighbourCount==1 || aliveNeighbourCount>=4){
                        c.setNextValue(0);
                    }
                    else
                        c.setNextValue(1);
                }
                else if(aliveNeighbourCount==3)
                    c.setNextValue(1);
                else
                    c.setNextValue(0);
            });

            currentGeneration++;
            return true;
        }
        else
            return false;
    }


    public Cell getCell(int x, int y) {
        return board.get(x,y);
    }
}
