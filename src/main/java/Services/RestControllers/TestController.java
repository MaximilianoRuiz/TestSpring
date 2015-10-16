package Services.RestControllers;

import Data.MyResponse;
import Services.Models.Test;
import Services.RestService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/addTest")
    public MyResponse addTest(@RequestParam(value = "nombre", defaultValue = "Test") String nombre,
                          @RequestParam(value = "apellido", defaultValue = "TEST") String apellido) {
        Test test = new Test(nombre, apellido);

        return testService.insertTest(test);
    }

    @RequestMapping("/allTest")
    public MyResponse obtainAllTest() {

        return testService.findAllTest();
    }
}
