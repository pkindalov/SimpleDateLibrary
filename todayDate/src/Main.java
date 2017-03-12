import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * Created by r3v3nan7 on 11.03.17.
 */
public class Main {

    public static void main(String[] args) throws ParseException, DataFormatException {
        MyDateLibrary today = new MyDateLibrary(new Date());
        MyDateLibrary today2 = new MyDateLibrary(new Date(), '/');
        MyDateLibrary today3 = new MyDateLibrary(new Date(), ' ');
        MyDateLibrary today4 = new MyDateLibrary(new Date(), '.');
        MyDateLibrary today5 = new MyDateLibrary(new Date(), '\\');

        System.out.println(today.todayDateStr());
        System.out.println(today2.todayDateStr());
        System.out.println(today3.todayDateStr());
        System.out.println(today4.todayDateStr());
        System.out.println(today5.todayDateStr());
        System.out.println();
        System.out.println(today.getClass().getName());
        System.out.println();

        String dateStr = today.todayDateStr();
        System.out.println(dateStr);

        DateFormat df = new SimpleDateFormat("dd-ML-yyyy");
        Date date = df.parse(dateStr);
        System.out.println(date);
        System.out.println(date.getClass().getName());

        System.out.println("-----------------------------------------------------------");

        System.out.println(today.todayDate());
        System.out.println(today2.todayDate());
        System.out.println(today3.todayDate());
        System.out.println(today4.todayDate());
        System.out.println(today5.todayDate());
        System.out.println(today.getClass().getName());


    }

}
