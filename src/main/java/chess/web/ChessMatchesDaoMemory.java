package chess.web;

import chess.TurnHistory;
import chess.TurnInfoModel;

import java.util.List;

public class ChessMatchesDaoMemory implements ChessMatchesDAO {
    private TurnHistory turnHistory;

    public ChessMatchesDaoMemory(TurnHistory turnHistory) {
        this.turnHistory = turnHistory;
    }
    @Override
    public TurnHistory getMatch(int id) {
        return this.turnHistory;
    }

    @Override
    public void saveTurn(int matchID, TurnInfoModel turnInfoModel) {
        this.turnHistory.addTurn(turnInfoModel);
    }

}
