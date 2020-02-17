package boardgame.chess.figures;

import boardgame.chess.moveValidators.BishopMoveValidator;

public class Bishop extends ChessFigure {

    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, new BishopMoveValidator());
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2657' : '\u265D');
    }
}
