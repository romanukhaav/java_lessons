package lesson24;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*Создайте класс Время, в котором реализованы операции 
 * сложения, вычитания, сравнения, ввода и вывод на экран.
 * Возможность конвертации времени из американского формата 
 * am (pm): 10:00 pm = 22:00,  *  12:00 pm =00:00 
*/

public class TimeRV {

	public int min, hour;
	public boolean tmFormat;
	
	Calendar cal1 = Calendar.getInstance();
	
	public TimeRV set(int h, int m) {
		
		cal1.set(0, 0, 0, h, m );
		
		Date date = new Date(cal1.getTimeInMillis());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("H");
		this.hour = Integer.parseInt(dateFormat.format( date ));
				
		dateFormat = new SimpleDateFormat("m");
		this.min = Integer.parseInt(dateFormat.format( date ));
	      		
		return this;
	}
	
	public TimeRV reduce(){
		return this;
	}
	
	public int diff(){
		return 1;
	}
	
	public TimeRV add(int hour, int min){
		return this;
	}
	
	public void setConvert(boolean tmFormat){
		this.tmFormat = tmFormat;
	}
	
	@Override
	public String toString(){
		String pm = "pm";
		if (24-this.hour>12) pm = "am";
		if (this.tmFormat == true)
			return "Время "+this.hour+" "+this.min;
		else 
			return "Время "+this.hour%12+" "+this.min + " "+pm;
	}

	
	TimeRV(){
		Date date = new Date(cal1.getTimeInMillis());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("H");
		this.hour = Integer.parseInt(dateFormat.format( date ));
				
		dateFormat = new SimpleDateFormat("m");
		this.min = Integer.parseInt(dateFormat.format( date ));
	}
	
	public static void main(String [] arg) {
		
		TimeRV test = new TimeRV();
		test.setConvert(true); //устанавливаем формат времени не амер
		test.set(22, 20);
		System.out.print(test);
		
	}
}
