package chess.layouts;

import chess.TurnHistory;

public interface ITurnHistoryLayout {
    String turnHistoryToString(TurnHistory turnHistory, ITurnLayout singleTurnToString);
}
