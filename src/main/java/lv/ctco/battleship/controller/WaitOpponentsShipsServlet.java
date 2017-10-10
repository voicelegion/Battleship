package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.Game;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by roman.pipchenko on 10/10/2017.
 */
@WebServlet(name = "WaitOpponentsShipsServlet", urlPatterns = "/wait-opponents-ships")
public class WaitOpponentsShipsServlet extends HttpServlet {
    @Inject
    private PlayerManager playerManager;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = playerManager.getGame();
        if (game.areShipsPlaced()){
            response.sendRedirect(request.getContextPath()+"/make-a-shot.jsp");
        }else {
            request.getRequestDispatcher("/WEB-INF/wait-opponents-ships.jsp")
                    .include(request,response);
        }
    }
}
