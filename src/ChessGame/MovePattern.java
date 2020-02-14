package ChessGame;

public class MovePattern {
    private final byte direction;
    private final byte distance;
    private final boolean isAttackOnly;
    private final boolean isMoveOnly;

    public MovePattern(int direction, int distance, boolean isAttackOnly, boolean isMoveOnly) {
        if ((isAttackOnly == true) &&(isMoveOnly == true)) {
            throw new IllegalArgumentException("ChessGame.MovePattern cannot be move only and attack only simultaneously");
        }
        else {
            this.direction = (byte) direction;
            this.distance = (byte) distance;
            this.isAttackOnly = isAttackOnly;
            this.isMoveOnly = isMoveOnly;
        }
    }

    private byte getDirection(byte xShift, byte yShift) {
        if (yShift == 0)
            return (byte) ((xShift > 0) ? 0 : 8);
        switch (2 * xShift / yShift) {
            case 4:
                return (byte) ((xShift > 0) ? 1 : 9);
            case 2:
                return (byte) ((xShift > 0) ? 2 : 10);
            case 1:
                return (byte) ((xShift > 0) ? 3 : 11);
            case 0:
                return (byte) ((xShift > 0) ? 4 : 12);
            case -1:
                return (byte) ((xShift > 0) ? 5 : 13);
            case -2:
                return (byte) ((xShift > 0) ? 6 : 14);
            case -4:
                return (byte) ((xShift > 0) ? 7 : 15);
            default:
                throw new IllegalArgumentException("Direction could not be obtained from " +
                        xShift + " as X and " + yShift + " as Y");
        }
    }
    private byte getDistance(byte xShift, byte yShift) {
        return (xShift > yShift) ? xShift : yShift;
    }
    public boolean isMatchedBy(Move move) {
        boolean isAttack = move.isAttackMove();
        if ((isAttack && isMoveOnly) || ((isAttack == false) && (isAttackOnly == true))) {
            return false;
        }
        byte xShift = (byte) (move.getNextTile().getColumnIndex() - move.getCurrentTile().getColumnIndex());
        byte yShift = (byte) (move.getNextTile().getRowIndex() - move.getCurrentTile().getRowIndex());
        byte moveDirection = getDirection(xShift, yShift);
        byte moveDistance = getDistance(xShift, yShift);
        if (moveDirection != direction){
            return false;
        }
        else {
            return (distance == 0) || (moveDistance == distance);
        }
    }
}
