package chess.web;

import chess.TurnHistory;
import chess.TurnInfoModel;
import org.springframework.stereotype.Repository;


@Repository
public interface ChessMatchesDAO {

    TurnHistory getMatch(int id);

    void saveTurn(int matchID, TurnInfoModel turnInfoModel);
}
