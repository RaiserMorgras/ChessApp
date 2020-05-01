package chess.model.validators;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.Tile;

public class PawnMoveValidator implements ChessMoveValidator {

    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        Tile currentTile = boardModel.getTile(boardMove.getStartXCoord(), boardMove.getStartYCoord());
        Tile targetTile = boardModel.getTile(boardMove.getEndXCoord(), boardMove.getEndYCoord());
        int invert = (currentTile.isPlacedFigureWhite()) ? 1 : -1;
        switch (invert * boardMove.getRowIndexShift()) {
            case 2:
                if (boardMove.getColumnIndexShift() == 0) {
                    //white pawn starts at index 1, black pawn starts at index 6
                    boolean pawnIsOnStartingRow = ((boardMove.getStartXCoord() - invert) % 7) == 0;
                    Tile interTile = boardModel.getTile(boardMove.getStartXCoord() + invert,
                            boardMove.getStartYCoord());

                    return (pawnIsOnStartingRow) &&
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
