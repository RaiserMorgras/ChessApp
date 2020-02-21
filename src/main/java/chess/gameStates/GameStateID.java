package chess.gameStates;

public enum GameStateID {
    WHITE_PLAYER_WON,
    BLACK_PLAYER_WON,
    WHITE_PLAYER_TURN,
    BLACK_PLAYER_TURN;

    public static GameStateID firstTurn(boolean whiteIsFirst) {
        return (whiteIsFirst) ? WHITE_PLAYER_TURN : BLACK_PLAYER_TURN;
    }
    public static GameStateID nextPlayer(GameStateID currentState) {
        if (currentState == null) return null;
        switch (currentState) {
            case WHITE_PLAYER_TURN:
                return BLACK_PLAYER_TURN;
            case BLACK_PLAYER_TURN:
                return WHITE_PLAYER_TURN;
            default:
                return null;
        }
    }
    public static GameStateID finishGame(GameStateID currentState) {
        if (currentState == null) return null;
        switch (currentState) {
            case WHITE_PLAYER_TURN:
                return WHITE_PLAYER_WON;
            case BLACK_PLAYER_TURN:
                return BLACK_PLAYER_WON;
            default:
                return null;
        }
    }
}
