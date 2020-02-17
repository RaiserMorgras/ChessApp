package boardgame.chess.figures;

import boardgame.chess.moveValidators.PawnMoveValidator;

public class Pawn extends ChessFigure {
    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite, new PawnMoveValidator());
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2659' : '\u265F');
    }
}
