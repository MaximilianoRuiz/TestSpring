package Services.Controllers;

import Services.DAOs.TestDAO;
import Services.DAOs.TestDAOImpl;
import Services.Models.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/addTest")
    public String addTest(@RequestParam(value = "nombre", defaultValue = "Test") String nombre,
                          @RequestParam(value = "apellido", defaultValue = "TEST") String apellido) {
        Test test = new Test(nombre, apellido);
        TestDAO testDAO = new TestDAOImpl();
        try {
            testDAO.add(test);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Listo";
    }

    @RequestMapping("/allTest")
    public List<Test> obtainAllTest() {
        List<Test> testList = new ArrayList<>();
        TestDAO testDAO = new TestDAOImpl();
        try {
            testList = testDAO.obtainAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testList;
    }
}
