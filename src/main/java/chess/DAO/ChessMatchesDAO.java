package chess.DAO;

import chess.model.TurnInfoModel;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChessMatchesDAO {

    /**
     * The method is intended to return list, changes in which won't affect
     * the actual data.
     * @param id ID of the match which turns are to be returned.
     * @return List of the turns in the match.
     */
    List<TurnInfoModel> getMatch(int id);

    void saveTurn(int matchID, TurnInfoModel turnInfoModel);
}
