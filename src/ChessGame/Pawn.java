package ChessGame;

public class Pawn extends ChessFigure {
    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite, new MovePattern[] {
                new MovePattern((colorIsWhite) ? 4 : 12, 1, false, true),
                new MovePattern((colorIsWhite) ? 2 : 10, 1, true, false),
                new MovePattern((colorIsWhite) ? 6 : 14, 1, true, false),
        });
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2659' : '\u265F');
    }
}
