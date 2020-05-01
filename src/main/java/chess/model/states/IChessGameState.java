package chess.model.states;

public interface IChessGameState {
    IChessGameState nextState(boolean isJumpingToFinal);
    GameStateID getStateID();
    boolean isFinalState();
}
