package chess.moveValidators;

import chess.BoardModel;
import chess.BoardMove;
import chess.Tile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class ChessMoveValidatorTest {
    private final int moveStartX;
    private final int moveStartY;
    private final int moveEndX;
    private final int moveEndY;
    private final BoardModel boardMock;
    private final boolean expected;

    public ChessMoveValidatorTest(int moveStartX,
                                  int moveStartY,
                                  int moveEndX,
                                  int moveEndY,
                                  List<Boolean> innerTilesFiguresPlacement,
                                  boolean expected) {
        this.moveStartX = moveStartX;
        this.moveStartY = moveStartY;
        this.moveEndX = moveEndX;
        this.moveEndY = moveEndY;
        this.boardMock = mock(BoardModel.class);

        int xStep = Integer.signum(moveEndX - moveStartX);
        int yStep = Integer.signum(moveEndY - moveStartY);
        int x = moveStartX + xStep;
        int y = moveStartY + yStep;
        int i = 0;
        while(x != moveEndX || y != moveEndY) {
            when(boardMock.getTile(x, y)).thenReturn(mock(Tile.class));
            when(boardMock.getTile(x, y).hasFigure()).thenReturn(innerTilesFiguresPlacement.get(i));
            i++;
            x += xStep;
            y += yStep;
        }
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {0, 3, 0, 6, Arrays.asList(false, true), false},
                {4, 2, 6, 0, Arrays.asList(false), true}
        });
    }


    @Test
    public void areInnerTilesFree() {
        BoardMove move = new BoardMove(moveStartX, moveStartY, moveEndX, moveEndY);

        ChessMoveValidator validator = spy(new ChessMoveValidator() {
            @Override
            public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
                return false;
            }
        });
        assertEquals(expected, validator.areInnerTilesFree(move, boardMock));

        verify(validator, times(0)).validateMove(any(), any());
    }
}