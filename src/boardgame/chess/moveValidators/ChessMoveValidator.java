package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;

public interface ChessMoveValidator {

    boolean validateMove(BoardMove boardMove, BoardModel boardModel);
}
