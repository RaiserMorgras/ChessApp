package boardgame.chess;

public class King extends ChessFigure {
    public King(boolean colorIsWhite) {
        super(colorIsWhite, new KingMoveValidator());
    }
    public boolean isKing() {
        return true;
    }
    public String toString() {
        return Character.toString((colorIsWhite) ? '\u2654' : '\u265A');
    }
}
