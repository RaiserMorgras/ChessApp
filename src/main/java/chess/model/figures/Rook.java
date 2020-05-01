package chess.model.figures;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.validators.ChessMoveValidator;
import chess.model.validators.RookMoveValidator;

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
