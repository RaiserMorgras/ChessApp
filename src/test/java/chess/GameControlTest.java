package chess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.*;

public class GameControlTest {
    private ApplicationContext ctx;
    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(ChessTestConfig.class);
    }

    @Test
    public void start() {
        InputStream inputStream = ctx.getBean(InputStream.class);
        OutputStream outputStream = ctx.getBean("outputStream", OutputStream.class);
        OutputStream errorStream = ctx.getBean("errorStream", OutputStream.class);
        GameControl gc = (GameControl) ctx.getBean("gameControl");
        gc.start();
        System.out.println(outputStream.toString());
        System.err.println(errorStream.toString());
    }

    @After
    public void tearDown() {
        ((AnnotationConfigApplicationContext) ctx).close();
    }
}

@Configuration
@Import(ChessBeanConfig.class)
class ChessTestConfig {
    @Autowired ChessBeanConfig chessBeanConfig;

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
    public OutputStream outputStream() {
        return new ByteArrayOutputStream();
    }
    @Bean
    public OutputStream errorStream() {
        return new ByteArrayOutputStream();
    }
}