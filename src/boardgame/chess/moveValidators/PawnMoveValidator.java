package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.Tile;
import boardgame.chess.moveValidators.ChessMoveValidator;

public class PawnMoveValidator implements ChessMoveValidator {


    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        Tile currentTile = boardModel.getTile(boardMove.getStartXCoord(), boardMove.getStartYCoord());
        Tile targetTile = boardModel.getTile(boardMove.getEndXCoord(), boardMove.getEndYCoord());
        switch (boardMove.getRowIndexShift()) {
            case 2:
                if (!currentTile.getPlacedFigure().isWhite()) {
                    return false;
                }
                else {
                    if (boardMove.getColumnIndexShift() == 0) {
                        Tile interTile = boardModel.getTile(boardMove.getStartXCoord() + 1,
                                boardMove.getStartYCoord());

                        return (boardMove.getStartXCoord() == 1) &&
                                !interTile.hasFigure() &&
                                !targetTile.hasFigure();
                    }
                    else {
                        return false;
                    }
                }
            case 1:
                if (!currentTile.getPlacedFigure().isWhite()) {
                    return false;
                }
                else {
                    switch (boardMove.getColumnIndexShift()) {
                        case 0:
                            return !targetTile.hasFigure();
                        case 1:
                        case -1:
                            return targetTile.hasFigure() && !targetTile.getPlacedFigure().isWhite();
                        default:
                            return false;
                    }
                }
            case -1:
                if (currentTile.getPlacedFigure().isWhite()) {
                    return false;
                }
                else {
                    switch (boardMove.getColumnIndexShift()) {
                        case 0:
                            return !targetTile.hasFigure();
                        case 1:
                        case -1:
                            return targetTile.hasFigure() && targetTile.getPlacedFigure().isWhite();
                        default:
                            return false;
                    }
                }
            case -2:
                if (currentTile.getPlacedFigure().isWhite()) {
                    return false;
                }
                else {
                    if (boardMove.getColumnIndexShift() == 0) {
                        Tile interTile = boardModel.getTile(boardMove.getStartXCoord() - 1,
                                boardMove.getStartYCoord());

                        return (boardMove.getStartXCoord() == 6) &&
                                !interTile.hasFigure() &&
                                !targetTile.hasFigure();
                    }
                    else {
                        return false;
                    }
                }
            default:
                return false;
        }
    }
}
