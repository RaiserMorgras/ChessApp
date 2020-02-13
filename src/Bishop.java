public class Bishop extends ChessFigure {
    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public char getCharRepresentation() {
        return (colorIsWhite) ? '\u2657' : '\u265D';
    }
}
