package boardgame.chess;

public interface ChessMoveValidator {

    boolean validateMove(BoardMove boardMove, BoardModel boardModel);
}
