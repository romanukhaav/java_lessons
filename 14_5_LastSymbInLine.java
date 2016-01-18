package lesson14;

import java.util.Scanner;

/* Пользователь вводит отдельно строку и символ, 
 * необходимо показать на экран номер по порядку только последнего совпадения (нумерация с единицы).
 */

public class LastSymbInLine {

	private static Scanner scan;
	private static String symbol;

	public static void main( String[] arg) {
		
		// считываем с консоли строку
		System.out.println("Введите строку");
		scan = new Scanner(System.in);
		String myStr = scan.nextLine();

		//считываем символ
		System.out.println("Введите символ");
		symbol = scan.nextLine();
		
		// выводим номер позиции вхождения элемента в строку 
		System.out.print("\n позиции вхождения ");
		for ( int i =myStr.length(); i>0; i--)
			if (myStr.toCharArray()[i-1]==symbol.charAt(0)){
				System.out.print(i +" ");
				break;
			}
		}
}
