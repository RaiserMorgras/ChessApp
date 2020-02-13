public class Rook extends ChessFigure {
    public Rook(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public char getCharRepresentation() {
        return (colorIsWhite) ? '\u2656' : '\u265C';
    }
}
