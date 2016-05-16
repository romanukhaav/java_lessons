package lesson22;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*Создайте класс Date, который будет содержать информацию о дате (день, месяц, год).
 * Определите операцию разности двух дат (результат в виде количества дней между датами),
 * а также операцию увеличения даты на определенное количество дней. 
 */

public class DateMy {
	
	// конструктор по умолчанию - возвращает текущую дату
	public DateMy(){
		Date currentDate = new Date();
              
        SimpleDateFormat dateFormat = new SimpleDateFormat("d");
		this.day = Integer.parseInt(dateFormat.format( currentDate ));
		
		dateFormat = new SimpleDateFormat("M");
		this.month = Integer.parseInt(dateFormat.format( currentDate ));
		
		dateFormat = new SimpleDateFormat("Y");
		this.year = Integer.parseInt(dateFormat.format( currentDate ));
	}
	
	// конструктор принимающий значение даты
	public DateMy(int y, int m, int d){
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	public int day, month, year;
	
	//метод сравнения двух дат возвращает колличество дней между двумя датами
	public long diff(DateMy dayOf){

		Calendar cal1 = Calendar.getInstance();
		cal1.set(this.year, this.month, this.day);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(dayOf.year, dayOf.month, dayOf.day);
		
		return ((cal2.getTimeInMillis()/1000/60/60/24 - cal1.getTimeInMillis()/1000/60/60/24);
	}
	
	//метод добавления дней
	public DateMy add(int num){
		Calendar cal1 = Calendar.getInstance();
		
		cal1.set(this.year, this.month-1, this.day+num);
		
		Date date = new Date(cal1.getTimeInMillis());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("d");
		this.day = Integer.parseInt(dateFormat.format( date ));
				
		dateFormat = new SimpleDateFormat("M");
		this.month = Integer.parseInt(dateFormat.format( date ));
	      		
		dateFormat = new SimpleDateFormat("Y");
		this.year = Integer.parseInt(dateFormat.format( date ));
				
		return this;
	}
	
	//переписываем метод  toString
	public java.lang.String toString(){
		return "Дата: "+ this.day+" "+ this.month+" " +this.year;
	}


public static void main(java.lang.String[] args){ 
		      
        DateMy dat1 = new DateMy(2015,02,21);
        System.out.println(dat1);
        
        DateMy dat2 = new DateMy(2015,02,01);
        System.out.println(dat2);
        
        System.out.println("Разница в днях = "+ dat1.diff(dat2));
        
        int days = 375;
        System.out.println("\nДобавляем " + days + " дней к посл.дате");
        System.out.println(dat2.add(days));
  }
  
}
