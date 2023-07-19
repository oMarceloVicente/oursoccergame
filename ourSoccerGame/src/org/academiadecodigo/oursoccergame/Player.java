package org.academiadecodigo.oursoccergame;

import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

public class Player {

    private GoalKeeper goalKeeper;
    private boolean delayReached = false;
    private boolean delayHasAlreadyStarted = false;
    private GoalMessage goalMessage;
    private ChangeScenes changeScenes;
    private Score score;
    private Sound soundKick;

    public Player(GoalKeeper goalKeeper, GoalMessage goalMessage, ChangeScenes changeScenes, Score score){
        this.goalKeeper = goalKeeper;
        this.goalMessage = goalMessage;
        this.changeScenes = changeScenes;
        this.score = score;
        try {
            this.soundKick = new Sound();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void kick(Directions playerDirection) throws InterruptedException{

        if (changeScenes.getCurrentScene() != 0) {
            if (!score.getPlayerwin()) {
                //if the delay has reached or if is the first time
                if (delayReached || !delayHasAlreadyStarted) {

                    soundKick .setFile2();
                    soundKick .play2();

                    goalMessage.clearGoalMessage();
                    goalKeeper.clear();
                    goalKeeper.chooseSideGoalkeeper(playerDirection);
                    delayHasAlreadyStarted = false;
                    delayReached = false;
                }

                //if the delay not started
                if (!delayHasAlreadyStarted) {

                    Thread inputThread = new Thread(() -> {
                        try {
                            delayHasAlreadyStarted = true;
                            Thread.sleep(2000); // Sleep for 5 seconds
                            delayReached = true;
                            goalMessage.clearGoalMessage();
                            goalKeeper.clear();
                            score.chooseTurn();

                        } catch (InterruptedException e) {
                            // Handle interrupted exception if needed
                            e.printStackTrace();
                        }
                    });
                    inputThread.start();
                }
            }
        }

    }


}


