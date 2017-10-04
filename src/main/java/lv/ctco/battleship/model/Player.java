package lv.ctco.battleship.model;

import java.io.Serializable;

/**
 * Created by roman.pipchenko on 10/2/2017.
 */
public class Player implements Serializable {
    private static final long serialVersionUID = 1;
    private String userName;
    private Field myField = new Field();

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
