package chess.web;

import chess.BoardMove;
import chess.TurnHistory;
import chess.TurnInfoModel;
import chess.gameStates.GameStateID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import java.sql.Driver;

import static org.junit.Assert.*;

public class ChessMatchesDaoSqlTest {
    private AnnotationConfigApplicationContext ctx;
    private ChessMatchesDaoSql daoSql;
    @Before
    public void setUp(){
        ctx = new AnnotationConfigApplicationContext(HSqlDaoConfig.class);
        daoSql = ctx.getBean(ChessMatchesDaoSql.class);
    }

    @Test
    public void getMatch() {
        TurnHistory turnHistory = daoSql.getMatch(1);
        turnHistory.beginIteration();
        TurnInfoModel turn = turnHistory.nextTurn();

        assertEquals("e2 e4", turn.getMove().toString());
    }

    @Test
    public void saveTurn() {
        TurnInfoModel blackTurn = new TurnInfoModel(BoardMove.parseBoardMove("e7 e5"),
                1, GameStateID.BLACK_PLAYER_TURN);

        daoSql.saveTurn(1, blackTurn);

        TurnHistory turnHistory = daoSql.getMatch(1);
        turnHistory.beginIteration();
        turnHistory.nextTurn(); //skip first turn
        TurnInfoModel turn = turnHistory.nextTurn();

        assertEquals("e7 e5", turn.getMove().toString());
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