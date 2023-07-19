package org.academiadecodigo.oursoccergame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.net.MalformedURLException;

public class GoalKeeper {



    private Score score;
    private GoalMessage goalMessage;
    private Sound sound;

    //Creating default IMAGE GoalKeeper Pos
    private Picture noSaveCenter;

    //Create saveLeft:
    private Picture keeperSaveLeft;

    //Create saveRight:
    private Picture keeperSaveRight;

    //Create saveCenter:
    private Picture keeperSaveCenter;

    //Create noSaveLeft:
    private Picture noSaveLeft;

    //Create noSaveRight:
    private Picture noSaveRight;

    //Create ball center:
    private Picture goalCenter;

    //Create ball right:
    private Picture goalRight;

    //Create ball left:
    private Picture goalLeft;

    public GoalKeeper(Score score, GoalMessage goalMessage, Picture noSaveCenter, Picture keeperSaveLeft, Picture keeperSaveRight, Picture keeperSaveCenter, Picture noSaveLeft, Picture noSaveRight, Picture goalCenter, Picture goalRight, Picture goalLeft) {

        this.score = score;
        this.goalMessage = goalMessage;
        this.noSaveCenter = noSaveCenter;
        this.keeperSaveLeft = keeperSaveLeft;
        this.keeperSaveRight = keeperSaveRight;
        this.keeperSaveCenter = keeperSaveCenter;
        this.noSaveLeft = noSaveLeft;
        this.noSaveRight = noSaveRight;
        this.goalCenter = goalCenter;
        this.goalRight = goalRight;
        this.goalLeft = goalLeft;
        try {
            this.sound = new Sound();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }


    public void chooseSideGoalkeeper(Directions playerDirection) throws InterruptedException {

        Directions directions = Directions.randomDirections();

        switch (directions) {
            case LEFT:
                chooseLeft(playerDirection);
                break;
            case RIGHT:
                chooseRight(playerDirection);
                break;
            case CENTER:
                chooseCenter(playerDirection);
        }
    }


    public void chooseRight(Directions playerDirection){

       Directions right = Directions.RIGHT;
       noSaveCenter.delete();

        if (playerDirection == right) {
            keeperSaveRight.draw();
            score.printScore(false);
            sound.setFile3();
            sound.play3();

        }
        else if (playerDirection == Directions.CENTER){
            noSaveRight.draw();
            goalCenter.draw();
            score.printScore(true);
            goalMessage.showMessageGoal();
            sound.setFile1();
            sound.play1();
        }
        else
        {
            noSaveRight.draw();
            goalLeft.draw();
            score.printScore(true);
            goalMessage.showMessageGoal();
            sound.setFile1();
            sound.play1();
        }
    }

    public void chooseLeft(Directions playerDirection) throws InterruptedException {
        Directions left =  Directions.LEFT;
        noSaveCenter.delete();

        if (playerDirection == left){
            keeperSaveLeft.draw();
            score.printScore(false);
            sound.setFile3();
            sound.play3();
        }
        else if(playerDirection == Directions.CENTER)
        {
            noSaveLeft.draw();
            goalCenter.draw();
            score.printScore(true);
            goalMessage.showMessageGoal();
            sound.setFile1();
            sound.play1();
        }
        else
        {
            noSaveLeft.draw();
            goalRight.draw();
            score.printScore(true);
            goalMessage.showMessageGoal();
            sound.setFile1();
            sound.play1();
        }
    }

    public void chooseCenter(Directions playerDirection) throws InterruptedException {
        Directions center = Directions.CENTER;

        if (playerDirection == center){
            noSaveCenter.delete();
            keeperSaveCenter.draw();
            score.printScore(false);
            sound.setFile3();
            sound.play3();
        }
        else if (playerDirection == Directions.RIGHT){
            noSaveCenter.draw();
            goalRight.draw();
            score.printScore(true);
            goalMessage.showMessageGoal();
            sound.setFile1();
            sound.play1();
        }
        else
        {
            noSaveCenter.draw();
            goalLeft.draw();
            score.printScore(true);
            goalMessage.showMessageGoal();
            sound.setFile1();
            sound.play1();
        }
    }

    public void clear() {

        goalLeft.delete();
        goalCenter.delete();
        goalRight.delete();
        keeperSaveCenter.delete();
        keeperSaveLeft.delete();
        keeperSaveRight.delete();
        noSaveLeft.delete();
        noSaveRight.delete();
        noSaveCenter.draw();

    }
}
