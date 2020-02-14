package ChessGame;

public class King extends ChessFigure {
    public King(boolean colorIsWhite) {
        super(colorIsWhite, new MovePattern[] {
                new MovePattern(0, 1, false, false),
                new MovePattern(2, 1, false, false),
                new MovePattern(4, 1, false, false),
                new MovePattern(6, 1, false, false),
                new MovePattern(8, 1, false, false),
                new MovePattern(10, 1, false, false),
                new MovePattern(12, 1, false, false),
                new MovePattern(14, 1, false, false)
        });
    }
    public boolean isKing() {
        return true;
    }
    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2654' : '\u265A');
    }
}
