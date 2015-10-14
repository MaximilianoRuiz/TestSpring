package Services.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String getTime() {
        return timeFormat.format(Calendar.getInstance().getTime());
    }
}
