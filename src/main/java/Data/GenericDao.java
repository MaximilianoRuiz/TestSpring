package Data;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface GenericDao<T> {

    void add(String tableName, List<String> fields, Object[] values) throws SQLException;
    List<Map<String, Object>> findAll(String tableName) throws SQLException;
}
