package chess.DAO;

import chess.model.TurnInfoModel;

import java.util.List;
import java.util.UUID;

public class ChessMatchesDaoMemory implements ChessMatchesDAO {
    private List<TurnInfoModel> turnList;

    public ChessMatchesDaoMemory(List<TurnInfoModel> turnList) {
        this.turnList = turnList;
    }
    @Override
    public List<TurnInfoModel> getMatch(UUID id) {
        return List.copyOf(this.turnList);
    }

    @Override
    public void saveTurn(UUID matchID, TurnInfoModel turnInfoModel) {
        this.turnList.add(turnInfoModel);
    }

}
