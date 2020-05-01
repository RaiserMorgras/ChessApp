package chess.UI;

import chess.model.BoardMove;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Scanner;

public class LoggingUIWorkerImpl extends LoggingUIWorker {

    protected Scanner inputScanner;

    public LoggingUIWorkerImpl(Logger logOutput, Logger logError) {
        super(logOutput, logError);
        inputScanner = new Scanner(System.in);
    }

    public LoggingUIWorkerImpl(InputStream inputStream, Logger logOutput, Logger logError) {
        super(logOutput, logError);
        inputScanner = new Scanner(inputStream);
    }

    @Override
    public BoardMove getMoveCommand(String outputMessage) {
        return BoardMove.parseBoardMove(inputScanner.nextLine());
    }
}
