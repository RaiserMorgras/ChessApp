package chess.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ChessMatchesWebConfig {

    @Bean
    public ChessMatchesController controller(ChessMatchesDAO matchesDAO) {
        ChessMatchesController controller = new ChessMatchesController();
        controller.setChessMatchesDAO(matchesDAO);
        return controller;
    }

}
