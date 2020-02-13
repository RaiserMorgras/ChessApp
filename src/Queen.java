public class Queen extends ChessFigure {
    public Queen(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public char getCharRepresentation() {
        return (colorIsWhite) ? '\u2655' : '\u265B';
    }
}
