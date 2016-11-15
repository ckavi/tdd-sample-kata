package com.bowling;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ScoreBoard {

    private final int[][] frames = new int[12][2];

    public void setFrame(int frame,int[] rolls ){
        frames[frame] = rolls;
    }

    public int getTotalScore(){

        int score = 0;

        for(int f=0; f<10;f++){

            int[] frame =  frames[f];

            if( frame[0]+frame[1] <10 ){
                score+= frame[0]+frame[1];
            }
            else if(frame[0]+frame[1] ==10){ // strike or spare
               score += 10 + frames[f+1][0];

                if(frame[0] ==10){ //strike; if first ball is strike, then check the next frame's first ball
                   score += (frames[f+1][0]==10? frames[f+2][0]:frames[f+1][1]);
                }
            }
        }

        return score;
    }
}
