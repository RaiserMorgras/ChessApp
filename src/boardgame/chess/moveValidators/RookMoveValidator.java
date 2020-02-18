package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.Tile;
import boardgame.chess.moveValidators.ChessMoveValidator;

public class RookMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        int x = boardMove.getStartXCoord();
        int y = boardMove.getStartYCoord();
        int xStep = Integer.signum(boardMove.getRowIndexShift());
        int yStep = Integer.signum(boardMove.getColumnIndexShift());
        Tile currentTile = boardModel.getTile(x,y);

        if (xStep == 0 && yStep == 0) return false;
        x += xStep;
        y += yStep;
        while (x != boardMove.getEndXCoord() && y != boardMove.getEndYCoord()) {
            if (boardModel.getTile(x,y).hasFigure()) {
                return false;
            }
            x += xStep;
            y += yStep;
        }

        Tile targetTile = boardModel.getTile(x,y);
        if (targetTile.hasFigure()) {
            return currentTile.getPlacedFigure().isWhite() == !targetTile.getPlacedFigure().isWhite();
        }
        else {
            return true;
        }
    }
}
