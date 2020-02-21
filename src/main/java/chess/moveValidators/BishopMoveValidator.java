package chess.moveValidators;

import chess.BoardModel;
import chess.BoardMove;

public class BishopMoveValidator implements ChessMoveValidator {

    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        if (Math.abs(boardMove.getRowIndexShift()) == Math.abs(boardMove.getColumnIndexShift())) {
            return areInnerTilesFree(boardMove, boardModel);
        }
        else {
            return false;
        }
    }
}
