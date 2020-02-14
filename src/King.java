public class King extends ChessFigure {
    public King(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2654' : '\u265A');
    }
}
