package chess.moveValidators;

import chess.BoardModel;
import chess.BoardMove;

public class KingMoveValidator implements ChessMoveValidator {

    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return boardMove.getRowIndexShift() <= 1
                && boardMove.getRowIndexShift() >= -1
                && boardMove.getColumnIndexShift() <= 1
                && boardMove.getColumnIndexShift() >= -1;
    }
}
