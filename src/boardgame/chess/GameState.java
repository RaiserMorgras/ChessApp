package boardgame.chess;

public enum GameState {
    WHITE_PLAYER_WON,
    BLACK_PLAYER_WON,
    GAME_ENDED_DRAW,
    WHITE_PLAYER_TURN,
    BLACK_PLAYER_TURN;

    public static GameState firstTurn(boolean whiteIsFirst) {
        return (whiteIsFirst) ? WHITE_PLAYER_TURN : BLACK_PLAYER_TURN;
    }
    public static GameState nextPlayer(GameState currentState) {
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
    public static GameState finishGame(GameState currentState) {
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
