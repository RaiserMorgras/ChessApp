package boardgame.chess;

public class Tile {
    private ChessFigure placedFigure;

    public Tile(ChessFigure figure) {
        this.placedFigure = figure;
    }

    public ChessFigure placeFigure(ChessFigure figure) {
        ChessFigure prevFigure = placedFigure;
        placedFigure = figure;
        return prevFigure;
    }
    public ChessFigure getPlacedFigure() {
        return placedFigure;
    }
    public ChessFigure removeFigure() {
        ChessFigure prevFigure = placedFigure;
        placedFigure = null;
        return prevFigure;
    }
    public boolean hasFigure() {
        return (placedFigure != null);
    }
    public String toString() {
        return (hasFigure()) ? placedFigure.toString() : " ";
    }
}
