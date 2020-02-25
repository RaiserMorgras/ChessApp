package chess.moveValidators;

import chess.BoardModel;
import chess.BoardMove;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KingMoveValidatorTest {

    @Test
    public void validateMove() {
        BoardMove move = mock(BoardMove.class);
        BoardModel model = mock(BoardModel.class);
        ChessMoveValidator validator = spy(new KingMoveValidator());

        when(move.getColumnIndexShift()).thenReturn(2);
        when(move.getRowIndexShift()).thenReturn(1);

        assertFalse(validator.validateMove(move, model));

        verify(validator, times(0)).areInnerTilesFree(any(), any());
        verify(model, times(0)).getTile(anyInt(), anyInt());
    }
}