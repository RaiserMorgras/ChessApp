public class King extends ChessFigure {
    public King(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public char getCharRepresentation() {
        return (colorIsWhite) ? '\u2654' : '\u265A';
    }
}
