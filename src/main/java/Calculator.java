import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public static long calculate(String day, String start, String end) {

        int price = 0;
        LocalTime startTime = LocalTime.parse(start);
        LocalTime endTime = LocalTime.parse(end);

        if (day.equals("MO") || day.equals("TU") || day.equals("WE") || day.equals("TH") || day.equals("FR")) {
            if (startTime.isAfter(LocalTime.of(0,0)) && startTime.isBefore(LocalTime.of(9,1))) {
                price = 25;
            } else if (startTime.isAfter(LocalTime.of(9,0)) && startTime.isBefore(LocalTime.of(18,1))) {
                price = 15;
            } else {
                price = 20;
            }
        } else if (day.equals("SA") || day.equals("SU")) {
            if (startTime.isAfter(LocalTime.of(0,0)) && startTime.isBefore(LocalTime.of(9,1))) {
                price = 30;
            } else if (startTime.isAfter(LocalTime.of(9,0)) && startTime.isBefore(LocalTime.of(18,1))) {
                price = 20;
            } else {
                price = 25;
            }
        }

        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        return hours * price;
    }
}
