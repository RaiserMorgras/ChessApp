package boardgame.chess;

import boardgame.chess.figures.*;

public class ClassicChessTileGenerator implements TileGenerator {

    @Override
    public Tile generate(int x, int y) {
        boolean figureIsWhite = false;
        ChessFigure newFigure = null;

        if (x == 0 || x == 1) {
            figureIsWhite = true;
        }
        switch (x) {
            case 1:
            case 6:
                newFigure = new Pawn(figureIsWhite);
                break;
            case 0:
            case 7:
                switch (y) {
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
        return new Tile(newFigure);
    }
}
