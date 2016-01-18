package lesson14;

import java.util.Scanner;

/* Пользователь вводит отдельно строку и символ, 
 * необходимо показать на экран номера по порядку всех совпадений (нумерация с единицы).
 */

public class StrToArray {

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
		for ( int i = 0; i<myStr.length(); i++)
			if (myStr.toCharArray()[i]==symbol.charAt(0))	System.out.print(i+1 +" "); 
			else System.out.print("_ ");
		}
}
