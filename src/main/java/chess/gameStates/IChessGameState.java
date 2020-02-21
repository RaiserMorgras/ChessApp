package chess.gameStates;

public interface IChessGameState {
    IChessGameState nextState(boolean isJumpingToFinal);
    GameStateID getStateID();
    boolean isFinalState();
}
