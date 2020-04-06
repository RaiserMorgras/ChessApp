package chess.web;

import chess.*;
import chess.UI.IChessUI;
import chess.UI.LoggingUIWorkerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Configuration
public class ChessTurnRecordConfig {

    @Bean
    public InputStream inputStream() {
        String input = "e2 e4\n" +
                "e7 e5\n" +
                "d1 h5\n" +
                "b8 c6\n" +
                "f1 c4\n" +
                "g8 f6\n" +
                "h5 f7\n" +
                "e8 f7\n" +
                "c4 f7\n";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        return is;
    }
    @Bean
    public GameControl gameControl(
            IChessUI chessUI, BoardModel boardModel, ChessMatchesDAO matchesDao
            ) {
        return new GameControlTurnRecording(chessUI, boardModel, matchesDao);
    }
    @Bean IChessUI chessUI(InputStream inputStream, Logger infoLogger, Logger errorLogger) {
        return new LoggingUIWorkerImpl(inputStream, infoLogger, errorLogger);
    }
    @Bean BoardModel boardModel() {
        return new BoardModel(8, 8, new ClassicChessTileGenerator());
    }
    @Bean
    public TurnHistory turnHistory() {
        return new TurnHistory();
    }
    @Bean
    public ChessMatchesDAO matchesDao(TurnHistory turnHistory) {
        return new ChessMatchesDaoMemory(turnHistory);
    }
    @Bean
    public Logger errorLogger() {
        return LogManager.getLogger("root");
    }
    @Bean
    public Logger infoLogger() {
        return LogManager.getLogger("infoOutput");
    }
}
