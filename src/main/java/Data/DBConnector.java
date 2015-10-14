package Data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost/contactdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static DBConnector instance = null;

    private SimpleDriverDataSource dataSource = null;
    private JdbcTemplate instanceJdbcTemplate = null;

    public DBConnector() throws SQLException {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        instanceJdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static DBConnector getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    public JdbcTemplate getInstanceJdbcTemplate() {
        return instanceJdbcTemplate;
    }
}
