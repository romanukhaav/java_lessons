package lesson24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	
	public TimeRV add(int hour, int min){
		cal1.set(0, 0, 0, this.hour+hour, this.min+min);
		
		Date date = new Date(cal1.getTimeInMillis());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("H");
		this.hour = Integer.parseInt(dateFormat.format( date ));
				
		dateFormat = new SimpleDateFormat("m");
		this.min = Integer.parseInt(dateFormat.format( date ));
	      		
		return this;
	}
	
	
	public TimeRV reduce(int hour, int min){
		cal1.set(0, 0, 0, this.hour-hour, this.min-min);
		
		Date date = new Date(cal1.getTimeInMillis());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("H");
		this.hour = Integer.parseInt(dateFormat.format( date ));
				
		dateFormat = new SimpleDateFormat("m");
		this.min = Integer.parseInt(dateFormat.format( date ));
	      		
		return this;
	}
	
	
	public String diff(TimeRV time){
		System.out.println("Сравниваем время");
		if (this.hour > time.hour) 
			return this.toString()+ " > " + time.toString();
		if (this.hour < time.hour) 
			return this.toString()+ " < " + time.toString();
		if (this.hour == time.hour) {
			if (this.min > time.min) 
				return this.toString()+ " > " + time.toString();
			else if (this.min < time.min) 
				return this.toString()+ " < " + time.toString();
			else 
				return this.toString()+ " = " + time.toString();
		}
		return "УПС :( щось не так";
	}
	
	
	public void setConvert(boolean tmFormat){
		this.tmFormat = tmFormat;
		if(this.tmFormat==true)
			System.out.println("Установлен европейский формат");
		else
			System.out.println("Установлен американский формат");
	}
	
	@Override
	public String toString(){
		String pm = "pm";
		if (24-this.hour>12) pm = "am";
		if (this.tmFormat == true)
			return "Время "+this.hour+":"+this.min;
		else 
			return "Время "+this.hour%12+":"+this.min + " "+pm;
	}

	
	TimeRV(){
		Date date = new Date(cal1.getTimeInMillis());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("H");
		this.hour = Integer.parseInt(dateFormat.format( date ));
				
		dateFormat = new SimpleDateFormat("m");
		this.min = Integer.parseInt(dateFormat.format( date ));
		
		this.tmFormat = true;
	}
	
	TimeRV(int hour, int min){
		
		cal1.set(0, 0, 0, hour, min );
		Date date = new Date(cal1.getTimeInMillis());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("H");
		this.hour = Integer.parseInt(dateFormat.format( date ));
				
		dateFormat = new SimpleDateFormat("m");
		this.min = Integer.parseInt(dateFormat.format( date ));
		
		this.tmFormat = true;
	}
	
	
	public static void main(String [] arg) throws IOException {
		
		TimeRV time1 = new TimeRV();
		time1.setConvert(true); //устанавливаем формат времени не амер
		time1.set(20, 20);
		System.out.println(time1);
		time1.add(0,1);
		System.out.println(time1);
		time1.reduce(2,2);
		System.out.println(time1);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Введите сколько часов");
        int hour = Integer.parseInt(reader.readLine());
        
        System.out.println("Введите сколько минут");
        int min = Integer.parseInt(reader.readLine());
        
		TimeRV time2 = new TimeRV(hour, min);
		time2.setConvert(true);
		System.out.println(time2);
		//time2 = time1;
		System.out.println(time1.diff(time2));
		
	}
}
