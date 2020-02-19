package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;

public class RookMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        if (boardMove.getRowIndexShift() !=0 && boardMove.getColumnIndexShift() != 0) {
            return false;
        }
        else {
            return areInnerTilesFree(boardMove, boardModel);
        }
    }
}
