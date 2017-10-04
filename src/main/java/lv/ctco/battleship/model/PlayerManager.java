package lv.ctco.battleship.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman.pipchenko on 10/2/2017.
 */
@Named
@SessionScoped
public class PlayerManager  implements Serializable {
    public Game getGame() {
        return game;
    }

    private static final long serialVersionUID = 1;
    private Game game;
    private Player player;
    @Inject
    private GameManager gameManager;
    public Player getPlayer() {
        return player;
    }

    public Game registerPlayer(Player player){
        this.player=player;
        this.game = gameManager.registerPlayer(player);
        return this.game;
    }
}
