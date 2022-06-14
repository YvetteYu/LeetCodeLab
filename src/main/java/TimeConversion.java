import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {

    public static String timeConversion(String s) {
        // Write your code here
        String timeString = s.toUpperCase();
        Pattern pattern = Pattern.compile("(\\d+):(\\d+:\\d+)\\s*([AP])M");
        Matcher m = pattern.matcher(timeString);

        if (!m.find()) {
            System.out.println("Invalid input time string format.");
            return null;
        }

        int hour = Integer.valueOf(m.group(1));
        String minAndSec = m.group(2);
        String timeZone = m.group(3);

        switch(timeZone){
            case "A":
                if(hour == 12)
                    hour = 0;
                break;
            case "P":
                if(hour < 12) {
                    hour += 12;
                }
                break;
            default:
                break;
        }
        String result = String.format("%02d", hour) + ":" + minAndSec;
        return result;
    }

    public static void main(String[] args) {
        timeConversion("12:12:13Am");
        timeConversion("12:12:13pm");
        timeConversion("8:12:13AM");
        timeConversion("05:12:13AM");
    }
}
