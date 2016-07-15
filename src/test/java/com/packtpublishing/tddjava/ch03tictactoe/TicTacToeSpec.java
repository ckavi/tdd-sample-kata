package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.*;



/**
 * Created by cihan on 23/06/16.
 */
public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;
    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException()
    {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException()
    {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void givenFirstTurnThenNextPlayerIsX()
    {
        assertEquals(ticTacToe.nextPlayer(),'X');
    }

    @Test
    public void givenCurrentTurnXThenNextPlayerIsO()
    {
        ticTacToe.nextPlayer();
        assertEquals(ticTacToe.nextPlayer(),'O');
    }

    @Test
    public void givenCurrentTurnOThenNextPlayerIsX()
    {
        ticTacToe.nextPlayer();
        ticTacToe.nextPlayer();
        assertEquals(ticTacToe.nextPlayer(),'X');
    }

    @Test
    public void whenPlayThenNoWinner()
    {
        ticTacToe.nextPlayer();
       String response =  ticTacToe.play(1, 2);
       assertEquals(response,"No Winner");
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.nextPlayer();
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(1, 2); // X
        ticTacToe.play(2, 3); // O
        String actual = ticTacToe.play(1, 3); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeDiagonalLineThenWinner() {
        ticTacToe.nextPlayer();
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(2, 3); // O
        String actual = ticTacToe.play(3, 3); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.nextPlayer();
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 3); // O
        String actual = ticTacToe.play(3, 1); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        ticTacToe.nextPlayer();
        ticTacToe.play(1, 3); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 2); // O
        String actual = ticTacToe.play(3, 1); // O
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw() {
        ticTacToe.nextPlayer();
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(1, 3);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 3);
        ticTacToe.play(2, 2);
        ticTacToe.play(3, 1);
        ticTacToe.play(3, 3);
        String actual = ticTacToe.play(3, 2);
        assertEquals("The result is draw", actual);
    }

    @Test
    public void whenCellIsOccupiedThenRuntimeException()
    {
        ticTacToe.nextPlayer();
        ticTacToe.play(1, 2);
        exception.expect(RuntimeException.class);
        ticTacToe.play(1, 2);
    }

    @Test
    public void test()
    {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }




}
