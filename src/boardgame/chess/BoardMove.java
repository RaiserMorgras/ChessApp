package boardgame.chess;

public class BoardMove {
    private final int startXCoord;
    private final int startYCoord;
    private final int endXCoord;
    private final int endYCoord;

    public BoardMove(int startXCoord, int startYCoord, int endXCoord, int endYCoord) {
        this.startXCoord = startXCoord;
        this.startYCoord = startYCoord;
        this.endXCoord = endXCoord;
        this.endYCoord = endYCoord;
    }
    public static BoardMove parseBoardMove(String input) {
        String[] tokens = input.split(" ");
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
                return new BoardMove(tokensFrom[1] - '1',
                        tokensFrom[0] - 'a',
                        tokensTo[1] - '1',
                        tokensTo[0] - 'a');
            }
        }
        return null;
    }
    public int getStartXCoord() {
        return startXCoord;
    }
    public int getStartYCoord() {
        return startYCoord;
    }
    public int getEndXCoord() {
        return endXCoord;
    }
    public int getEndYCoord() {
        return endYCoord;
    }
    public int getRowIndexShift() {
        return endXCoord - startXCoord;
    }
    public int getColumnIndexShift() {
        return endYCoord - startYCoord;
    }

}
