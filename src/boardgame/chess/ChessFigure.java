package boardgame.chess;

public abstract class ChessFigure{
    protected final boolean colorIsWhite;
    protected final ChessMoveValidator validator;

    protected ChessFigure(boolean colorIsWhite, ChessMoveValidator validator) {
        this.colorIsWhite = colorIsWhite;
        this.validator = validator;
    }
    public boolean isWhite() {
        return colorIsWhite;
    }
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return validator.validateMove(boardMove,boardModel);
    }
    public boolean isKing() {
        return false;
    }
}
