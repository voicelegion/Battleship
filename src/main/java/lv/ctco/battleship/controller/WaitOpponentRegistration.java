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
 * Created by roman.pipchenko on 10/2/2017.
 */
@WebServlet(name = "WaitOpponentRegistration", urlPatterns = "/wait-opponent-registration")
public class WaitOpponentRegistration extends HttpServlet {
    @Inject
    private PlayerManager playerManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = playerManager.getGame();
        if (game.isComplete()) {
            response.sendRedirect(request.getContextPath()+"/placement.jsp");
        } else {
            request.getRequestDispatcher("/WEB-INF/wait-opponent-registration.jsp")
                    .include(request,response);
        }
    }
}
