public class TurnModel {
    private byte from;
    private byte to;
    public byte getFromCoordX() {
        return (byte) (from & 0b111);
    }
    public byte getFromCoordY() {
        return (byte) ((from >> 3) & 0b111) ;
    }
    public byte getToCoordX() {
        return (byte) ((to) & 0b111);
    }
    public byte getToCoordY() {
        return (byte) ((to >> 3) & 0b111);
    }
    public TurnModel(char fromX, char fromY, char toX, char toY) {
        from = (byte) ((fromX - '0') | ((fromY - 'a') << 3));
        to = (byte) ((toX - '0') | ((toY - 'a') << 3));
    }
}
