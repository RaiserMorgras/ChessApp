package ChessGame;

public class Bishop extends ChessFigure {

    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, new MovePattern[] {
                new MovePattern(2, 0, false, false),
                new MovePattern(6, 0, false, false),
                new MovePattern(10, 0, false, false),
                new MovePattern(14, 0, false, false)
        });
    }

    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2657' : '\u265D');
    }
}
