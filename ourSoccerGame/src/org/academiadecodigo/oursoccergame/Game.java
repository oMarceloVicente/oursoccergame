package org.academiadecodigo.oursoccergame;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.net.MalformedURLException;

public class Game {

    private ChangeScenes changeScenes;
    private GoalKeeper goalKeeper;
    private Handler handler;
    private Player player;
    private Sound soundBackground ;
    private Score score;
    private GoalMessage goalMessage;


    //====================================================== BACKGROUND IMAGE

    //Creating background IMAGE and draw it
    Picture backGround = new Picture(10, 10, "resources/background.jpg");


    //====================================================== MENU IMAGE

    //Creating menu IMAGE
    Picture menu = new Picture(10, 10, "resources/MenuStart.png");


    //====================================================== GOALKEEPER IMAGES

    Picture noSaveCenter = new Picture(850, 380, "resources/KeeperDefaultPos.png");

    //Create saveLeft:
    Picture keeperSaveLeft = new Picture(600, 300, "resources/KeeperSaveLeft.png");

    //Create saveRight:
    Picture keeperSaveRight = new Picture(1000, 300, "resources/KeeperSaveRight.png");

    //Create saveCenter:
    Picture keeperSaveCenter = new Picture(900, 300, "resources/KeeperSaveCenter.png");

    //Create noSaveLeft:
    Picture noSaveLeft = new Picture(580, 300, "resources/NoSaveLeft1.png");

    //Create noSaveRight:
    Picture noSaveRight = new Picture(1000, 300, "resources/NoSaveRight1.png");

    //Create ball center:
    Picture goalCenter = new Picture(250, 300, "resources/Ball.png");

    //Create ball right:
    Picture goalRight = new Picture(580, 100, "resources/Ball.png");

    //Create ball left:
    Picture goalLeft = new Picture(-100, 100, "resources/Ball.png");


    public void start() throws MalformedURLException {

        //Create score
        score = new Score();

        //ChangeScenes
        changeScenes = new ChangeScenes(backGround, menu, noSaveCenter, keeperSaveLeft, keeperSaveRight, keeperSaveCenter, noSaveLeft,noSaveRight, goalCenter,goalRight, goalLeft, score);

        //Create goalMessage
        goalMessage = new GoalMessage(score);

        //Create goalkeeper
        goalKeeper = new GoalKeeper(score, goalMessage, noSaveCenter, keeperSaveLeft, keeperSaveRight, keeperSaveCenter, noSaveLeft,noSaveRight, goalCenter,goalRight, goalLeft);

        //create player
        player = new Player(goalKeeper, goalMessage,changeScenes, score);

        //create handler
        handler = new Handler(player, changeScenes);


        //create backgroundSound
        soundBackground = new Sound();
        soundBackground .setFile0();
        soundBackground .play0();
        soundBackground .loop0();

    }


}




