package chess.figures;

import chess.BoardModel;
import chess.BoardMove;
import chess.moveValidators.KingMoveValidator;

public class King extends ChessFigure {
    private static final KingMoveValidator validator = new KingMoveValidator();

    public King(boolean colorIsWhite) {
        super(colorIsWhite);
    }
    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return validator.validateMove(boardMove, boardModel);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2654' : '\u265A');
    }
}
