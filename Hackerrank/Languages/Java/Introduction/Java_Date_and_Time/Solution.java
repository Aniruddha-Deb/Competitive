import java.time.*;

public class Solution {
    public static String getDay(String day, String month, String year) {
        LocalDate localDate = LocalDate.of( Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day) ); 
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString();
    }
