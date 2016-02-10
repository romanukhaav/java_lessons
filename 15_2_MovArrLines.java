package lesson15;

import java.util.ArrayList;
import java.util.Scanner;

/* Дана матрица порядка MxN (M строк, N столбцов). Необходимо заполнить ее значениями
 * и написать функцию, осуществляющую циклический сдвиг строк и/или столбцов массива 
 * указанное количество раз и в указанную сторону.
 */

public class MovArrLines {
	
	static byte numOfMov, posOfMov, isLineOr;
	
	public static void mover(ArrayList<ArrayList<Integer>> array, int numOfMov, byte posOfMov, byte isLineOr){
		
		if (isLineOr==0){
			// вставляем пустые строки - сдвиг вниз
			
			
			// удаляем строки - перемещение вверх
		}
		else {
			// вставляем пустые слолбцы - сдвиг вправо
			
			
			// удаляем столбци - сдвиг влево
		}
		
		
	}
	public static void main(String[] arg){
		
		int n = 8; //размерность матрицы
		int m = 6;
		
		System.out.println("размерность матрицы = "+n+"*"+m+"\n");
		
		boolean isCorrect = false;
		Scanner scan;
		ArrayList<ArrayList<Integer>> array  = new ArrayList<ArrayList<Integer>>(); //массив значений
		ArrayList<Integer> line = new ArrayList<Integer>(); //строка для вставки
		
		// заполняем и выводим массив и нулевую строку
				for (int i = 0; i<n ; i++ ) {  		
					array.add(new ArrayList<Integer>());
					for (int j = 0; j<n; j++ ) {
						array.get(i).add(j,(10*(i+1)+j+1));
					}
					System.out.println(array.get(i));
					line.add(i,(int)(10+Math.random()*90));
				}

		
		// считываем с консоли позицию, смещение и значение строка\столбец
				while (!isCorrect) {
					try {
						System.out.println("\nВведите значение строка = 0, или столбец = 1 ");
						scan = new Scanner(System.in);
						isLineOr = scan.nextByte();
						System.out.println("\nВведите позицию смещения от 0 до m");
						posOfMov = scan.nextByte();
						System.out.println("\nВведите значение смещения от -m\\2 до +m\\2");
						numOfMov = scan.nextByte();
						mover(array, numOfMov, posOfMov, isLineOr); //вставляем строку или столбец
					}
					catch (Exception err) {
						System.out.println("\n!!Ошибка!! Введите корректное значение");
						scan = new Scanner(System.in);
						continue;
					}
					isCorrect = true;
				}
		
	}
}
