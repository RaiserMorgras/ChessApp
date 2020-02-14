public class Queen extends ChessFigure {
    public Queen(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2655' : '\u265B');
    }
}
