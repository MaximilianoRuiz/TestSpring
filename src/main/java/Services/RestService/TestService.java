package Services.RestService;

import Data.MyResponse;
import Data.ResponseStates;
import Services.ImplemenControler.TestDAOImpl;
import Services.Models.Test;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TestService {

    public TestService() {
    }

    public static MyResponse insertTest(Test test) {
        MyResponse response = new MyResponse();
        TestDAOImpl testDAO = new TestDAOImpl();
        try {
            testDAO.addTest(test);
            response.setCode(ResponseStates.DONE);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setCode(ResponseStates.ERROR_DB);
        }
        return response;
    }

    public static MyResponse findAllTest() {
        MyResponse response = new MyResponse();
        TestDAOImpl testDAO = new TestDAOImpl();

        try {
            List<Test> testList = testDAO.findAllTest();
            response.setCode(ResponseStates.DONE);
            response.setData(testList);
        } catch (SQLException e) {
            response.setCode(ResponseStates.ERROR_DB);
            e.printStackTrace();
        }
        return response;
    }
}
