package chess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class GameControlTest {
    private ApplicationContext ctx;
    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ChessBeanConfig.class);
    }

    @Test
    public void start() {
        GameControl gc = (GameControl) ctx.getBean("gameControl");
        gc.start();
    }
}