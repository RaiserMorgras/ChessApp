package chess.web;

import org.junit.Test;

public class ChessWebServerTest {

    @Test
    public void createServer() throws Exception {
        ChessWebServer cws = new ChessWebServer();
        cws.createServer();
        cws.start();
        cws.join();
    }
}