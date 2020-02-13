public abstract class ChessFigure {
    protected final boolean colorIsWhite;
    public ChessFigure(boolean colorIsWhite) {
        this.colorIsWhite = colorIsWhite;
    }
    public boolean isWhite() {
        return colorIsWhite;
    }
    public abstract char getCharRepresentation();
}
