package boardgame.chess.figures;

import boardgame.chess.moveValidators.RookMoveValidator;

public class Rook extends ChessFigure {
    public Rook(boolean colorIsWhite) {
        super(colorIsWhite, new RookMoveValidator());
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2656' : '\u265C');
    }
}
