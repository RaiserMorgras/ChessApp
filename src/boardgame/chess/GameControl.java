package boardgame.chess;

public class GameControl {
    private CLIWorker cliWorker;
    private BoardModel boardModel;

    public GameControl() {
        cliWorker = new CLIWorker();
        boardModel = new BoardModel();

        boardModel.setup(8, 8, new ClassicChessTileGenerator());
    }
    public void start() {
        ChessFigure lastTakenFigure = null;
        String command;
        int turnCount = 1;
        do {
            cliWorker.printMessage("Turn " + turnCount);
            cliWorker.printMessage(boardModel.toString());
            cliWorker.printMessage("Turn format is \"x0 x0\"");
            cliWorker.printMessage(((turnCount % 2 == 1) ? "White" : "Black") + " player's turn");
            command = cliWorker.getCommand();
            BoardMove boardMove = BoardMove.parseBoardMove(command);
            if (boardMove != null) {
                Tile currentTile = boardModel.getTile(boardMove.getStartXCoord(), boardMove.getStartYCoord());
                if (currentTile.getPlacedFigure().validateMove(boardMove, boardModel)) {
                    lastTakenFigure = boardModel.performTurn(boardMove);
                    turnCount++;
                }
                else {
                    cliWorker.printErrorMessage("The turn " + command + " is not valid");
                }

            }
            else {
                cliWorker.printErrorMessage("The command " + command + " could not be parsed");
            }
            cliWorker.printMessage("press enter to proceed");
            cliWorker.getCommand();
        }
        while(lastTakenFigure == null || !lastTakenFigure.isKing());
        if (lastTakenFigure.isWhite()) {
            cliWorker.printMessage("White player has won!");
        }
        else {
            cliWorker.printMessage("Black player has won!");
        }
    }
}
