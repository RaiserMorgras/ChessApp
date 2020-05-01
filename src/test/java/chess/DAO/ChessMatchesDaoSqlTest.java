package chess.DAO;

import chess.model.BoardMove;
import chess.model.TurnInfoModel;
import chess.model.states.GameStateID;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ChessMatchesDaoSqlTest {
    private AnnotationConfigApplicationContext ctx;
    private ChessMatchesDaoSql daoSql;
    private final String firstMoveString = "e2 e4";
    private final String secondMoveString = "e7 e5";
    private UUID someUUID;
    @Before
    public void setUp(){
        ctx = new AnnotationConfigApplicationContext(HSqlDaoConfig.class);
        daoSql = ctx.getBean(ChessMatchesDaoSql.class);
        someUUID = ctx.getBean(UUID.class);
    }

    @Test
    public void getMatch() {
        List<TurnInfoModel> turnList = daoSql.getMatch(someUUID);

        assertEquals(1, turnList.size());
        assertEquals(firstMoveString, turnList.get(0).getMove().toString());
    }

    @Test
    public void saveTurn() {
        TurnInfoModel blackTurn = new TurnInfoModel(BoardMove.parseBoardMove(secondMoveString),
                1, GameStateID.BLACK_PLAYER_TURN);
        daoSql.saveTurn(someUUID, blackTurn);

        List<TurnInfoModel> turnList = daoSql.getMatch(someUUID);
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
    public ChessMatchesDaoSql daoSql(DataSource dataSource, UUID someUUID) {
        return new ChessMatchesDaoSqlTestInitCreate(dataSource, someUUID);
    }
    @Bean
    public UUID someUUID() {
        return UUID.randomUUID();
    }
}

class ChessMatchesDaoSqlTestInitCreate extends ChessMatchesDaoSql {

    public ChessMatchesDaoSqlTestInitCreate(DataSource dataSource, UUID someUUID) {
        super(dataSource);
        this.jdbcTemplate.execute("CREATE TABLE Turns (" +
                "MatchID UUID," +
                "TurnNumber int," +
                "PlayerID int," +
                "XFrom int," +
                "YFrom int," +
                "XTo int," +
                "YTo int," +
                "PRIMARY KEY (MatchID, TurnNumber, PlayerID));");
        this.jdbcTemplate.update("INSERT INTO Turns " +
                "VALUES (?, 1, 0, 1, 4, 3, 4)", someUUID); //should correspond to move "e2 e4"
    }
}