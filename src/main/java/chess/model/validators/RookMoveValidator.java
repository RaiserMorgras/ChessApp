package chess.model.validators;

import chess.model.BoardModel;
import chess.model.BoardMove;

public class RookMoveValidator implements ChessMoveValidator {

    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        if (boardMove.getRowIndexShift() !=0 && boardMove.getColumnIndexShift() != 0) {
            return false;
        }
        else {
            return areInnerTilesFree(boardMove, boardModel);
        }
    }
}
