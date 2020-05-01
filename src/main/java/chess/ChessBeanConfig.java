package chess;

import chess.UI.IChessUI;
import chess.UI.IOStreamUIWorker;
import chess.control.GameControl;
import chess.model.BoardModel;
import chess.model.ClassicChessTileGenerator;
import chess.model.TileGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.io.OutputStream;


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
    public GameControl gameControl(IChessUI chessStreamUI, BoardModel boardModel) {
        return new GameControl(chessStreamUI, boardModel);
    }

    @Bean
    public IOStreamUIWorker chessStreamUI(InputStream inputStream,
                                          OutputStream outputStream,
                                          OutputStream errorStream) {
        return new IOStreamUIWorker(inputStream, outputStream, errorStream);
    }
}
