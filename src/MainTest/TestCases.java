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
        bm = new BoardModel();
        bm.setup(8, 8, new ClassicChessTileGenerator());
    }
    @Test
    public void testCase1() {
        String command = "e2 e4";
        BoardMove move = BoardMove.parseBoardMove(command);
        Tile currentTile = bm.getTile(move.getStartXCoord(), move.getStartYCoord());
        boolean result = currentTile.getPlacedFigure().validateMove(move, bm);
        assertTrue(result);
    }

    @Test
    public void testCase2() {
        gc = new GameControl();
        gc.start();
    }
}
