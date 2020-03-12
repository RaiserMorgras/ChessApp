package chess.misc;

import chess.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class BeanLoggingBeansTest {

    @Test
    public void afterPropertiesSet() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestBeanLoggingConfig.class);
        File logFile = new File("LOG.beans");

        assertTrue(logFile.exists());
    }
}

@Configuration
class TestBeanLoggingConfig {
    @Bean
    public BeanLoggingBeans beanLoggingBeans() {
        return new BeanLoggingBeans();
    }
    @Bean
    public IChessUI consoleUI() {
        return new CLIWorker();
    }
    @Bean
    public BoardModel boardModel() {
        return new BoardModel(8,8, new ClassicChessTileGenerator());
    }
    @Bean
    public GameControl gameControl(IChessUI consoleUI, BoardModel boardModel) {
        return new GameControl(consoleUI, boardModel);
    }
}