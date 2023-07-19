package org.academiadecodigo.oursoccergame;

public class Delay {

    private boolean delayHasReached = false;
    private int time;

    public Delay(int miliseconds)
    {
        time = miliseconds;
    }

    public boolean runDelay()
    {

        Thread inputThread = new Thread(() -> {
            try {
                Thread.sleep(time); // Sleep for 5 seconds
                delayHasReached = true;
            } catch (InterruptedException e) {
                // Handle interrupted exception if needed
                e.printStackTrace();
            }
        });
        inputThread.start();

        if (delayHasReached){
            return true;
        }
        return false;
    }


}
