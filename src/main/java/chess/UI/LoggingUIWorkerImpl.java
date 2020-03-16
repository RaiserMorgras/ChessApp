package chess.UI;

import chess.BoardMove;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LoggingUIWorkerImpl extends LoggingUIWorker {

    protected Scanner systemInputScanner;

    public LoggingUIWorkerImpl(Logger logOutput, Logger logError) {
        super(logOutput, logError);
        systemInputScanner = new Scanner(System.in);
    }

    @Override
    public BoardMove getMoveCommand(String outputMessage) {
        System.out.println("Enter new command. Format: \"x0 x0\"");
        return BoardMove.parseBoardMove(systemInputScanner.nextLine());
    }
}
