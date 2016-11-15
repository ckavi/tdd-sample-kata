package com.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cihan on 11/11/2016.
 */
public class ScoreBoardTest {

    private ScoreBoard board = new ScoreBoard();

    @Test
    public void When_AllRollMisses_Expect_ScoreIs0(){;

       assertEquals(board.getTotalScore(),0);
    }

    @Test
    public void When_1PinDroppedForEachRoll_Expect_ScoreIs20(){

        int[] twoPinDrop = new int[]{1,1};

        for(int i =0; i<10;i++)
            board.setFrame(i,twoPinDrop);

        assertEquals(board.getTotalScore(),20);
    }


    @Test
    public void When_SpareThen3PinsThenAllMiss_Expect_Score16(){

        int[] spare = new int[]{1,9};
        int[] threePin = new int[]{3,0};
        int[] allMiss = new int[]{0,0};

        board.setFrame(0, spare );
        board.setFrame(1, threePin );
        board.setFrame(2, allMiss);


        assertEquals(board.getTotalScore(),16);
    }

    @Test
    public void When_StrikeThen3Ang4PinsThenAllMiss_Expect_Score26(){

        int[] spare = new int[]{10,0};
        int[] threeAnd4Pin = new int[]{3,4};

        board.setFrame(0, spare );
        board.setFrame(1, threeAnd4Pin );

        assertEquals(board.getTotalScore(),24);
    }

    @Test
    public void When_12Strike_Expect_Score300(){

        int[] strike = new int[]{10,0};

        for(int i =0; i<12;i++)
            board.setFrame(i,strike);

        assertEquals(board.getTotalScore(),300);
    }

}
