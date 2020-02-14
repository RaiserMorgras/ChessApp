package ChessGame;

public abstract class ChessFigure{
    protected final boolean colorIsWhite;
    protected final MovePattern[] possibleMovePatterns;

    protected ChessFigure(boolean colorIsWhite, MovePattern[] possibleMovePatterns) {
        this.colorIsWhite = colorIsWhite;
        this.possibleMovePatterns = possibleMovePatterns;
    }
    public boolean isWhite() {
        return colorIsWhite;
    }
    public MovePattern[] getPossibleMovePatterns() {
        return this.possibleMovePatterns;
    }
    public boolean isKing() {
        return false;
    }
}
