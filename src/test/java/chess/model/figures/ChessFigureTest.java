package chess.model.figures;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.Tile;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ChessFigureTest {

    @Test
    public void isWhite() {
        ChessFigure figure = new King(true);
        assertTrue(figure.isWhite());
    }

    @Test
    public void validateMove() {
        ChessFigure figure = new Pawn(false);
        BoardModel bm = mock(BoardModel.class);

        when(bm.getTile(6, 4)).thenReturn(new Tile(figure));
        when(bm.getTile(5, 4)).thenReturn(new Tile(null));
        when(bm.getTile(4, 4)).thenReturn(new Tile(null));
        BoardMove move = new BoardMove(6, 4, 4, 4);

        assertTrue(figure.validateMove(move, bm));
        verify(bm, times(3)).getTile(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt());
    }

    @Test
    public void isKing() {
        ChessFigure figure = new Knight(false);
        assertFalse(figure.isKing());
    }
}