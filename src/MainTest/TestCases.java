package MainTest;

import boardgame.chess.*;
import org.junit.Assert;
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
        boolean result = bm.validateMove(move, GameState.WHITE_PLAYER_TURN);
        assertTrue(result);
    }
    @Test
    public void testCase2() {
        BoardMove prepMove1 = BoardMove.parseBoardMove("d1 f7");
        BoardMove prepMove2 = BoardMove.parseBoardMove("f1 c4");

        Assert.assertNotNull(prepMove1);
        Assert.assertNotNull(prepMove2);
        bm.performTurn(prepMove1);
        bm.performTurn(prepMove2);

        IChessUI ui = new CLIWorker();
        ui.showBoardState(bm);

        BoardMove testKingMove = BoardMove.parseBoardMove("e8 f7");

        Assert.assertNotNull(testKingMove);
        Assert.assertTrue(bm.validateMove(testKingMove, GameState.BLACK_PLAYER_TURN));
    }

}
