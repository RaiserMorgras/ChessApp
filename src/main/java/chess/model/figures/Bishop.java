package chess.model.figures;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.validators.BishopMoveValidator;
import chess.model.validators.ChessMoveValidator;

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
