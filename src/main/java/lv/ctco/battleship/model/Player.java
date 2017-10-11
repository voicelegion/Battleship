package lv.ctco.battleship.model;

import java.io.Serializable;

/**
 * Created by roman.pipchenko on 10/2/2017.
 */
public class Player implements Serializable {
    private static final long serialVersionUID = 1;
    private String userName;

    public Field getOpponentField() {
        return opponentField;
    }

    private final Field myField = new Field();
    private final Field opponentField = new Field();

    public boolean areShipsPlaced() {
        return areShipsPlaced;
    }

    public void setAreShipsPlaced(boolean areShipsPlaced) {
        this.areShipsPlaced = areShipsPlaced;
    }

    private boolean areShipsPlaced = false;

    public Field getMyField() {
        return myField;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
