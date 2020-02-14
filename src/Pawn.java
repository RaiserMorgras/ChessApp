public class Pawn extends ChessFigure {
    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2659' : '\u265F');
    }
}
