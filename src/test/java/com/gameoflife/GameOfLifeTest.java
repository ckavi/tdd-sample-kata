package com.gameoflife;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by cihan on 15/11/2016.
 */
public class GameOfLifeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void When_RowOrColumnSizeIs0_Expect_Exception(){
        exception.expect(IllegalArgumentException.class);
        GameOfLife board = new GameOfLife(0,0, 1,  new int[][]{});
    }

    @Test
    public void When_MaxGenerationBelow0_Expect_Exception(){
        exception.expect(IllegalArgumentException.class);
        GameOfLife board = new GameOfLife(1,1,-1, new int[][]{});
    }

    @Test
    public void When_InitialLiveCellsNotInBoard_Expect_Exception(){
         int[][] initialLiveCells = new int[][]{{1,2},{1,5}};

        exception.expect(IllegalArgumentException.class);
        GameOfLife board = new GameOfLife(3,5,0, initialLiveCells);
    }

    @Test
    public void When_InitialLiveCellEmpty_Expect_Exception(){
        int[][] initialLiveCells = new int[][]{};

        exception.expect(IllegalArgumentException.class);
        GameOfLife board = new GameOfLife(3,5,0, initialLiveCells);
    }

    @Test
    public void When_StartGenerationChecked_Expect_GivenInitialLiveCellsAlive(){
        int[][] initialLiveCells = new int[][]{{1,3}};
        GameOfLife board = new GameOfLife(3,5,0, initialLiveCells);
        assertEquals(board.getCell(1,3).getValue(),1);
    }

    @Test
    public void When_ACellHas3AliveNeighbours_Expect_3Neighbours() throws Exception {
        int[][] initialLiveCells = new int[][]{{0,1},{1,1},{1,0}};
        GameOfLife board = new GameOfLife(3,5,0, initialLiveCells);
        assertEquals(board.getAliveNeighbourCount(0,0),3);
    }

    @Test
    public void When_ACellHasOnlyAliveNeighbours_Expect_8Neighbours() throws Exception {
        int[][] initialLiveCells = new int[][]{{0,0},{1,0},{2,0},{0,1},{2,1},{0,2},{1,2},{2,2}};
        GameOfLife board = new GameOfLife(8,8,0, initialLiveCells);
        assertEquals(board.getAliveNeighbourCount(1,1),8);
    }

    @Test
    public void When_LiveCellHas1OrNoNeighbour_Expect_CellDie(){
        int[][] initialLiveCells = new int[][]{{1,1},{0,0}};

        GameOfLife board = new GameOfLife(3,5,1, initialLiveCells);

        assertEquals(board.getCell(0,0).getValue(),1);
        board.processNextGeneration();
        assertEquals(board.getCell(0,0).getValue(),0);
    }

    @Test
    public void When_LiveCellHas4OrMoreNeighbour_Expect_CellDie(){
        int[][] initialLiveCells = new int[][]{{0,0},{1,1},{1,0},{2,0},{0,1},{2,1},{0,2},{1,2},{2,2}};
        GameOfLife board = new GameOfLife(8,8,4, initialLiveCells);
        board.processNextGeneration();
        assertEquals(board.getCell(1,1).getValue(),0);
    }

    @Test
    public void When_LiveCellHas2Or3Neighbours_Expect_CellSurvive(){
        int[][] initialLiveCells = new int[][]{{0,0},{1,1},{1,0},{2,0}};
        GameOfLife board = new GameOfLife(8,8,4, initialLiveCells);
        board.processNextGeneration();
        assertEquals(board.getCell(1,1).getValue(),1);
    }

    @Test
    public void When_LiveCellHas3Neighbours_Expect_CellPopulated(){
        int[][] initialLiveCells = new int[][]{{0,0},{1,0},{2,0}};
        GameOfLife board = new GameOfLife(8,8,4, initialLiveCells);
        assertEquals(board.getCell(1,1).getValue(),0);
        board.processNextGeneration();
        assertEquals(board.getCell(1,1).getValue(),1);
    }

    @Test
    public void When_MaxGenerationIs2_Expect_2SuccessfulCallsOfGenerationProcess(){
        int loopCount = 0;
        int[][] initialLiveCells = new int[][]{{0,0},{1,0},{2,0}};
        GameOfLife board = new GameOfLife(8,8,2, initialLiveCells);

          while (board.processNextGeneration()){
              loopCount++;
          }
        assertTrue(loopCount==2);
    }

    @Test
    public void When_BoardPrinted_Expect_FollowingOutput(){

        String output = "[0][1][0]\n[0][1][0]\n[0][1][0]";
        int[][] initialLiveCells = new int[][]{{0,1},{1,1},{2,1}};
        GameOfLife board = new GameOfLife(3,3,1, initialLiveCells);
        board.processNextGeneration();
        assertEquals(output,board.print());
    }
}
