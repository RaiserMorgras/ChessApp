package boardgame.chess;

import boardgame.chess.figures.ChessFigure;

public class GameControl {
    private IChessUI uiWorker;
    private BoardModel boardModel;

    public GameControl(IChessUI uiWorker) {
        this.uiWorker = uiWorker;
        boardModel = new BoardModel(8, 8, new ClassicChessTileGenerator());
    }
    public void start() {
        ChessFigure lastTakenFigure = null;
        int turnCount = 1;
        do {
            uiWorker.showBoardState(boardModel);
            uiWorker.turnStart(turnCount, null);
            BoardMove boardMove = uiWorker.getBoardMoveCommand(null);
            if (boardMove != null) {
                boolean moveValidationResult = boardModel.validateMove(boardMove);
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
        }
        while(lastTakenFigure == null || !lastTakenFigure.isKing());
        uiWorker.gameHasEnded((lastTakenFigure.isWhite()) ? GameEndState.BLACK_WON : GameEndState.WHITE_WON);
        uiWorker.showBoardState(boardModel);
    }
}
