package ChessGame;

public class Queen extends ChessFigure {
    public Queen(boolean colorIsWhite) {
        super(colorIsWhite, new MovePattern[] {
                new MovePattern(0, 0, false, false),
                new MovePattern(2, 0, false, false),
                new MovePattern(4, 0, false, false),
                new MovePattern(6, 0, false, false),
                new MovePattern(8, 0, false, false),
                new MovePattern(10, 0, false, false),
                new MovePattern(12, 0, false, false),
                new MovePattern(14, 0, false, false)
        });
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2655' : '\u265B');
    }
}
