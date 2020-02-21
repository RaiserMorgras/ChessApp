package chess.figures;

import chess.BoardModel;
import chess.BoardMove;
import chess.moveValidators.ChessMoveValidator;
import chess.moveValidators.QueenMoveValidator;

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
