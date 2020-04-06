package chess.web;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/match/{matchID}")
@ResponseBody
public class ChessMatchesController {
    private ChessMatchesDAO chessMatchesDAO;

    public void setChessMatchesDAO(ChessMatchesDAO chessMatchesDAO) {
        this.chessMatchesDAO = chessMatchesDAO;
    }

    @GetMapping(produces = "application/json")
    public String getMatchData(@PathVariable int matchID) {
        return new Gson().toJson(chessMatchesDAO.getMatch(matchID));
    }
}
