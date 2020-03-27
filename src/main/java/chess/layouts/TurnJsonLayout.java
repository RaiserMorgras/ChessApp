package chess.layouts;

import chess.TurnInfoModel;

public class TurnJsonLayout implements ITurnLayout {
    @Override
    public String turnToString(TurnInfoModel turn) {
        String result = "{";
        result += "turn: " + turn.getTurnNumber() + ",\n";
        result += "player: \"" + turn.getGameStateID() + "\"" + ",\n";
        result += "move: \"" + turn.getMove() + "\"" + ",\n";
        result += "}";
        return result;
    }
}
