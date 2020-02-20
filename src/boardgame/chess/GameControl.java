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
        GameState gameState = GameState.firstTurn(true);
        int turnCount = 1;
        while(gameState == GameState.WHITE_PLAYER_TURN || gameState == GameState.BLACK_PLAYER_TURN)
        {
            uiWorker.showBoardState(boardModel);
            uiWorker.turnStartSequence(turnCount, gameState, null);
            BoardMove boardMove = uiWorker.getMoveCommand(null);
            if (boardMove != null) {
                boolean moveValidationResult = boardModel.validateMove(boardMove, gameState);
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
                gameState = GameState.nextPlayer(gameState);
            }
            else {
                gameState = GameState.finishGame(gameState);
            }
        }
        uiWorker.gameEndSequence(gameState);
        uiWorker.showBoardState(boardModel);
    }
}
