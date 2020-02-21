package chess.gameStates;

public class WhitePlayerTurnState implements IChessGameState {

    @Override
    public IChessGameState nextState(boolean isJumpingToFinal) {
        return (isJumpingToFinal) ? new WhitePlayerWonState() : new BlackPlayerTurnState();
    }

    @Override
    public GameStateID getStateID() {
        return GameStateID.WHITE_PLAYER_TURN;
    }

    @Override
    public boolean isFinalState() {
        return false;
    }
}
