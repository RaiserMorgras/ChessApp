package chess.web.configs;

import chess.DAO.ChessMatchesDAO;
import chess.web.service.ChessMatchesController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ChessMatchesWebConfig {

    @Bean
    public ChessMatchesController controller(ChessMatchesDAO matchesDAO) {
        return new ChessMatchesController(matchesDAO);
    }

}
