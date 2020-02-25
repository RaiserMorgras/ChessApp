package chess;

import chess.gameStates.GameStateID;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOStreamUIWorker implements IChessUI{
    private PrintStream printStream;
    private PrintStream errorStream;
    private Scanner inputStreamScanner;

    public IOStreamUIWorker(InputStream inputStream, OutputStream printStream, OutputStream errorStream) {
        this.inputStreamScanner = new Scanner(inputStream);
        this.printStream = new PrintStream(printStream);
        this.errorStream = new PrintStream(errorStream);
    }

    public void showBoardState(BoardModel boardModel) {
        printStream.println(boardModel.toString());
    }

    public BoardMove getMoveCommand(String outputMessage) {
        if (outputMessage != null) {
            printStream.println(outputMessage);
        }
        printStream.println("Turn format is \"x0 x0\", case insensitive");
        return BoardMove.parseBoardMove(inputStreamScanner.nextLine());
    }

    public void turnStartSequence(int turnCount, GameStateID currentPlayer, String extraMessage) {
        printStream.println("Turn: " + turnCount);
        switch (currentPlayer) {
            case WHITE_PLAYER_TURN:
                printStream.println("White player's turn");
                break;
            case BLACK_PLAYER_TURN:
                printStream.println("Black player's turn");
                break;
            default:
                throw new RuntimeException("Unexpected game state encountered at start of turn: " + currentPlayer);
        }
    }

    public void putErrorMessage(Exception exception, String extraMessage) {
        if (exception != null) {
            exception.printStackTrace(errorStream);
        }
        if (extraMessage != null) {
            errorStream.println(extraMessage);
        }
    }

    public void gameEndSequence(GameStateID gameStateID) {
        switch (gameStateID) {
            case WHITE_PLAYER_WON:
                printStream.println("White player has won!");
                break;
            case BLACK_PLAYER_WON:
                printStream.println("Black player has won!");
                break;
            default:
                throw new RuntimeException("Unexpected game state encountered at end of the game: " + gameStateID);
        }
    }
}
