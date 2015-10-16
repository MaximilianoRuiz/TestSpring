package Services.RestControllers;

import Data.MyResponse;
import Services.Models.Test;
import Services.RestService.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/addTest")
    public MyResponse addTest(@RequestParam(value = "nombre", defaultValue = "Test") String nombre,
                          @RequestParam(value = "apellido", defaultValue = "TEST") String apellido) {
        Test test = new Test(nombre, apellido);

        return TestService.insertTest(test);
    }

    @RequestMapping("/allTest")
    public MyResponse obtainAllTest() {
        return TestService.findAllTest();
    }
}
