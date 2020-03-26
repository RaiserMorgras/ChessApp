package chess;

import chess.gameStates.GameStateID;

public class TurnInfoModel {
    protected final BoardMove move;
    protected final int turnNumber;
    protected final GameStateID gameStateID;


    public TurnInfoModel(BoardMove move, int turnNumber, GameStateID gameStateID) {
        this.move = move;
        this.turnNumber = turnNumber;
        this.gameStateID = gameStateID;
    }
    public BoardMove getMove() {
        return move;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public GameStateID getGameStateID() {
        return gameStateID;
    }
}
