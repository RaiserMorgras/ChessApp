public class Knight extends ChessFigure {
    public Knight(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public char getCharRepresentation() {
        return (colorIsWhite) ? '\u2658' : '\u265E';
    }
}
