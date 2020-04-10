package chess.web;

import chess.BoardMove;
import chess.TurnHistory;
import chess.TurnInfoModel;
import chess.gameStates.GameStateID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class ChessMatchesDaoSql implements ChessMatchesDAO {
    protected JdbcTemplate jdbcTemplate;
    private final RowMapper<TurnInfoModel> turnRowMapper = ((resultSet, i) -> {
        BoardMove moveCoords = new BoardMove(
                resultSet.getInt("XFrom"),
                resultSet.getInt("YFrom"),
                resultSet.getInt("XTo"),
                resultSet.getInt("YTo")
        );
        GameStateID playerState = (resultSet.getInt("PlayerID")==0?
                GameStateID.WHITE_PLAYER_TURN:GameStateID.BLACK_PLAYER_TURN);

        return new TurnInfoModel(moveCoords,
                resultSet.getInt("TurnNumber"),
                playerState
        );
    });

    public ChessMatchesDaoSql(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TurnHistory getMatch(int id) {
        List<TurnInfoModel> turnInfoModels= this.jdbcTemplate.query(
                "SELECT TurnNumber, PlayerID, XFrom, YFrom, XTo, YTo " +
                        "FROM Turns " +
                        "WHERE MatchID=?", new Integer[]{id}, turnRowMapper);
        return new TurnHistory(turnInfoModels);
    }

    @Override
    public void saveTurn(int matchID, TurnInfoModel turnInfoModel) {
        String sqlStatement = "INSERT INTO Turns(MatchID, TurnNumber, PlayerID, " +
                "XFrom, YFrom, XTo, YTo) " +
                "VALUES (?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sqlStatement,
                matchID, turnInfoModel.getTurnNumber(),
                turnInfoModel.getGameStateID()==GameStateID.WHITE_PLAYER_TURN?0:1,
                turnInfoModel.getMove().getStartXCoord(),
                turnInfoModel.getMove().getStartYCoord(),
                turnInfoModel.getMove().getEndXCoord(),
                turnInfoModel.getMove().getEndYCoord());
    }
}
