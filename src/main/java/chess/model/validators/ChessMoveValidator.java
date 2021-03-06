package chess.model.validators;

import chess.model.BoardModel;
import chess.model.BoardMove;

public interface ChessMoveValidator {

    boolean validateMove(BoardMove boardMove, BoardModel boardModel);

    default boolean areInnerTilesFree(BoardMove boardMove, BoardModel boardModel) {

        int xStep = Integer.signum(boardMove.getRowIndexShift());
        int yStep = Integer.signum(boardMove.getColumnIndexShift());
        int x = boardMove.getStartXCoord() + xStep;
        int y = boardMove.getStartYCoord() + yStep;

        while (x != boardMove.getEndXCoord() || y != boardMove.getEndYCoord()) {
            if (boardModel.getTile(x, y).hasFigure()) {
                return false;
            }
            x += xStep;
            y += yStep;
        }
        return true;
    }
}
