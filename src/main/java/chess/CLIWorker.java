package chess;

import chess.gameStates.GameStateID;

import java.util.Scanner;

public class CLIWorker implements IChessUI{
    private Scanner clScanner;
    public CLIWorker() {
        clScanner = new Scanner(System.in);
    }



    public void showBoardState(BoardModel boardModel) {
        System.out.println(boardModel.toString());
    }


    public BoardMove getMoveCommand(String outputMessage) {
        if (outputMessage != null) {
            System.out.println(outputMessage);
        }
        System.out.println("Turn format is \"x0 x0\", case insensitive");
        return BoardMove.parseBoardMove(clScanner.nextLine());
    }


    public void turnStartSequence(int turnCount, GameStateID currentPlayer, String extraMessage) {
        System.out.println("Turn: " + turnCount);
        switch (currentPlayer) {
            case WHITE_PLAYER_TURN:
                System.out.println("White player's turn");
                break;
            case BLACK_PLAYER_TURN:
                System.out.println("Black player's turn");
                break;
            default:
                throw new RuntimeException("Unexpected game state encountered at start of turn: " + currentPlayer);
        }
    }


    public void putErrorMessage(Exception exception, String extraMessage) {
        if (exception != null) {
            exception.printStackTrace();
        }
        if (extraMessage != null) {
            exception.printStackTrace();
        }
    }


    public void gameEndSequence(GameStateID gameStateID) {
        switch (gameStateID) {
            case WHITE_PLAYER_WON:
                System.out.println("White player has won!");
                break;
            case BLACK_PLAYER_WON:
                System.out.println("Black player has won!");
                break;
            default:
                throw new RuntimeException("Unexpected game state encountered at end of the game: " + gameStateID);
        }
    }
}
