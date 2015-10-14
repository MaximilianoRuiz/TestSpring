package Services.DAOs;

import Data.DBConnector;
import Services.Models.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestDAOImpl implements TestDAO {

    public final String INSERT_NEW_TEST_SQL = "INSERT INTO test (nombre, apellido) VALUES(?, ?)";
    public final String OBTAIN_ALL_TEST_SQL = "SELECT nombre, apellido FROM test";

    @Override
    public void add(Test test) throws SQLException {
        DBConnector.getInstance().getInstanceJdbcTemplate().
                update(INSERT_NEW_TEST_SQL, test.getNombre(), test.getApellido());
    }

    @Override
    public List<Test> obtainAll() throws SQLException {
        List<Test> allTest = DBConnector.getInstance().getInstanceJdbcTemplate().
                query(OBTAIN_ALL_TEST_SQL, new RowMapper<Test>() {
            @Override
            public Test mapRow(ResultSet resultSet, int i) throws SQLException {
                Test test = new Test();
                test.setNombre(resultSet.getString("nombre"));
                test.setApellido(resultSet.getString("apellido"));
                return test;
            }
        });
        return allTest;
    }
}
