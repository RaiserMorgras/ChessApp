package chess.layouts;

import chess.TurnInfoModel;

public interface ITurnLayout {
    String turnToString(TurnInfoModel turn);
}
