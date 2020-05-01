package chess.model.states;

public class BlackPlayerTurnState implements IChessGameState {
    @Override
    public IChessGameState nextState(boolean isJumpingToFinal) {
        return (isJumpingToFinal) ? new BlackPlayerWonState(): new WhitePlayerTurnState();
    }

    @Override
    public GameStateID getStateID() {
        return GameStateID.BLACK_PLAYER_TURN;
    }

    @Override
    public boolean isFinalState() {
        return false;
    }
}
