package boardgame.chess.figures;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;
import boardgame.chess.moveValidators.ChessMoveValidator;

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
