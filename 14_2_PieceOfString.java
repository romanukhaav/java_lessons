package lesson14;

import java.util.Scanner;

/* Показать на экран с m по n символов строки, введенной пользователем
 * и записать данный отрезок в другой массив. (m и n также вводятся пользователем)
 */

public class PieceOfString {
	
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
			}
			
			//проверка позиций сегмента и длинны строки
			if (myStr.length()<x1||myStr.length()<x2){
				System.out.println("Ошибка! Концы сегмента вне пределов строки");
				System.exit(0);
			}
			if (x1>x2) { //расставляем концы сегмента в правилной последовательности
				x = x1; 
				x1 = x2;
				x2 = x;
			}
			isCorrect = true;
		}
		
		//обрезаем строку
		myStr = (String) myStr.subSequence(x1,x2); 
		
		// создаем массив c длинной в колличество символов в сегменте
		char  arr []= new char[myStr.length()];
		
		// заполняем массив и выводим результаты
		for ( int i = 0; i<myStr.length() ; i++) {
			arr[i]=myStr.toCharArray()[i];
			System.out.print(arr[i]+" ");	
		}
	}
}
