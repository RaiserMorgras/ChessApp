package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;

public class BishopMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        if (Math.abs(boardMove.getRowIndexShift()) == Math.abs(boardMove.getColumnIndexShift())) {
            return areInnerTilesFree(boardMove, boardModel);
        }
        else {
            return false;
        }
    }
}
