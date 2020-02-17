package boardgame.chess.moveValidators;

import boardgame.chess.BoardModel;
import boardgame.chess.BoardMove;

public class QueenMoveValidator implements ChessMoveValidator {
    @Override
    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        ChessMoveValidator rookMoves = new RookMoveValidator();
        ChessMoveValidator bishopMoves = new BishopMoveValidator();

        return rookMoves.validateMove(boardMove, boardModel) || bishopMoves.validateMove(boardMove, boardModel);
    }
}
