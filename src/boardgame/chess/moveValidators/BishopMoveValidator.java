package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.Tile;

public class BishopMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        if (Math.abs(boardMove.getRowIndexShift()) == Math.abs(boardMove.getColumnIndexShift())) {
            int x = boardMove.getStartXCoord();
            int y = boardMove.getStartYCoord();
            int xStep = Integer.signum(boardMove.getRowIndexShift());
            int yStep = Integer.signum(boardMove.getColumnIndexShift());
            Tile currentTile = boardModel.getTile(x, y);

            while (x != boardMove.getEndXCoord() && y != boardMove.getEndYCoord()) {
                if (boardModel.getTile(x, y).hasFigure()) {
                    return false;
                }
                x += xStep;
                y += yStep;
            }

            Tile targetTile = boardModel.getTile(x, y);

            if (targetTile.hasFigure()) {
                return currentTile.getPlacedFigure().isWhite() && !targetTile.getPlacedFigure().isWhite();
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}
