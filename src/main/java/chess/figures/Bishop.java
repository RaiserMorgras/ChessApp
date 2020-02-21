package chess.figures;

import chess.BoardModel;
import chess.BoardMove;
import chess.moveValidators.BishopMoveValidator;
import chess.moveValidators.ChessMoveValidator;

public class Bishop extends ChessFigure {
    private static final ChessMoveValidator validator = new BishopMoveValidator();

    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return validator.validateMove(boardMove, boardModel);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2657' : '\u265D');
    }
}
