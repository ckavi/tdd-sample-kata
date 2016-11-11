package com.bowling;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Created by cihan on 11/11/2016.
 */
@ParametersAreNonnullByDefault
public class ScoreBoard {

    private int[][] frames = new int[12][2];

    public ScoreBoard() {
        for(int i = 0 ; i < frames.length;i++){
            frames[i][0] = frames[i][1] = 0;
        }
    }

    public void setFrame(int frame,int[] rolls ){
        frames[frame] = rolls;
    }

    public int getTotalScore(){

        int score = 0;

        for(int f=0; f<10;f++){

           int[] frame =  frames[f];

            if( frame[0] == 0 && frame[1] == 0 ){ //what can i do sometimes
                continue;
            }

            if(frame[0] ==10){ //strike
                int nextBall = frames[f+1][0];
                score += 10 + nextBall + (nextBall==10? frames[f+2][0]:frames[f+1][1]);

            }
            else if (frame[0]+frame[1] ==10){ //spare
                score += 10 + frames[f+1][0];
            }
            else //otherwise
                score+= frame[0]+frame[1];
        }

        return score;
    }
}
