package Services.DAOs;

import Data.DBConnector;
import Data.GenericDao;
import Data.GenericDaoImpl;
import Services.Models.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestDAOImpl extends GenericDaoImpl<Test> {

//    public final String INSERT_NEW_TEST_SQL = "INSERT INTO test (nombre, apellido) VALUES(?, ?)";
//    public final String OBTAIN_ALL_TEST_SQL = "SELECT nombre, apellido FROM test";

    public static final String TABLE_NAME = "test";
    public static final String[] FIELDS = {"nombre", "apellido"};

    public void saveTest(Test test) throws SQLException {
        List<String> fields = Arrays.asList(FIELDS);
        Object [] values = {test.getNombre(),
                test.getApellido()};

        add(TABLE_NAME, Arrays.asList(FIELDS), values);
    }

    public  List<Test> findAllTest() throws SQLException {
        List<Map<String, Object>> listMapTest = findAll(TABLE_NAME);
        List<Test> allTest = obtainTestList(listMapTest);

        return allTest;
    }

    private List<Test> obtainTestList (List<Map<String, Object>> listMap) {
        List<Test> testList = new ArrayList<>();

        for (Map<String, Object> map : listMap) {
            Test test = new Test();
            test.setNombre((String)map.get("nombre"));
            test.setNombre((String)map.get("apellido"));
            testList.add(test);
        }

        return testList;
    }
}
