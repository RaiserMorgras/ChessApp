package chess.web;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ShutdownHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class ChessWebServer {
    public static Server createServer() {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setHost("localhost");
        connector.setPort(8080);
        connector.setIdleTimeout(30000);

        server.addConnector(connector);
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(TurnsJsonServlet.class, "/turns");
        HandlerList handlers = new HandlerList();
        handlers.setHandlers( new Handler[] {
                servletHandler,
                new ShutdownHandler("shutdownDO", false, true)
        });
        server.setHandler(handlers);

        return server;
    }
}
