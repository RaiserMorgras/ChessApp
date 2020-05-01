package chess.model.states;

public class WhitePlayerWonState implements IChessGameState {

    @Override
    public IChessGameState nextState(boolean isJumpingToFinal) {
        return null;
    }

    @Override
    public GameStateID getStateID() {
        return GameStateID.WHITE_PLAYER_WON;
    }

    @Override
    public boolean isFinalState() {
        return true;
    }
}
