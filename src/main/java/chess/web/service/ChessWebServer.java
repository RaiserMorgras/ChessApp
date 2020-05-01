package chess.web.service;

import chess.control.GameControl;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.annotations.ClassInheritanceHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.WebApplicationInitializer;

public class ChessWebServer {
    private Server server;
    private GameControl gameControl;
    public void createServer() {
        this.server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setHost("localhost");
        connector.setPort(8080);
        connector.setIdleTimeout(30000);
        server.addConnector(connector);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setResourceBase("resource");
        webAppContext.setContextPath("/");
        webAppContext.setConfigurations(new Configuration[] {
                new AnnotationConfiguration() {
                    @Override
                    public void preConfigure(WebAppContext context) {
                        ClassInheritanceMap map = new ClassInheritanceMap();
                        map.put(WebApplicationInitializer.class.getName(), new ConcurrentHashSet<>() {{
                            add(ChessWebApplicationInitializer.class.getName());
                        }});
                        context.setAttribute(CLASS_INHERITANCE_MAP, map);
                        _classInheritanceHandler = new ClassInheritanceHandler(map);
                    }
                }
        });
        server.setHandler(webAppContext);

        server.setStopAtShutdown(true);
        gameControl = server.getBean(GameControl.class);
    }

    public void start() throws Exception {
        gameControl.start();
        server.start();
    }
    public void join() throws Exception {

        server.join();
    }
}
