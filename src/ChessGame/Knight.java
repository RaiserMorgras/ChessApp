package ChessGame;

public class Knight extends ChessFigure {
    public Knight(boolean colorIsWhite) {
        super(colorIsWhite, new MovePattern[] {
                new MovePattern(1, 2, false, false),
                new MovePattern(3, 2, false, false),
                new MovePattern(5, 2, false, false),
                new MovePattern(7, 2, false, false),
                new MovePattern(9, 2, false, false),
                new MovePattern(11, 2, false, false),
                new MovePattern(13, 2, false, false),
                new MovePattern(15, 2, false, false)
        });
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2658' : '\u265E');
    }
}
