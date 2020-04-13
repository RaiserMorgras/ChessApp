package chess.web;

import chess.BoardMove;
import chess.TurnInfoModel;
import chess.gameStates.GameStateID;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

public class ChessMatchesDaoSqlTest {
    private AnnotationConfigApplicationContext ctx;
    private ChessMatchesDaoSql daoSql;
    private final String firstMoveString = "e2 e4";
    private final String secondMoveString = "e7 e5";
    @Before
    public void setUp(){
        ctx = new AnnotationConfigApplicationContext(HSqlDaoConfig.class);
        daoSql = ctx.getBean(ChessMatchesDaoSql.class);
    }

    @Test
    public void getMatch() {
        List<TurnInfoModel> turnList = daoSql.getMatch(1);

        assertEquals(2, turnList.size());
        assertEquals(firstMoveString, turnList.get(0).getMove().toString());
    }

    @Test
    public void saveTurn() {
        TurnInfoModel blackTurn = new TurnInfoModel(BoardMove.parseBoardMove(secondMoveString),
                1, GameStateID.BLACK_PLAYER_TURN);

        daoSql.saveTurn(1, blackTurn);

        List<TurnInfoModel> turnList = daoSql.getMatch(1);
        assertEquals(2, turnList.size());
        //asserting first turn
        assertEquals(firstMoveString, turnList.get(0).getMove().toString());
        //asserting recently added second turn
        assertEquals(secondMoveString, turnList.get(1).getMove().toString());
    }
}

@Configuration
class HSqlDaoConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:matchesmemdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
    @Bean
    public ChessMatchesDaoSql daoSql(DataSource dataSource) {
        return new ChessMatchesDaoSqlInitCreate(dataSource);
    }
}

class ChessMatchesDaoSqlInitCreate extends ChessMatchesDaoSql {

    public ChessMatchesDaoSqlInitCreate(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate.execute("CREATE TABLE Turns (" +
                "MatchID int," +
                "TurnNumber int," +
                "PlayerID int," +
                "XFrom int," +
                "YFrom int," +
                "XTo int," +
                "YTo int," +
                "PRIMARY KEY (MatchID, TurnNumber, PlayerID));");
        this.jdbcTemplate.update("INSERT INTO Turns " +
                "VALUES (1, 1, 0, 1, 4, 3, 4)"); //should correspond to move "e2 e4"
    }
}