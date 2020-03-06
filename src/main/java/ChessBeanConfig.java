import chess.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChessBeanConfig {
    @Bean
    public TileGenerator tileGenerator() {
        return new ClassicChessTileGenerator();
    }
    @Bean
    public BoardModel boardModel(TileGenerator tileGenerator) {
        return new BoardModel(8,8, tileGenerator);
    }
    @Bean
    public IChessUI chessUI() {
        return new CLIWorker();
    }
    @Bean
    public GameControl gameControl(IChessUI chessUI, BoardModel boardModel) {
        return new GameControl(chessUI, boardModel);
    }
}
