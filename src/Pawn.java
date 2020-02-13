public class Pawn extends ChessFigure {
    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite);
    }

    @Override
    public char getCharRepresentation() {
        return (colorIsWhite) ? '\u2659' : '\u265F';
    }
}
