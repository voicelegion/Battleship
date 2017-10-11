package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.Game;
import lv.ctco.battleship.model.Player;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by roman.pipchenko on 10/11/2017.
 */
@WebServlet(name = "EndOfGameServlet", urlPatterns = "/eog")
public class EndOfGameServlet extends HttpServlet {
    @Inject
    private PlayerManager playerManager;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = playerManager.getGame();
        Player winner = game.getWinner();

        Player current = playerManager.getPlayer();

        if (current==winner) {
            request.getRequestDispatcher("/WEB-INF/winner.jsp").include(request, response);
        } else request.getRequestDispatcher("/WEB-INF/looser.jsp").include(request, response);
    }
}
