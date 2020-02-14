package ChessGame;

public class GameControl {
    private CLIWorker cliWorker;
    private BoardModel boardModel;

    public GameControl() {
        cliWorker = new CLIWorker();
        boardModel = new BoardModel();

        boardModel.setup();
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
            TurnModel tm = TurnModel.parseTurn(command);
            if (tm != null) {
                Move preparedMove = boardModel.prepareMove(tm);
                if (preparedMove.selfCheck()) {
                    lastTakenFigure = boardModel.performTurn(preparedMove);
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
        while(lastTakenFigure == null || lastTakenFigure.isKing() == false);
        if (lastTakenFigure.isWhite()) {
            cliWorker.printMessage("White player has won!");
        }
    }
}
