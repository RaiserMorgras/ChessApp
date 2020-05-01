package chess.model.validators;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.Tile;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BishopMoveValidatorTest {

    @Test
    public void validateMove() {
        ChessMoveValidator validator = spy(new BishopMoveValidator());
        BoardMove move = new BoardMove(7, 3, 3, 7);
        BoardModel model = mock(BoardModel.class);

        Tile tile1 = mock(Tile.class);
        Tile tile2 = mock(Tile.class);
        Tile tile3 = mock(Tile.class);

        when(tile1.hasFigure()).thenReturn(false);
        when(tile2.hasFigure()).thenReturn(false);
        when(tile3.hasFigure()).thenReturn(false);

        when(model.getTile(6, 4)).thenReturn(tile1);
        when(model.getTile(5, 5)).thenReturn(tile2);
        when(model.getTile(4, 6)).thenReturn(tile3);

        assertTrue(validator.validateMove(move, model));

        verify(validator, times(1)).areInnerTilesFree(any(), any());

    }
}