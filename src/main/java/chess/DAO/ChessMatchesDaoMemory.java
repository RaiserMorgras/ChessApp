package chess.DAO;

import chess.model.TurnInfoModel;

import java.util.List;

public class ChessMatchesDaoMemory implements ChessMatchesDAO {
    private List<TurnInfoModel> turnList;

    public ChessMatchesDaoMemory(List<TurnInfoModel> turnList) {
        this.turnList = turnList;
    }
    @Override
    public List<TurnInfoModel> getMatch(int id) {
        return List.copyOf(this.turnList);
    }

    @Override
    public void saveTurn(int matchID, TurnInfoModel turnInfoModel) {
        this.turnList.add(turnInfoModel);
    }

}
