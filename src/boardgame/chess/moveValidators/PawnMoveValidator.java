package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.Tile;

public class PawnMoveValidator implements ChessMoveValidator {


    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        Tile currentTile = boardModel.getTile(boardMove.getStartXCoord(), boardMove.getStartYCoord());
        Tile targetTile = boardModel.getTile(boardMove.getEndXCoord(), boardMove.getEndYCoord());
        int invert = (currentTile.isPlacedFigureWhite()) ? 1 : -1;
        switch (invert * boardMove.getRowIndexShift()) {
            case 2:
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
            case 1:
                switch (boardMove.getColumnIndexShift()) {
                    case 0:
                        return !targetTile.hasFigure();
                    case 1:
                    case -1:
                        return targetTile.hasFigure() && !targetTile.isPlacedFigureWhite();
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
