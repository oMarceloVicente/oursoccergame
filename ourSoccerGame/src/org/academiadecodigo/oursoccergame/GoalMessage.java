package org.academiadecodigo.oursoccergame;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GoalMessage {

    Picture goalMessage = new Picture(750, 250, "resources/goal.png");
    Score score;

    public GoalMessage(Score score)
    {
        this.score = score;
    }

    public void showMessageGoal() {

        if(!score.getPlayerwin())
        {
            goalMessage.draw();
        }


    }

    public void clearGoalMessage ()
    {
        goalMessage.delete();
    }
}