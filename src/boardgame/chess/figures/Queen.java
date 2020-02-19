package boardgame.chess.figures;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.moveValidators.ChessMoveValidator;
import boardgame.chess.moveValidators.QueenMoveValidator;

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
