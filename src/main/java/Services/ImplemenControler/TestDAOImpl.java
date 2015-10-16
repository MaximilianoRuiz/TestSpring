package Services.ImplemenControler;

import Data.GenericDataBaseDaoImpl;
import Services.Models.Test;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class TestDAOImpl extends GenericDataBaseDaoImpl<Test> {

    public static final String TABLE_NAME = "test";
    public static final String[] FIELDS = {"nombre", "apellido"};

    public void addTest(Test test) throws SQLException {
        List<String> fields = Arrays.asList(FIELDS);
        Object [] values = {test.getNombre(),
                test.getApellido()};

        insert(TABLE_NAME, Arrays.asList(FIELDS), values);
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
            test.setApellido((String)map.get("apellido"));
            testList.add(test);
        }

        return testList;
    }
}
