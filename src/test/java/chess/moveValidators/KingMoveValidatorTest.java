package chess.moveValidators;

import chess.BoardModel;
import chess.BoardMove;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KingMoveValidatorTest {

    @Test
    public void validateMove() {
        BoardMove move = new BoardMove(2, 3, 3, 5);
        BoardModel model = mock(BoardModel.class);
        ChessMoveValidator validator = spy(new KingMoveValidator());

        assertFalse(validator.validateMove(move, model));

        verify(validator, times(0)).areInnerTilesFree(any(), any());
        verify(model, times(0)).getTile(anyInt(), anyInt());
    }
}