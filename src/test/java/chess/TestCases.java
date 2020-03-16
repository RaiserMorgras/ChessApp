package chess;

import chess.UI.IChessUI;
import chess.UI.IOStreamUIWorker;
import chess.figures.Pawn;
import chess.gameStates.GameStateID;
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
        boolean result = bm.validateMove(move, GameStateID.WHITE_PLAYER_TURN);
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

        IChessUI ui = new IOStreamUIWorker(System.in, System.out, System.err);
        ui.showBoardState(bm);

        BoardMove testKingMove = BoardMove.parseBoardMove("e8 f7");

        Assert.assertNotNull(testKingMove);
        Assert.assertTrue(bm.validateMove(testKingMove, GameStateID.BLACK_PLAYER_TURN));
    }
    @Test
    public void testCase3() {
        String command = "e7 e5";
        BoardMove move = BoardMove.parseBoardMove(command);
        assertEquals(new BoardMove(6, 4, 4, 4), move);
        Tile currentTile = bm.getTile(6, 4);
        assertEquals(new Pawn(false).toString(), currentTile.toString());
        assertFalse(currentTile.isPlacedFigureWhite());
        assertEquals(-2, move.getRowIndexShift());
        assertTrue(currentTile.getPlacedFigure().validateMove(move, bm));
        boolean result = bm.validateMove(move, GameStateID.BLACK_PLAYER_TURN);
        assertTrue(result);
    }

}
