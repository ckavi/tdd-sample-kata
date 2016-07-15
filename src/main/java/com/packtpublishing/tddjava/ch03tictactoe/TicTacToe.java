package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by cihan on 23/06/16.
 */
public class TicTacToe {

    private int playCount = 0;
    private static final char EMPTY = '\0';
    private char currentPlayer = EMPTY;
    private char[][] board = {{EMPTY,EMPTY,EMPTY},{EMPTY,EMPTY,EMPTY},{EMPTY,EMPTY,EMPTY}};

    private void checkAxis(int axis){
        if (axis < 1 || axis > 3) {
            throw
                    new RuntimeException("X is outside board");
        }
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != EMPTY) {
            throw
                    new RuntimeException("Box is occupied");
        } else {
            playCount++;
            board[x - 1][y - 1] = currentPlayer;
        }
    }

    public String checkWin(){

        //diagonal
        if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer )
            return currentPlayer + " is the winner";

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer )
            return currentPlayer + " is the winner";

        for (int index = 0; index < 3; index++) {

            if (board[index][0] == currentPlayer &&
                    board[index][1] == currentPlayer &&
                    board[index][2] == currentPlayer) { //vertical
                return currentPlayer + " is the winner";
            }

            if (board[0][index] == currentPlayer &&
                    board[1][index] == currentPlayer &&
                    board[2][index] == currentPlayer) { //horizontal
                return currentPlayer + " is the winner";
            }
        }

        if(playCount==9){ //draw
            return "The result is draw";
        }

        return "No Winner";
    }

    public char nextPlayer(){
        if( currentPlayer == 'O' || currentPlayer == EMPTY)
            return currentPlayer = 'X';
        else
            return currentPlayer = 'O';
    }

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x,y);
        String status = checkWin();

        if(status.equals("No Winner")){
            nextPlayer();
        }

        return status;
    }
}
