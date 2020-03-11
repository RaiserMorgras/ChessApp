package chess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

import static org.junit.Assert.*;

public class LoggingUIWorkerTest {
    private LoggingUIWorker loggingUIWorker;
    private ApplicationContext ctx;
    @Before
    public void setUp(){
        ctx = new AnnotationConfigApplicationContext(LoggingBeanConfig.class);
        loggingUIWorker = ctx.getBean(LoggingUIWorker.class);
    }

    @Test
    public void showBoardState() {
        BoardModel bm = new BoardModel(8, 8, new ClassicChessTileGenerator());
        loggingUIWorker.showBoardState(bm);
        assertTrue(new File("LOG.info").exists());
    }

    @Test
    public void getMoveCommand() {
    }

    @Test
    public void turnStartSequence() {
    }

    @Test
    public void putErrorMessage() {
    }

    @Test
    public void gameEndSequence() {
    }
}
@Configuration
class LoggingBeanConfig {
    @Bean
    public Logger errorLogger() {
        return LogManager.getLogger("root");
    }
    @Bean
    public Logger infoLogger() {
        return LogManager.getLogger("infoOutput");
    }
    @Bean
    public LoggingUIWorker getUIWorker(Logger infoLogger, Logger errorLogger) {
        return new LoggingUIWorkerImpl(infoLogger, errorLogger);
    }
}