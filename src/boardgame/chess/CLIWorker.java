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
    public BoardMove getMoveCommand(String outputMessage) {
        if (outputMessage != null) {
            System.out.println(outputMessage);
        }
        System.out.println("Turn format is \"x0 x0\", case insensitive");
        return BoardMove.parseBoardMove(clScanner.nextLine());
    }

    @Override
    public void turnStartSequence(int turnCount, GameState currentPlayer, String extraMessage) {
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
    public void gameEndSequence(GameState gameState) {
        switch (gameState) {
            case WHITE_PLAYER_WON:
                System.out.println("White player has won!");
                break;
            case BLACK_PLAYER_WON:
                System.out.println("Black player has won!");
                break;
            case GAME_ENDED_DRAW:
                System.out.println("The game has ended in a draw");
                break;
            default:
                throw new RuntimeException("Unexpected game state encountered at end of the game: " + gameState);
        }
    }
}
