package org.academiadecodigo.oursoccergame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ChangeScenes {

    private int currentScene;


    //====================================================== BACKGROUND IMAGE

    //Creating background IMAGE and draw it
    Picture backGround;

    //====================================================== MENU IMAGE

    //Creating menu IMAGE
    Picture menu;

    //====================================================== GOALKEEPER IMAGES

    //Creating default IMAGE GoalKeeper Pos
    Picture noSaveCenter;

    //Create saveLeft:
    Picture keeperSaveLeft;

    //Create saveRight:
    Picture keeperSaveRight;

    //Create saveCenter:
    Picture keeperSaveCenter;

    //Create noSaveLeft:
    Picture noSaveLeft;

    //Create noSaveRight:
    Picture noSaveRight;

    //Create ball center:
    Picture goalCenter;

    //Create ball right:
    Picture goalRight;

    //Create ball left:
    Picture goalLeft;

    Score score;

    //CONSTRUCTOR
    public ChangeScenes(Picture backGround, Picture menu, Picture noSaveCenter, Picture keeperSaveLeft, Picture keeperSaveRight, Picture keeperSaveCenter, Picture noSaveLeft, Picture noSaveRight, Picture goalCenter, Picture goalRight, Picture goalLeft, Score score)
    {
        currentScene = 0;
        this.backGround = backGround;
        this.menu = menu;
        this.noSaveCenter = noSaveCenter;
        this.keeperSaveLeft = keeperSaveLeft;
        this.keeperSaveRight = keeperSaveRight;
        this.keeperSaveCenter = keeperSaveCenter;
        this.noSaveLeft = noSaveLeft;
        this.noSaveRight = noSaveRight;
        this.goalCenter = goalCenter;
        this.goalRight = goalRight;
        this.goalLeft = goalLeft;
        this.score = score;

        menu.draw();
    }


    //Getter current scene
    public int getCurrentScene() {
        return currentScene;
    }


    //Change Scene methode
    public void changeScene(int scene)
    {

        switch (scene)
        {
            //MENU
            case 0:
                if (currentScene != 0)
                {

                    //Delete everything if from game
                    currentScene = 0;
                    backGround.delete();
                    noSaveCenter.delete();
                    keeperSaveLeft.delete();
                    keeperSaveRight.delete();
                    keeperSaveCenter.delete();
                    noSaveLeft.delete();
                    noSaveRight.delete();
                    goalCenter.delete();
                    goalRight.delete();
                    goalLeft.delete();
                    score.deleteDefaultImage();
                    score.clearScore();
                    //Draw the menu
                    menu.draw();
                    break;
                }
                break;

            //Main Game
            case 1:

                if(currentScene != 1)
                {
                    currentScene = 1;
                    menu.delete();
                    backGround.draw();
                    noSaveCenter.draw();
                    score.chooseDefaultImage();
                    break;
                }
        }

    }

}
