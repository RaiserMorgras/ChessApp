package boardgame.chess.figures;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.moveValidators.ChessMoveValidator;
import boardgame.chess.moveValidators.RookMoveValidator;

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
