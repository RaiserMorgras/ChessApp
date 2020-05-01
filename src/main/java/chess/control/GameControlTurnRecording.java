package chess.control;

import chess.UI.IChessUI;
import chess.model.BoardModel;
import chess.model.TurnInfoModel;
import chess.model.states.GameStateID;
import chess.DAO.ChessMatchesDAO;

public class GameControlTurnRecording extends GameControl {
    protected ChessMatchesDAO matchesDAO;
    public GameControlTurnRecording(IChessUI uiWorker, BoardModel boardModel, ChessMatchesDAO matchesDAO) {
        super(uiWorker, boardModel);
        this.matchesDAO = matchesDAO;
    }

    @Override
    protected void playerTurn() {
        int turnCountAtTurnStart = this.turnCount;
        GameStateID stateAtTurnStart = this.stateControl.getStateID();
        super.playerTurn();
        TurnInfoModel turnInfoModel =
                new TurnInfoModel(this.lastBoardMove,
                        turnCountAtTurnStart,
                        stateAtTurnStart);
        matchesDAO.saveTurn(matchID, turnInfoModel);
    }


}
