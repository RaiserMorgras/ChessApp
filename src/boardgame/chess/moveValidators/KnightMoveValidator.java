package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;

public class KnightMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        switch (boardMove.getRowIndexShift()) {
            case 2:
            case -2:
                switch (boardMove.getColumnIndexShift()) {
                    case 1:
                    case -1:
                        return true;
                    default:
                        return false;
                }
            case 1:
            case -1:
                switch (boardMove.getColumnIndexShift()) {
                    case 2:
                    case -2:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
