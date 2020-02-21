package chess.figures;

import chess.BoardModel;
import chess.BoardMove;

public abstract class ChessFigure{
    protected final boolean colorIsWhite;

    protected ChessFigure(boolean colorIsWhite) {
        this.colorIsWhite = colorIsWhite;
    }
    public boolean isWhite() {
        return colorIsWhite;
    }
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        return false;
    }
    public boolean isKing() {
        return false;
    }
}
