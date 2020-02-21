package chess.moveValidators;

import chess.BoardModel;
import chess.BoardMove;

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
