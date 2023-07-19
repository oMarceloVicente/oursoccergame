package org.academiadecodigo.oursoccergame;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Score {

    private Picture[] ballPosition = new Picture[10];
    private Picture[] notGoal = new Picture[10];
    private int counter = 0;
    private int kickCounterTeam1 = 0;
    private int kickCounterTeam2 = 0;
    private int goalCounterTeam1 = 0;
    private int goalCounterTeam2 = 0;
    private final Picture Player1wins;
    private final Picture Player2wins;
    private Picture Player1turn;
    private Picture Player2turn;
    private final Picture draw;
    private Picture scoreBoard;
    private boolean playerwin;
    private Picture pressR;



    //Constructor
    public Score() {

        playerwin = false;

        //Creating the "score board" and draw it
        scoreBoard = new Picture(470, 850, "resources/ScoreBoard.jpg");

        //Filling the array with the goalScore positions
        ballPosition[0] = new Picture(513, 868, "resources/ScoreBall.png");
        ballPosition[1] = new Picture(1387, 868, "resources/ScoreBall.png");
        ballPosition[2] = new Picture(601, 868, "resources/ScoreBall.png");
        ballPosition[3] = new Picture(1299, 868, "resources/ScoreBall.png");
        ballPosition[4] = new Picture(689, 868, "resources/ScoreBall.png");
        ballPosition[5] = new Picture(1211, 868, "resources/ScoreBall.png");
        ballPosition[6] = new Picture(776, 868, "resources/ScoreBall.png");
        ballPosition[7] = new Picture(1123, 868, "resources/ScoreBall.png");
        ballPosition[8] = new Picture(865, 868, "resources/ScoreBall.png");
        ballPosition[9] = new Picture(1035, 868, "resources/ScoreBall.png");

        //Filling the array with the notGoalScore positions
        notGoal[0] = new Picture(517, 873, "resources/XScore.jpg");
        notGoal[1] = new Picture(1391, 873, "resources/XScore.jpg");
        notGoal[2] = new Picture(605, 873, "resources/XScore.jpg");
        notGoal[3] = new Picture(1303, 873, "resources/XScore.jpg");
        notGoal[4] = new Picture(693, 873, "resources/XScore.jpg");
        notGoal[5] = new Picture(1215, 873, "resources/XScore.jpg");
        notGoal[6] = new Picture(780, 873, "resources/XScore.jpg");
        notGoal[7] = new Picture(1127, 873, "resources/XScore.jpg");
        notGoal[8] = new Picture(869, 873, "resources/XScore.jpg");
        notGoal[9] = new Picture(1039, 873, "resources/XScore.jpg");

        //Print which team won
        Player1wins = new Picture(480, 180, "resources/Player1wins.png");
        Player2wins = new Picture(480, 180, "resources/Player2wins.png");

        //Create the turn players
        Player1turn = new Picture(520, 50, "resources/Player1turn.png");
        Player2turn = new Picture(520, 50, "resources/Player2turn.png");


        //Creating the draw
        draw = new Picture(580, 180, "resources/draw.png");

        //Creating press R
        pressR = new Picture(780, 320, "resources/PressR.png");
    }


    public boolean getPlayerwin()
    {
        return playerwin;
    }

    //Method to choose which player is gonna shot the ball
    public void chooseTurn () {

        if(!playerwin)
        {
            if (counter % 2 == 1){
                Player1turn.delete();
                Player2turn.delete();
                Player2turn.draw();
            } else {
                Player2turn.delete();
                Player1turn.delete();
                Player1turn.draw();
            }
        }

    }


    //Method to check if its goal or not and print the right ball
    public void printScore(boolean isGoal) {
        if(counter <= 9) {
            if (counter % 2 == 0) {
                kickCounterTeam1++;
                if (isGoal) {
                    goalCounterTeam1++;
                }
            }
            if (counter % 2 == 1){
                kickCounterTeam2++;
                if (isGoal) {
                    goalCounterTeam2++;
                }
            }
            if (!isGoal) {
                notGoal[counter].draw();
            } else {
                ballPosition[counter].draw();
            }
            counter++;
            checkWhoWins();
        }
    }

    //Check which team wins the game;
    public void checkWhoWins () {

        if ((5 - kickCounterTeam2) + goalCounterTeam2 < goalCounterTeam1) {
            Player1wins.draw();
            Player1turn.delete();
            Player2turn.delete();
            pressR.draw();
            playerwin = true;
        }
        if ((5 - kickCounterTeam1) + goalCounterTeam1 < goalCounterTeam2) {
            Player2wins.draw();
            Player1turn.delete();
            Player2turn.delete();
            pressR.draw();
            playerwin = true;
        }
        if (counter == 10) {
            if (goalCounterTeam1 > goalCounterTeam2) {
                Player1turn.delete();
                Player2turn.delete();
                pressR.draw();
                Player1wins.draw();
                playerwin = true;
            } else if (goalCounterTeam1 < goalCounterTeam2) {
                Player1turn.delete();
                Player2turn.delete();
                pressR.draw();
                Player2wins.draw();
                playerwin = true;
            } else {
                Player1turn.delete();
                Player2turn.delete();
                pressR.draw();
                draw.draw();
                playerwin = true;
            }
        }
    }

    //To print after the background those 2 images
    public void chooseDefaultImage () {
        scoreBoard.draw();
        Player1turn.draw();
    }

    //To delete de default images in the menu 1
    public void deleteDefaultImage () {
        scoreBoard.delete();
        Player1turn.delete();
    }

    //To delete all the painted scored balls and reset the counter to 0
    public void clearScore () {
        playerwin = false;
        kickCounterTeam1 = 0;
        kickCounterTeam2 = 0;
        goalCounterTeam1 = 0;
        goalCounterTeam2 = 0;
        counter = 0;
        draw.delete();
        pressR.delete();
        Player1wins.delete();
        Player2wins.delete();


        for (int i = 0; i < ballPosition.length; i++) {
            ballPosition[i].delete();
            notGoal[i].delete();
        }
    }

}
