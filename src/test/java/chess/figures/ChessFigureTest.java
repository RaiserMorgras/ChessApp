package chess.figures;

import chess.BoardModel;
import chess.BoardMove;
import chess.Tile;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

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
        BoardMove move = mock(BoardMove.class);
        when(move.getStartXCoord()).thenReturn(6);
        when(move.getStartYCoord()).thenReturn(4);
        when(move.getEndXCoord()).thenReturn(4);
        when(move.getEndYCoord()).thenReturn(4);
        when(move.getRowIndexShift()).thenReturn(-2);
        when(move.getColumnIndexShift()).thenReturn(0);

        assertTrue(figure.validateMove(move, bm));
        verify(bm, times(3)).getTile(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt());
        verify(move, times(3)).getStartXCoord();
        verify(move, times(2)).getStartYCoord();
        verify(move, times(1)).getEndXCoord();
        verify(move, times(1)).getEndYCoord();
        verify(move, times(1)).getRowIndexShift();
        verify(move, times(1)).getColumnIndexShift();
    }

    @Test
    public void isKing() {
        ChessFigure figure = new Knight(false);
        assertFalse(figure.isKing());
    }
}