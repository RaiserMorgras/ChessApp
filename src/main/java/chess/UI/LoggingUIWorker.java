package chess.UI;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.states.GameStateID;

import org.apache.logging.log4j.Logger;

public abstract class LoggingUIWorker implements IChessUI {

    protected Logger logOutput;
    protected Logger logError;

    public LoggingUIWorker(Logger logOutput, Logger logError) {
        this.logOutput = logOutput;
        this.logError = logError;
    }

    @Override
    public void showBoardState(BoardModel boardModel) {
        logOutput.info(boardModel);
    }

    @Override
    public abstract BoardMove getMoveCommand(String outputMessage);

    @Override
    public void turnStartSequence(int turnCount, GameStateID currentPlayer, String extraMessage) {
        logOutput.info("Turn " + turnCount);
        switch (currentPlayer) {
            case WHITE_PLAYER_TURN:
                logOutput.info("White player turn");
                break;
            case BLACK_PLAYER_TURN:
                logOutput.info("Black player turn");
                break;
            default:
                logOutput.info("The player turn is unknown");
        }
        logOutput.info(extraMessage);
    }

    @Override
    public void putErrorMessage(Exception exception, String extraMessage) {
        logError.error(exception);
        logError.error(extraMessage);
    }

    @Override
    public void gameEndSequence(GameStateID gameStateID) {
        switch (gameStateID) {
            case WHITE_PLAYER_WON:
                logOutput.info("White player has won");
                break;
            case BLACK_PLAYER_WON:
                logOutput.info("Black player has won");
                break;
            default:
                logOutput.info("Game has ended but there is no winner");
        }
    }
}
