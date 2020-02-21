package chess.figures;

import chess.BoardModel;
import chess.BoardMove;
import chess.moveValidators.ChessMoveValidator;
import chess.moveValidators.PawnMoveValidator;

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
