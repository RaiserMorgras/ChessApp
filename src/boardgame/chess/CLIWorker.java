package boardgame.chess;

import java.util.Scanner;

public class CLIWorker implements IChessUI{
    private Scanner clScanner;
    public CLIWorker() {
        clScanner = new Scanner(System.in);
    }


    @Override
    public void showBoardState(BoardModel boardModel) {
        System.out.println(boardModel.toString());
    }

    @Override
    public BoardMove getBoardMoveCommand(String outputMessage) {
        if (outputMessage != null) {
            System.out.println(outputMessage);
        }
        System.out.println("Turn format is \"x0 x0\", case insensitive");
        return BoardMove.parseBoardMove(clScanner.nextLine());
    }

    @Override
    public void turnStart(int turnCount, String extraMessage) {
        System.out.println("Turn: " + turnCount);
        System.out.println(((turnCount % 2) == 1 ? "White" : " Black") + " player's turn");
    }

    @Override
    public void putErrorMessage(Exception exception, String extraMessage) {
        if (exception != null) {
            System.err.println(exception.getMessage());
        }
        if (extraMessage != null) {
            System.err.println(extraMessage);
        }
    }

    @Override
    public void gameHasEnded(GameEndState gameEndState) {
        switch (gameEndState) {
            case WHITE_WON:
                System.out.println("White player has won!");
                break;
            case BLACK_WON:
                System.out.println("Black player has won!");
                break;
            case DRAW:
                System.out.println("The game has ended in a draw");
                break;
            default:
                System.out.println("Incorrect game ending state occurred");
        }
    }
}
