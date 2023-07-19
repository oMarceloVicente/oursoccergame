package org.academiadecodigo.oursoccergame;

public enum Directions {
    LEFT,
    RIGHT,
    CENTER;



    public static Directions randomDirections(){
        return values() [(int) (Math.random() * Directions.values().length)];
    }

}
