package boardgame.chess.figures;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.moveValidators.BishopMoveValidator;
import boardgame.chess.moveValidators.ChessMoveValidator;

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
