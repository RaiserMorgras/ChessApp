package boardgame.chess;

public interface IChessUI {
    /**
     * Performs necessary steps to show current chess board state to the user.
     * @param boardModel the board to be shown.
     */
    void showBoardState(BoardModel boardModel);

    /**
     * Asks a user to provide information on move the user wants to perform.
     * The parameter outputMessage, if not null, is shown to a user before they provide move information, otherwise,
     * it's not used.
     * Returns a BoardMove instance encapsulating the move information the user has provided.
     * @param outputMessage a String to be shown to the user before he provides turn information.
     * @return BoardMove instance encapsulating provided move information.
     */
    BoardMove getMoveCommand(String outputMessage);

    /**
     * Performs necessary steps to provide user with information on turn that is about to start.
     * @param turnCount a number of the current turn.
     * @param currentPlayer the player whose turn is about to start.
     * @param extraMessage a message that, if not null, is shown to the user after main steps were performed, otherwise
     *                     not used.
     */
    void turnStartSequence(int turnCount, GameState currentPlayer, String extraMessage);

    /**
     * Informs a user of the happened exceptional state, and shows him of extraMessage if provided.
     * @param exception an exception that, if not null, the user will be informed of, otherwise not used.
     * @param extraMessage additional message that, if not null, is shown to user after he was informed of the
     *                     exceptional state, otherwise not used.
     */
    void putErrorMessage(Exception exception, String extraMessage);

    /**
     * Performs necessary steps to inform user of game ending, and to show the result of the game.
     * @param gameState an enum representing the result of the game
     */
    void gameEndSequence(GameState gameState);
}
