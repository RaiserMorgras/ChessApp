package chess.web;

import chess.GameControl;
import chess.TurnHistory;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ChessWebServerTest {

    @Test
    public void createServer() throws Exception {
        ChessWebServer cws = new ChessWebServer();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TurnRecordingBeanConfig.class);
        GameControl gameControl = (GameControl) ctx.getBean("gameControl");
        Server server = cws.createServer();
        TurnsJsonServlet.turnHistory = (TurnHistory) ctx.getBean("turnHistory");
        server.start();
        gameControl.start();
        server.join();
    }
}