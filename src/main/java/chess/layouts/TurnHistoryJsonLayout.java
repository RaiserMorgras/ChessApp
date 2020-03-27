package chess.layouts;

import chess.TurnHistory;
import chess.TurnInfoModel;

public class TurnHistoryJsonLayout implements ITurnHistoryLayout {
    @Override
    public String turnHistoryToString(TurnHistory turnHistory, ITurnLayout singleTurnToString) {
        String result ="[";
        turnHistory.beginIteration();
        while(turnHistory.hasNextTurn()) {
            TurnInfoModel turn = turnHistory.nextTurn();
            result += ("\n"+singleTurnToString.turnToString(turn)).replace("\n","\t\n");
            if (turnHistory.hasNextTurn())
                result += ",";
        }
        result += "\n]";
        return result;
    }
}
