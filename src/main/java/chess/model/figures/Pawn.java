package chess.model.figures;

import chess.model.BoardModel;
import chess.model.BoardMove;
import chess.model.validators.ChessMoveValidator;
import chess.model.validators.PawnMoveValidator;

public class Pawn extends ChessFigure {
    private static final ChessMoveValidator validator = new PawnMoveValidator();

    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return validator.validateMove(boardMove, boardModel);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2659' : '\u265F');
    }
}
