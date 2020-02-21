package chess;

import chess.figures.ChessFigure;
import chess.gameStates.GameStateID;
import chess.gameStates.StateControl;

public class GameControl {
    private IChessUI uiWorker;
    private BoardModel boardModel;

    public GameControl(IChessUI uiWorker) {
        this.uiWorker = uiWorker;
        boardModel = new BoardModel(8, 8, new ClassicChessTileGenerator());
    }
    public void start() {
        ChessFigure lastTakenFigure = null;
        StateControl stateControl = new StateControl();
        stateControl.setStartingState(true);
        int turnCount = 1;
        while(!stateControl.isFinalStateReached())
        {
            uiWorker.showBoardState(boardModel);
            uiWorker.turnStartSequence(turnCount, stateControl.getStateID(), null);
            BoardMove boardMove = uiWorker.getMoveCommand(null);
            if (boardMove != null) {
                boolean moveValidationResult = boardModel.validateMove(boardMove, stateControl.getStateID());
                if (moveValidationResult) {
                    lastTakenFigure = boardModel.performTurn(boardMove);
                    turnCount++;
                }
                else {
                    uiWorker.putErrorMessage(null, "The turn " + boardMove +" is not valid");
                }

            }
            else {
                uiWorker.putErrorMessage(null, "The command could not be parsed");
            }
            if (lastTakenFigure == null || !lastTakenFigure.isKing()) {
                stateControl.nextState(false);
            }
            else {
                stateControl.nextState(true);
            }
        }
        uiWorker.gameEndSequence(stateControl.getStateID());
        uiWorker.showBoardState(boardModel);
    }
}
