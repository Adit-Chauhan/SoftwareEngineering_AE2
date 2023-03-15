package softwareengineering_ae2.TimetableDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class TimetableDate{

    ZonedDateTime courseScheduledTime;
    DateTimeFormatter courseScheduledTimeFormatter;
    String formattedCourseScheduledTime;



    public String getFormattedCourseScheduled(){
        formattedCourseScheduledTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(courseScheduledTime);
        return formattedCourseScheduledTime;

    }




}

