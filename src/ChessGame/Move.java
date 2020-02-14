package ChessGame;

import java.util.Arrays;

public class Move {
    protected final Tile currentTile;
    protected final Tile nextTile;

    public Move(Tile currentTile, Tile nextTile) {
        this.currentTile = currentTile;
        this.nextTile = nextTile;
    }

    public boolean isAttackMove() {
        return nextTile.hasFigure() && (currentTile.isPlacedFigureWhite() != nextTile.isPlacedFigureWhite());
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public Tile getNextTile() {
        return nextTile;
    }
    public boolean selfCheck() {
        if (!currentTile.hasFigure() ||
                (currentTile.getPlacedFigure().isWhite() == nextTile.getPlacedFigure().isWhite()))
            return false;
        return Arrays.stream(this.currentTile.getPlacedFigure().getPossibleMovePatterns()).
                anyMatch(mp -> mp.isMatchedBy(this));
    }
}
