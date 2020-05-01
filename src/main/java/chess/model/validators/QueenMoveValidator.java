package chess.model.validators;

import chess.model.BoardModel;
import chess.model.BoardMove;

public class QueenMoveValidator implements ChessMoveValidator {

    public boolean validateMove(BoardMove boardMove, BoardModel boardModel) {
        ChessMoveValidator rookMoves = new RookMoveValidator();
        ChessMoveValidator bishopMoves = new BishopMoveValidator();

        return rookMoves.validateMove(boardMove, boardModel) || bishopMoves.validateMove(boardMove, boardModel);
    }
}
