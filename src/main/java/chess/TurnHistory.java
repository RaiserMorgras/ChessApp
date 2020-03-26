package chess;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TurnHistory {
    private final List<TurnInfoModel> turnsList;
    private Iterator<TurnInfoModel> iterator = null;

    public TurnHistory() {
        turnsList = new LinkedList<>();
    }
    public void addTurn(TurnInfoModel turnInfoModel) {
        turnsList.add(turnInfoModel);
    }

    public TurnHistory beginIteration() {
        iterator = turnsList.iterator();
        return this;
    }
    public boolean hasNextTurn() {
        if (iterator == null) {
            throw new NullPointerException("hasNextMove() called before beginIteration()");
        }
        return iterator.hasNext();
    }
    public TurnInfoModel nextTurn() {
        if (iterator == null) {
            throw new NullPointerException("nextMove() called before beginIteration()");
        }
        return iterator.next();
    }

}
