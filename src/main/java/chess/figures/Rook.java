package chess.figures;

import chess.BoardModel;
import chess.BoardMove;
import chess.moveValidators.ChessMoveValidator;
import chess.moveValidators.RookMoveValidator;

public class Rook extends ChessFigure {
    private static final ChessMoveValidator validator = new RookMoveValidator();

    public Rook(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return validator.validateMove(boardMove, boardModel);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2656' : '\u265C');
    }
}
