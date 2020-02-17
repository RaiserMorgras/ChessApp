package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.Tile;
import boardgame.chess.moveValidators.ChessMoveValidator;

public class KingMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        Tile currentTile = boardModel.getTile(boardMove.getStartXCoord(), boardMove.getStartYCoord());
        Tile targetTile = boardModel.getTile(boardMove.getEndXCoord(), boardMove.getEndYCoord());
        switch (boardMove.getRowIndexShift()) {
            case 1:
            case -1:
                switch (boardMove.getColumnIndexShift()) {
                    case 0:
                    case 1:
                    case -1:
                        if (targetTile.hasFigure()) {
                            return currentTile.getPlacedFigure().isWhite() && !targetTile.getPlacedFigure().isWhite();
                        }
                        else {
                            return true;
                        }
                    default:
                        return false;
                }
            case 0:
                switch (boardMove.getColumnIndexShift()) {
                    case 1:
                    case -1:
                        if (targetTile.hasFigure()) {
                            return currentTile.getPlacedFigure().isWhite() && !targetTile.getPlacedFigure().isWhite();
                        }
                        else {
                            return true;
                        }
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
