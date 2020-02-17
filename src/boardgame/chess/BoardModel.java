package boardgame.chess;

public class BoardModel {
    private Tile[][] board;
    private int rowCount;
    private int columnCount;

    public void setup(int rowCount, int columnCount, TileGenerator gen) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        board = new Tile[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                board[i][j] = gen.generate(i, j);
            }
        }
    }
    public ChessFigure performTurn(BoardMove boardMove) {
        Tile currentTile = board[boardMove.getStartXCoord()][boardMove.getStartYCoord()];
        Tile targetTile = board[boardMove.getEndXCoord()][boardMove.getEndYCoord()];

        ChessFigure movingFigure = currentTile.removeFigure();

        return targetTile.placeFigure(movingFigure);
    }
    public Tile getTile(int x, int y) {
        return board[x][y];
    }
    public String toString() {
        String result = "";
        for (int i = rowCount - 1; i >= 0; i--) {
            result += (i + 1) + " ";
            for (int j = 0; j < columnCount; j++) {
                result += board[i][j].toString();
            }
            result += "\n";
        }
        result+= "  ";
        for (int j = 0; j < columnCount; j++) {
            result += Character.toString('A'+j);
        }
        return result;
    }
}
