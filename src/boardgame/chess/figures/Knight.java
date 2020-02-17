package boardgame.chess.figures;

import boardgame.chess.moveValidators.KnightMoveValidator;

public class Knight extends ChessFigure {
    public Knight(boolean colorIsWhite) {
        super(colorIsWhite, new KnightMoveValidator());
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2658' : '\u265E');
    }
}
