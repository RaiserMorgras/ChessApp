package ChessGame;

public class Tile {
    private ChessFigure placedFigure;
    private byte rowIndex;
    private byte columnIndex;

    public Tile(ChessFigure figure, int rowIndex, int columnIndex) {
        this.placedFigure = figure;
        this.rowIndex = (byte) rowIndex;
        this.columnIndex = (byte) columnIndex;
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
    public byte getRowIndex() {
        return rowIndex;
    }
    public byte getColumnIndex() {
        return columnIndex;
    }
    public boolean hasFigure() {
        return (placedFigure != null);
    }
    public boolean isPlacedFigureWhite() { return placedFigure.colorIsWhite;}
    public String toString() {
        return (hasFigure()) ? placedFigure.toString() : " ";
    }
}
