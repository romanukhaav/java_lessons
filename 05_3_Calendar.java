package lesson5;

//При помощи цикла показать на экран календарь текущего месяца.
//робота з датами тут http://www.seostella.com/ru/article/2012/02/05/formatirovanie-daty-v-java.html

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {
	@SuppressWarnings("deprecation")
	public static void main (String[] args){ 
		
		//тестую вивід часу
		System.out.println(new Date(System.currentTimeMillis()-1000*60*60*24*2));
		System.out.println(new Date(System.currentTimeMillis()-1000*60*60*24*1));
		System.out.print("Поточна дата = " );
		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(new Date(System.currentTimeMillis()+1000*60*60*24*1));
		System.out.println();
		
		//тестую клас SimpleDateFormat
		Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
              
        dateFormat = new SimpleDateFormat("d");
        long day = Integer.parseInt(dateFormat.format( currentDate ));
        System.out.println("Текущее число: " + day);
        
        //Тест формата вывода
        dateFormat = new SimpleDateFormat("dd MMMM");
        System.out.println("Сегодня: " + dateFormat.format( currentDate ) );
        Date firstDay = new Date(System.currentTimeMillis()-1000*60*60*24*(day-1));
        System.out.println("Первый день месяца: " + dateFormat.format( firstDay));
        
        dateFormat = new SimpleDateFormat("E");
        String wDay = dateFormat.format( firstDay);
        System.out.println("День недели для первого дня месяца: " + wDay);
        
        dateFormat = new SimpleDateFormat("M");
        int mons = Integer.parseInt(dateFormat.format( currentDate ));
        System.out.println("Номер текущего месяца: " + mons);
        System.out.println();                               
  
        
        //друкуємо шапку з днів тижня і проржні дні 
        //визначаємо номер дня тижня для першого дня місяця
        
        System.out.println("пн вт ср чт пт сб нд");
        int nWeek = firstDay.getDay();
        if (nWeek==0){nWeek=7;}
        for (int j=1; j<nWeek; j++) {
        	System.out.print("   ");
        }
        
    	//цикл виводу усіх днів місяця, починається вивід з першого дня 
        //і триває доти, поки не збільшиться номер поточного місяця
        int monTest = mons;
        int i = 0;

        while (mons==monTest) {
            //цикл для відображення дат по сім днів; після циклу перевод каретки      	
        	for (int j=nWeek; j<8; j++){
        		//створюю дату для друку = поточна_дата-day+1=перший_день_місяця+ітерація
	        	Date datePrint = new Date(System.currentTimeMillis()+1000*60*60*24*(i-day+1));
	        	i++;
	        	//перевірка чи не змінився місяць
	            dateFormat = new SimpleDateFormat("M");
	        	monTest=Integer.parseInt(dateFormat.format( datePrint ));
	        	if (mons!=monTest) {break;};
	        	//друкую день
	        	dateFormat = new SimpleDateFormat("dd");
	            System.out.print(dateFormat.format( datePrint )+" ");
        	}
 
        	//після допису днів неповного першого тижня місяця nWeek=1,
        	//тобто наступний тиждень вже буде з понеділка
        	nWeek=1;        	
        	System.out.println();
        }
    }
}
