public class Tile {
    private ChessFigure placedFigure;

    public Tile() {
        this.placedFigure = null;
    }
    public Tile(ChessFigure figure) {
        this.placedFigure = figure;
    }
    public ChessFigure placeFigure(ChessFigure figure) {
        ChessFigure prevFigure = placedFigure;
        placedFigure = figure;
        return prevFigure;
    }
    public ChessFigure removeFigure() {
        ChessFigure prevFigure = placedFigure;
        placedFigure = null;
        return prevFigure;
    }
    public boolean hasFigure() {
        return (placedFigure == null);
    }

    public String toString() {
        return Character.toString(placedFigure.getCharRepresentation());
    }
}
