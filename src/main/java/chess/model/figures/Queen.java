package chess.model.figures;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.validators.ChessMoveValidator;
import chess.model.validators.QueenMoveValidator;

public class Queen extends ChessFigure {
    private static final ChessMoveValidator validator = new QueenMoveValidator();

    public Queen(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return validator.validateMove(boardMove, boardModel);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2655' : '\u265B');
    }
}
