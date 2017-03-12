import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * Created by r3v3nan7 on 11.03.17.
 */
public class MyDateLibrary {

    private Date dateNow;
    private Character delimeter;
    private Calendar cal;


    public void setDateNow(Date dateNow) {
        this.dateNow = dateNow;
    }


    public MyDateLibrary(Date dateNow){
        this.setDateNow(dateNow);
        this.cal = Calendar.getInstance();
        this.delimeter = '-';
    }


    public MyDateLibrary(Date dateNow, char delimeter){
        this(dateNow);
        this.delimeter = delimeter;
    }


    public String todayDateStr(){
        //Date todayDate;
        StringBuilder date = new StringBuilder();

        cal.clear(Calendar.HOUR_OF_DAY);
        cal.clear(Calendar.AM_PM);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        int dayOfMonth = cal.get(cal.DAY_OF_MONTH);
        int currentMonth = cal.MONTH + 1;

        if(dayOfMonth < 10){
            date.append("0");
            date.append(dayOfMonth);
        }else {
            date.append(dayOfMonth);
        }

        date.append(this.delimeter);

        if(currentMonth < 10){
            date.append("0");
            date.append(currentMonth);
        }else {
            date.append(currentMonth);
        }


        date.append(this.delimeter);
        date.append(cal.get(cal.YEAR));


        return date.toString();

    }






    public Date todayDate() throws DataFormatException, ParseException {
        Date currentDate = new Date();
        StringBuilder date = new StringBuilder();

        cal.clear(Calendar.HOUR_OF_DAY);
        cal.clear(Calendar.AM_PM);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        int dayOfMonth = cal.get(cal.DAY_OF_MONTH);
        int currentMonth = cal.MONTH + 1;

        if(dayOfMonth < 10){
            date.append("0");
            date.append(dayOfMonth);
        }else {
            date.append(dayOfMonth);
        }

        date.append(this.delimeter);

        if(currentMonth < 10){
            date.append("0");
            date.append(currentMonth);
        }else {
            date.append(currentMonth);
        }


        date.append(this.delimeter);
        date.append(cal.get(cal.YEAR));

        DateFormat sdf = new SimpleDateFormat("dd-ML-yyyy");

        switch (delimeter){
            case '/':
                sdf = new SimpleDateFormat("dd/ML/yyyy");
                break;
            case ' ':
                sdf = new SimpleDateFormat("dd ML yyyy");
                break;
            case '.':
                sdf = new SimpleDateFormat("dd.ML.yyyy");
                break;
            case '\\':
                sdf = new SimpleDateFormat("dd\\ML\\yyyy");
                break;
        }


        currentDate = sdf.parse(date.toString());

        return currentDate;
    }



}
