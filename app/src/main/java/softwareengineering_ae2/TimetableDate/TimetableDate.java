package softwareengineering_ae2.TimetableDate;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class TimetableDate implements Serializable{
    private static final long serialVersionUID = 1L;
    ZonedDateTime courseScheduledTime;
    DateTimeFormatter courseScheduledTimeFormatter;
    String formattedCourseScheduledTime;



    public String getFormattedCourseScheduled(){
        formattedCourseScheduledTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(courseScheduledTime);
        return formattedCourseScheduledTime;

    }

    public void setTime(ZonedDateTime time){
        courseScheduledTime = time;
    }

    public ZonedDateTime getTime(){
        return courseScheduledTime;
    }




}

