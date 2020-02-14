package ChessGame;

public class TurnModel{
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

    public static TurnModel parseTurn(String command) {
        String[] tokens = command.split(" ");
        if (tokens.length == 2) {
            char[] tokensFrom = tokens[0].toCharArray();
            char[] tokensTo = tokens[1].toCharArray();
            if (tokensFrom.length == 2 &&
                    tokensTo.length == 2 &&
                    tokensFrom[0] >= 'a' &&
                    tokensFrom[0] <= 'h' &&
                    tokensFrom[1] >= '1' &&
                    tokensFrom[1] <= '8' &&
                    tokensTo[0] >= 'a' &&
                    tokensTo[0] <= 'h' &&
                    tokensTo[1] >= '1' &&
                    tokensTo[1] <= '8') {
                return new TurnModel(tokensFrom[0],tokensFrom[1],tokensTo[0],tokensTo[1]);
            }
        }
        return null;
    }
}
