package lesson14;

import java.util.Scanner;

/* Удалить с m по n символов, перезаписать строку и показать ее на экран. */

public class DellStrSegment {
	
	private static Scanner scan;
	private static int x, x1, x2;
	private static boolean isCorrect = false;

	public static void main( String[] arg) {
		
		// считываем с консоли строку
		System.out.println("Введите строку");
		scan = new Scanner(System.in);
		String myStr = scan.nextLine();

		while (!isCorrect){
			//считываем позиции концов сегмента
			try {
				System.out.println("Введите позицию первого конца сегмента строки");
				x1 = scan.nextInt();
				
				System.out.println("Введите позицию второго конца сегмента строки");
				x2 = scan.nextInt();
			}
			catch(Exception err) {
				System.out.println("Ошибка! введите числа");
				scan = new Scanner(System.in);
				continue;
			}
			
			//проверка позиций сегмента и длинны строки
			if (myStr.length()<x1||myStr.length()<x2||x1<=0||x2<=0){
				System.out.println("Ошибка! Концы сегмента вне пределов строки");
				continue;
			}
			if (x1>x2) { //расставляем концы сегмента в правилной последовательности
				x = x1; 
				x1 = x2;
				x2 = x;
			}
			isCorrect = true;
		}
		
		//обрезаем строку и выводим результат
		myStr = myStr.substring(0,x1-1) + " " + myStr.substring(x2,myStr.length());
		System.out.print(myStr);
		}
}
