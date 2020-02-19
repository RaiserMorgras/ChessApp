package boardgame.chess;

public interface IChessUI {
    void showBoardState(BoardModel boardModel);
    BoardMove getBoardMoveCommand(String outputMessage);
    void turnStart(int turnCount, String extraMessage);
    void putErrorMessage(Exception exception, String extraMessage);
    void gameHasEnded(GameEndState gameEndState);
}
