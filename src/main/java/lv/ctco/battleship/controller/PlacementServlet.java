package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.CellContent;
import lv.ctco.battleship.model.Field;
import lv.ctco.battleship.model.Player;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by roman.pipchenko on 10/4/2017.
 */
@WebServlet(name = "PlacementServlet", urlPatterns = "/placement")
public class PlacementServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(PlacementServlet.class.getName());
    @Inject
    private PlayerManager playerManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean error = true;

        String[] addresses = request.getParameterValues("cell");
        if (addresses == null || addresses.length < 20){
            request.setAttribute("errorNotEnough", true);
        }else if (addresses.length > 20){
            request.setAttribute("errorTooMany", true);
        }else {
            error = false;
        }
        logger.log(Level.FINER, () -> "Placement request received " + Arrays.toString(addresses));
        Player player = playerManager.getPlayer();
        Field field = player.getMyField();
        field.getContent().clear();
        if (addresses != null) {
            for (String addr : addresses) {
                field.set(addr, CellContent.SHIP);
            }
        }
        if (error){
            request.getRequestDispatcher("/placement.jsp").include(request,response);
        }else{
            player.areShipsPlaced = true;
            response.sendRedirect(request.getContextPath()+"/wait-opponents-ships");
        }
    }

}
