package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;

public class KingMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return boardMove.getRowIndexShift() <= 1
                && boardMove.getRowIndexShift() >= -1
                && boardMove.getColumnIndexShift() <= 1
                && boardMove.getColumnIndexShift() >= -1;
    }
}
