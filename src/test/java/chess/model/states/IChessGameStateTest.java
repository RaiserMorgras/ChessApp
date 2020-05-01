package chess.model.states;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IChessGameStateTest {

    @Test
    public void nextState() {
        IChessGameState state = new BlackPlayerTurnState();
        IChessGameState expected = new BlackPlayerWonState();
        IChessGameState actual = state.nextState(true);

        assertEquals(expected.getStateID(), actual.getStateID());
    }

    @Test
    public void getStateID() {
        IChessGameState state = new WhitePlayerWonState();
        GameStateID expected = GameStateID.WHITE_PLAYER_WON;

        assertEquals(expected, state.getStateID());
    }

    @Test
    public void isFinalState() {
        IChessGameState state = new WhitePlayerTurnState();

        assertFalse(state.isFinalState());
    }
}