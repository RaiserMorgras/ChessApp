import java.util.StringTokenizer;

public class CommandParser {
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
