package chess.figures;

import chess.BoardModel;
import chess.BoardMove;
import chess.moveValidators.ChessMoveValidator;
import chess.moveValidators.KnightMoveValidator;

public class Knight extends ChessFigure {
    private static final ChessMoveValidator validator = new KnightMoveValidator();

    public Knight(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return validator.validateMove(boardMove, boardModel);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2658' : '\u265E');
    }
}
