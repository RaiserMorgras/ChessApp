package chess.gameStates;

public class StateControl {
    protected IChessGameState state;

    public void nextState(boolean isJumpingToFinal) {
        state = state.nextState(isJumpingToFinal);
    }
    public void setStartingState(boolean whiteIsFirst) {
        state = (whiteIsFirst) ? new WhitePlayerTurnState() : new BlackPlayerTurnState();
    }
    public GameStateID getStateID() {
        return state.getStateID();
    }
    public boolean isFinalStateReached() {
        return state.isFinalState();
    }
}
