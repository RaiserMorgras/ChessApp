public class Bishop extends ChessFigure {
    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2657' : '\u265D');
    }
}
