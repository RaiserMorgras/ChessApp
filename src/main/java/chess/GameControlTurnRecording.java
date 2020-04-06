package chess;

import chess.UI.IChessUI;
import chess.gameStates.GameStateID;
import chess.web.ChessMatchesDAO;

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
