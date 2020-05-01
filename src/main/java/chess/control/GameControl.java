package chess.control;

import chess.UI.IChessUI;
import chess.model.figures.ChessFigure;
import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.states.GameStateID;
import chess.model.states.StateControl;

import java.util.Date;

public class GameControl {
    protected final IChessUI uiWorker;
    protected final BoardModel boardModel;
    protected final int matchID;

    protected StateControl stateControl;
    protected int turnCount;
    protected BoardMove lastBoardMove;

    public GameControl(IChessUI uiWorker, BoardModel boardModel) {
        this.uiWorker = uiWorker;
        this.boardModel = boardModel;
        this.matchID = generateMatchID();
    }
    protected int generateMatchID() {
        Date date = new Date();
        return date.hashCode();
    }
    public void start() {
        initState();
        while(!stateControl.isFinalStateReached())
        {
            playerTurn();
        }
        finishGame();
    }
    protected void initState() {
        stateControl = new StateControl();
        stateControl.setStartingState(true);
        turnCount = 1;
    }
    protected void playerTurn() {

        ChessFigure lastTakenFigure = null;
        uiWorker.showBoardState(boardModel);
        uiWorker.turnStartSequence(turnCount, stateControl.getStateID(), null);
        lastBoardMove = uiWorker.getMoveCommand(null);
        if (lastBoardMove != null) {
            boolean moveValidationResult = boardModel.validateMove(lastBoardMove, stateControl.getStateID());
            if (moveValidationResult) {
                lastTakenFigure = boardModel.performTurn(lastBoardMove);
                if (stateControl.getStateID() == GameStateID.BLACK_PLAYER_TURN)
                    turnCount++;
            }
            else {
                uiWorker.putErrorMessage(null, "The turn " + lastBoardMove +" is not valid");
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
    protected void finishGame() {
        uiWorker.gameEndSequence(stateControl.getStateID());
        uiWorker.showBoardState(boardModel);
    }

}
