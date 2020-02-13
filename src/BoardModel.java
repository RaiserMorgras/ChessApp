public class BoardModel {
    private Tile[][] board;

    public void setup() {
        board = new Tile[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean figureIsWhite = false;
                ChessFigure newFigure = null;

                if (i == 0 || i == 1) {
                    figureIsWhite = true;
                }
                switch (i) {
                    case 1:
                    case 6:
                        newFigure = new Pawn(figureIsWhite);
                        break;
                    case 0:
                    case 7:
                        switch (j) {
                            case 0:
                            case 7:
                                newFigure = new Rook(figureIsWhite);
                                break;
                            case 1:
                            case 6:
                                newFigure = new Knight(figureIsWhite);
                                break;
                            case 2:
                            case 5:
                                newFigure = new Bishop(figureIsWhite);
                                break;
                            case 3:
                                newFigure = new Queen(figureIsWhite);
                                break;
                            case 4:
                                newFigure = new King(figureIsWhite);
                                break;
                        }
                        break;
                    default:
                        break;
                }
                board[i][j] = new Tile(newFigure);
            }
        }
    }
    public ChessFigure performTurn(TurnModel turnModel) {
        ChessFigure movingFigure = board[turnModel.getFromCoordX()][turnModel.getFromCoordY()].removeFigure();

        return board[turnModel.getToCoordX()][turnModel.getToCoordY()].placeFigure(movingFigure);
    }

    public String toString() {
        String result = "";
        for (int i = 7; i >= 0; i--) {
            result += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                result += board[i][j].toString();
            }
            result += "\n";
        }
        result+= "\n  ";
        for (int j = 0; j < 8; j++) {
            result += ('A'+j);
        }
        return result;
    }

}
