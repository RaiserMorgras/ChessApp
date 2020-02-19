package MainTest;

import boardgame.chess.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCases {
    BoardModel bm;
    GameControl gc;
    @Before
    public void preparation() {
        bm = new BoardModel(8, 8, new ClassicChessTileGenerator());
    }
    @Test
    public void testCase1() {
        String command = "e2 e4";
        BoardMove move = BoardMove.parseBoardMove(command);
        boolean result = bm.validateMove(move);
        assertTrue(result);
    }

    @Test
    public void testCase2() {
        gc = new GameControl(new CLIWorker());
        gc.start();
    }
}
