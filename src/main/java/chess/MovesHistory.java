package chess;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MovesHistory{
    private final List<BoardMove> moves;
    private Iterator<BoardMove> iterator = null;

    public MovesHistory() {
        moves = new LinkedList<>();
    }
    public void pushMove(BoardMove move) {
        moves.add(move);
    }
    public BoardMove lastMove() {
        return moves.get(moves.size() - 1);
    }
    public MovesHistory beginIteration() {
        iterator = moves.iterator();
        return this;
    }
    public boolean hasNextMove() {
        if (iterator == null) {
            throw new NullPointerException("hasNextMove() called before beginIteration()");
        }
        return iterator.hasNext();
    }
    public BoardMove nextMove() {
        if (iterator == null) {
            throw new NullPointerException("nextMove() called before beginIteration()");
        }
        return iterator.next();
    }

}
