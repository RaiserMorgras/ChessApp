package chess;

import chess.UI.IChessUI;
import chess.gameStates.GameStateID;

public class GameControlTurnRecording extends GameControl {
    protected TurnHistory turnHistory;
    public GameControlTurnRecording(IChessUI uiWorker, BoardModel boardModel, TurnHistory turnHistory) {
        super(uiWorker, boardModel);
        this.turnHistory = turnHistory;
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
        turnHistory.addTurn(turnInfoModel);
    }


}
