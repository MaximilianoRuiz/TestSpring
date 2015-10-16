package Services.RestService;

import Data.MyResponse;
import Data.ResponseStates;
import Services.ImplemenControler.TestDAOImpl;
import Services.Models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDAOImpl testDAO;

    public MyResponse insertTest(Test test) {
        MyResponse response = new MyResponse();
        try {
            testDAO.addTest(test);
            response.setCode(ResponseStates.DONE);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setCode(ResponseStates.ERROR_DB);
        }
        return response;
    }

    public MyResponse findAllTest() {
        MyResponse response = new MyResponse();

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
