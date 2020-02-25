package chess.gameStates;

import org.junit.Test;

import static org.junit.Assert.*;

public class StateControlTest {

    @Test
    public void nextState() {
        StateControl stateControl = new StateControl();
        stateControl.setStartingState(false);
        stateControl.nextState(false);

        assertEquals(GameStateID.WHITE_PLAYER_TURN, stateControl.getStateID());
    }

    @Test
    public void isFinalStateReached() {
        StateControl stateControl = new StateControl();
        stateControl.setStartingState(true);
        stateControl.nextState(true);

        assertTrue(stateControl.isFinalStateReached());
    }
}