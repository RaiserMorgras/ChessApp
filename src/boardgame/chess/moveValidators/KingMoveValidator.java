package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;

public class KingMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        switch (boardMove.getRowIndexShift()) {
            case 1:
            case -1:
                switch (boardMove.getColumnIndexShift()) {
                    case 0:
                    case 1:
                    case -1:
                        return true;
                    default:
                        return false;
                }
            case 0:
                switch (boardMove.getColumnIndexShift()) {
                    case 1:
                    case -1:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
