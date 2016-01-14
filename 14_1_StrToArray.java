package lesson14;

import java.util.Scanner;

/* Пользователь вводит строку с клавиатуры в фиксированный массив.
 * Необходимо проверить, cколько элементов массива теперь занято, 
 * сколько свободно и сколько всего вообще
 */

public class StrToArray {
	private static Scanner scan;

	public static void main( String[] arg) {
		
		// создаем массив с произвольной длинной от 20 до 30 символов
		int arrLen = (int)(20+Math.random()*10);
		char  arr []= new char[arrLen];
		
		// считываем с консоли строку
		System.out.println("Введите строку");
		scan = new Scanner(System.in);
		String myStr = scan.nextLine();
		
		//проверка соответствия длинны строки и массива
		if (myStr.toCharArray().length>arrLen){
			System.out.println("Ошибка! - ваша строка больше чем созданный массив");
			System.exit(0);
		}
		
		//заполняем массив
		for ( int i = 0; i<myStr.toCharArray().length; i++)
			arr[i]=myStr.toCharArray()[i];
		
		// вычисляем колличество занятых, свободных элементов и размер массива и выводим результаты
		System.out.print("Получен массив");
		for ( int i = 0; i<arr.length; i++)
			if (arr[i]!='\0')	System.out.print(arr[i]+" "); // '\0' - пустой символ
			else System.out.print("_ ");
		
		System.out.println("Длинна массива = " + arrLen);
		System.out.println("Занятых елементов = " + myStr.toCharArray().length);
		System.out.println("Свободных елементов = " + (arrLen-myStr.toCharArray().length));
	}
	
}
