package lv.ctco.battleship.model;

import javafx.scene.control.Cell;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by roman.pipchenko on 10/2/2017.
 */
public class Game implements Serializable {
    private static final long serialVersionUID = 1;
    private Player player1;
    private Player player2;
    private boolean player1Turn = true;
    private Player winner;

    public Player getWinner() {
        return winner;
    }

    public Player getCurrentPlayer() {
        return player1Turn ? player1 : player2;
    }

    public Player getOppositPlayer() {
        return player1Turn ? player2 : player1;
    }


    public void fire(String address) {
        Player playerCurrent = getCurrentPlayer();
        Player oppositPlayer = getOppositPlayer();
        CellContent fired = oppositPlayer.getMyField().get(address);
        if (fired == CellContent.SHIP) {
            playerCurrent.getOpponentField().set(address, CellContent.HIT);
            oppositPlayer.getMyField().set(address, CellContent.HIT);
            checkWinner();
        } else if (fired == CellContent.EMPTY) {
            playerCurrent.getOpponentField().set(address, CellContent.MISS);
            oppositPlayer.getMyField().set(address, CellContent.MISS);
            player1Turn = !player1Turn;
        } else player1Turn = !player1Turn;

    }

    private void checkWinner() {
        Player oppositPlayer = getOppositPlayer();
        Collection<CellContent> cells = oppositPlayer.getMyField().getContent().values();
        for (CellContent c : cells) {
            if (c == CellContent.SHIP) {
                return;
            }
        }
        if (!oppositPlayer.getMyField().getContent().containsValue(CellContent.SHIP)){
            winner = getCurrentPlayer();
        }

        winner = getCurrentPlayer();
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isComplete() {
        return player1 != null && player2 != null;
    }

    public boolean areShipsPlaced() {
        return player1.areShipsPlaced() && player2.areShipsPlaced();
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }

}
