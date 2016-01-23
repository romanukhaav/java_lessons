package lesson15;

import java.util.ArrayList;
import java.util.Scanner;

/* Написать программу, которая осуществляет добавление строки или столбца 
 * в любое место двумерной матрицы по выбору пользователя.
*/

public class InsertLineInTable {
	
	static int myInt;
	
	public static void main (String[] arg) {
		
		int n = (int)(3+Math.random()*3); //размерность матрицы
		//int n = 5;
		System.out.println("размерность матрицы = "+n+"\n");
		
		
		boolean isCorrect = false;
		Scanner scan;
		ArrayList<ArrayList<Integer>> array  = new ArrayList<ArrayList<Integer>>(); //массив значений
		ArrayList<Integer> line = new ArrayList<Integer>(); //строка для вставки
		
		// заполняем и выводим массив и строку
		for (int i = 0; i<n ; i++ ) {  		
			array.add(new ArrayList<Integer>());
			for (int j = 0; j<n; j++ ) {
				array.get(i).add(j,(10*(i+1)+j+1));
			}
			System.out.println(array.get(i));
			line.add(i,(int)(10+Math.random()*90));
		}
		System.out.println("\nПроизвольные числа\n"+line);
			
		// считываем с консоли число и вставляем строку в таблицу 
		while (!isCorrect) {
			try {
				System.out.println("\nВведите номер строки, куда вставить числа (нумерация с нуля до "+n+")");
				scan = new Scanner(System.in);
				myInt = scan.nextInt();
				array.add(myInt, line); //вставляем строку
			}
			catch (Exception err) {
				System.out.println("\n!!Ошибка!! Введите корректное значение");
				scan = new Scanner(System.in);
				continue;
			}
			isCorrect = true;
		}
		
		//вывод результатов
		System.out.println("\nВставка строки");
		for (int i = 0; i<array.size(); i++)
		System.out.println(array.get(i));
		
		System.out.println("\nВставка столбца");
		array.remove(myInt);
		for (int i = 0; i<array.size() ; i++ ) {
			array.get(i).add(myInt,line.get(i)); //вставляем столбец
			System.out.println(array.get(i));
		}
	}
}
