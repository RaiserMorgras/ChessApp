package ChessGame;

public class Rook extends ChessFigure {
    public Rook(boolean colorIsWhite) {
        super(colorIsWhite, new MovePattern[] {
                new MovePattern(0, 0, false, false),
                new MovePattern(4, 0, false, false),
                new MovePattern(8, 0, false, false),
                new MovePattern(12, 0, false, false)
        });
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2656' : '\u265C');
    }
}
