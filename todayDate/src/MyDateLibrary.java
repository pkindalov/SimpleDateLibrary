import java.util.Calendar;
import java.util.Date;

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


    /*
        This method return today date in string. Formatting numbers and added leading zeroes
     */

    public String todayDateStr(){
        //Date todayDate;
        StringBuilder date = new StringBuilder();

        this.cal.clear(Calendar.HOUR_OF_DAY);
        this.cal.clear(Calendar.AM_PM);
        this.cal.clear(Calendar.MINUTE);
        this.cal.clear(Calendar.SECOND);
        this.cal.clear(Calendar.MILLISECOND);

        int dayOfMonth = this.cal.get(cal.DAY_OF_MONTH);
        int currentMonth = this.cal.MONTH + 1;

        appendLeadingZero(date, dayOfMonth, currentMonth);


        return date.toString();

    }


    //this method append 0 to date. If date of mount is from 0-9 , then before digit append 0 -> 01, 02,03, 04...
    private void appendLeadingZero(StringBuilder date, int dayOfMonth, int currentMonth) {
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
    }




    //method which return x days after today
    public String dateAfterXdaysFromNow(int howManyDays){

        StringBuilder date = new StringBuilder();

        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + howManyDays);
        int day = cal.get(cal.DAY_OF_MONTH);
        int month = cal.get(cal.MONTH) + 1;


        String debug = "";
        appendLeadingZero(date, day, month);

        return date.toString();


    }


    //method which return x days before today
    public String dateBeforeXdaysFromNow(int howManyDays){
        StringBuilder date = new StringBuilder();

        
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-howManyDays);
        int day = cal.get(cal.DAY_OF_MONTH);
        int month = cal.get(cal.MONTH) + 1;


        String debug = "";
        appendLeadingZero(date, day, month);

        return date.toString();

    }



}
