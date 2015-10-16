package Services.RestControllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import Data.MyResponse;
import Data.ResponseStates;
import Services.Models.Test;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class TimeController {

    DateFormat dateAndTimeFormat = new SimpleDateFormat("dd//MM/yyyy-hh:mm:ss");
    DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy");
    DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

    @RequestMapping("/")
    public String getDateAndTime() {
        return dateAndTimeFormat.format(Calendar.getInstance().getTime());
    }

    @RequestMapping("/getDate")
    public String getDate() {
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    @RequestMapping("/getTime")
    public MyResponse getTime() {
        //String time = timeFormat.format(Calendar.getInstance().getTime());

        Test test = new Test("MAxi", "Ruiz");

        List<Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test);
        testList.add(test);

        MyResponse response = new MyResponse();
        response.setCode(ResponseStates.DONE);
        response.setData(testList);
        return response;
    }
}
