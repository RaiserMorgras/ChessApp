package chess.moveValidators;

import chess.BoardModel;
import chess.BoardMove;
import chess.Tile;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ChessMoveValidatorTest {

    @Test
    public void areInnerTilesFree() {
        BoardMove move = mock(BoardMove.class);
        BoardModel board = mock(BoardModel.class);
        Tile tile1 = mock(Tile.class);
        Tile tile2 = mock(Tile.class);

        when(tile1.hasFigure()).thenReturn(false);
        when(tile2.hasFigure()).thenReturn(true);

        when(move.getStartXCoord()).thenReturn(0);
        when(move.getStartYCoord()).thenReturn(3);
        when(move.getEndXCoord()).thenReturn(0);
        when(move.getEndYCoord()).thenReturn(6);
        when(move.getRowIndexShift()).thenReturn(0);
        when(move.getColumnIndexShift()).thenReturn(3);

        when(board.getTile(0, 4)).thenReturn(tile1);
        when(board.getTile(0, 5)).thenReturn(tile2);

        ChessMoveValidator validator = spy(new ChessMoveValidator() {
            @Override
            public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
                return false;
            }
        });
        assertFalse(validator.areInnerTilesFree(move, board));

        verify(validator, times(0)).validateMove(any(), any());
        verify(board, times(2)).getTile(anyInt(), anyInt());

    }
}