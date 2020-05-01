package chess.model.states;

public class BlackPlayerWonState implements IChessGameState {

    @Override
    public IChessGameState nextState(boolean isJumpingToFinal) {
        return null;
    }

    @Override
    public GameStateID getStateID() {
        return GameStateID.BLACK_PLAYER_WON;
    }

    @Override
    public boolean isFinalState() {
        return true;
    }
}
