package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.Tile;

public interface ChessMoveValidator {

    boolean validateMove(BoardMove boardMove, BoardModel boardModel);

    default boolean areInnerTilesFree(BoardMove boardMove, BoardModel boardModel) {

        int x = boardMove.getStartXCoord();
        int y = boardMove.getStartYCoord();
        int xStep = Integer.signum(boardMove.getRowIndexShift());
        int yStep = Integer.signum(boardMove.getColumnIndexShift());

        if (xStep == 0 && yStep == 0) return false;
        x += xStep;
        y += yStep;
        while (x != boardMove.getEndXCoord() && y != boardMove.getEndYCoord()) {
            if (boardModel.getTile(x, y).hasFigure()) {
                return false;
            }
            x += xStep;
            y += yStep;
        }
        return true;
    }
}
