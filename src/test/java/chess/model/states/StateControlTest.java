package chess.model.states;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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