package org.academiadecodigo.oursoccergame;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Handler implements KeyboardHandler {

    public Keyboard keyboard;
    public Player player;
    private ChangeScenes changeScenes;

    public Handler(Player player,ChangeScenes changeScenes)
    {
        this.changeScenes = changeScenes;
        this.player = player;
        keyboard = new Keyboard(this);
        createKeyboardEvents();

    }

    public void createKeyboardEvents()
    {

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventMiddle = new KeyboardEvent();
        keyboardEventMiddle.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventMiddle.setKey((KeyboardEvent.KEY_DOWN));
        keyboard.addEventListener((keyboardEventMiddle));

        KeyboardEvent keyboardEventP = new KeyboardEvent();
        keyboardEventP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventP.setKey(KeyboardEvent.KEY_P);
        keyboard.addEventListener(keyboardEventP);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventR = new KeyboardEvent();
        keyboardEventR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventR.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(keyboardEventR);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent)
    {
        switch(keyboardEvent.getKey())
        {
            case KeyboardEvent.KEY_RIGHT:

                try {
                    player.kick(Directions.RIGHT);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                try {
                    player.kick(Directions.LEFT);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_DOWN:

                try {
                    player.kick(Directions.CENTER);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                changeScenes.changeScene(1);
                break;

            case KeyboardEvent.KEY_R:
                changeScenes.changeScene(0);
                break;


            case KeyboardEvent.KEY_P:
                System.exit(1);
                break;

            default:
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
