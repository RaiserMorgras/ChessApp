package chess.web;


import chess.TurnInfoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/match/{matchID}")
@ResponseBody
public class ChessMatchesController {
    private ChessMatchesDAO chessMatchesDAO;

    public void setChessMatchesDAO(ChessMatchesDAO chessMatchesDAO) {
        this.chessMatchesDAO = chessMatchesDAO;
    }

    @GetMapping(produces = "application/json")
    public List<TurnInfoModel> getMatchData(@PathVariable int matchID) {
        return chessMatchesDAO.getMatch(matchID);
    }
}
