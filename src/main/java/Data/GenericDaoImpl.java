package Data;

import Services.Models.Test;
import com.sun.deploy.util.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class GenericDaoImpl<T> implements GenericDao<T>{

    private final String SELECT_ALL = "SELECT * FROM ";

    private final String INSERT = "INSERT INTO ";
    private final String VALUES = "VALUES(";

    @Override
    public void add(String tableName, List<String> fields, Object[] values) throws SQLException {
        DBConnector.getInstance().getInstanceJdbcTemplate().
                update(createSqlInsert(tableName, fields, values.length), values);
    }

    @Override
    public  List<Map<String, Object>> findAll(String tableName) throws SQLException {
        List<Map<String, Object>> allTest = DBConnector.getInstance().getInstanceJdbcTemplate().
                queryForList(createSqlSelectAll(tableName));

        return allTest;
    }

    private String createSqlInsert(String tableName, List<String> fieldsList, int valuesCount){
        String result;
        String fields = StringUtils.join(fieldsList, ", ");
        StringBuilder sql = new StringBuilder();
        sql.append(INSERT).
                append(tableName).
                append("(").append(fields).append(") ").
                append(VALUES);

        for (int i = 0; i < valuesCount; i++) {
            sql.append("? ,");
        }

        sql.append(")");

        result = sql.toString();
        return result.replace(",)", ")");
    }

    private String createSqlSelectAll(String tableName) {
        return SELECT_ALL + tableName;
    }
}
