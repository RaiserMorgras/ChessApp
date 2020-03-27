package chess.web;

import chess.layouts.ITurnHistoryLayout;
import chess.TurnHistory;
import chess.layouts.TurnHistoryJsonLayout;
import chess.layouts.TurnJsonLayout;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TurnsJsonServlet extends HttpServlet {
    static TurnHistory turnHistory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();

        ITurnHistoryLayout layout = new TurnHistoryJsonLayout();
        pw.print(layout.turnHistoryToString(turnHistory, new TurnJsonLayout()));
    }

}
