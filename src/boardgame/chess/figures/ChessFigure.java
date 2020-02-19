package boardgame.chess.figures;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.moveValidators.ChessMoveValidator;

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
