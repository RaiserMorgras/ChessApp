package chess.web;

import chess.GameControl;
import chess.TurnHistory;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChessWebServerTest {

    @Test
    public void createServer() throws Exception {
        ChessWebServer cws = new ChessWebServer();
        cws.createServer();
        cws.start();
        cws.join();
    }
}