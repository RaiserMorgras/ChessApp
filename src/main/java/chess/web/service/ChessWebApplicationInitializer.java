package chess.web.service;

import chess.web.configs.ChessMatchesWebConfig;
import chess.web.configs.ChessTurnRecordConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ChessWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) {
        AnnotationConfigWebApplicationContext webctx =
                new AnnotationConfigWebApplicationContext();
        webctx.register(ChessMatchesWebConfig.class);
        webctx.setServletContext(sc);

        AnnotationConfigWebApplicationContext appctx = new AnnotationConfigWebApplicationContext();
        appctx.register(ChessTurnRecordConfig.class);
        sc.addListener(new ContextLoaderListener(appctx));

        ServletRegistration.Dynamic appServlet = sc.addServlet("dispatcher", new DispatcherServlet(webctx));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/matches/*");
    }


}
