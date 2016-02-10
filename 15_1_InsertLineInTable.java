package lesson15;

import java.util.ArrayList;
import java.util.Scanner;

/* Дана матрица порядка MxN (M строк, N столбцов). Необходимо заполнить ее значениями
 * и написать функцию, осуществляющую циклический сдвиг строк и/или столбцов массива 
 * указанное количество раз и в указанную сторону.
 */

public class MovArrLines {
	
public static void main(String[] arg){

		int n = 8; //строки матрицы
		int m = 6; //столобцы матрицы
		System.out.println("размерность матрицы = "+n+"*"+m+"\n");
		
		boolean isCorrect = false;
		Scanner scan;
		ArrayList<ArrayList<Integer>> array  = new ArrayList<ArrayList<Integer>>(); //массив значений

		// заполняем и выводим массив
		for (int i = 0; i<n ; i++ ) {  		
			array.add(new ArrayList<Integer>());
			for (int j = 0; j<m; j++ ) {
				array.get(i).add(j,(10*(i+1)+j+1));
			}
			System.out.println(array.get(i));
			line.add(i,0); //заполняем нулями строку для вставки
		}

		// считываем с консоли позицию, смещение и значение строка\столбец
		while (!isCorrect) {
			try {
				System.out.println("\nВведите значение строка = 0, или столбец = 1 ");
				scan = new Scanner(System.in);
				isLineOr = scan.nextByte();
				if (isLineOr<0 || isLineOr>1) 
					throw new NullPointerException("Неверное значение строка\\столбец");
				
				if (isLineOr==0) System.out.println("\nВведите позицию смещения от 0 до " + (n-1));
				else System.out.println("\nВведите позицию смещения от 0 до "+ (m-1));
				posOfMov = scan.nextByte();
				if (isLineOr==0 && posOfMov>n || isLineOr==1 && posOfMov>m || posOfMov<0) 
					throw new NullPointerException("Позиция смещения за пределами матрицы");
				
				System.out.println("\nВведите значение смещения");
				numOfMov = scan.nextByte();
			}
			catch (Exception err) {
				System.out.println("\n!!Ошибка!!"+err+"\nВведите исходные данные повторно!");
				scan = new Scanner(System.in);
				continue;
			}
			isCorrect = true;
		}
				
		mover(array, numOfMov, posOfMov, isLineOr); //производим сдвиг
				
		// выводим результат
		for (int i = 0; i<array.size() ; i++ ) {  		
			System.out.println(array.get(i));
		}
	}

//----------------------------------------------------------------------//	
	static byte numOfMov, posOfMov, isLineOr;
	static ArrayList<Integer> line = new ArrayList<Integer>(); //строка для вставки
	
	//рекурсивный метод сдвига
	public static ArrayList<ArrayList<Integer>>  mover(ArrayList<ArrayList<Integer>> array, int numOfMov, byte posOfMov, byte isLineOr){
		if(numOfMov==0) return array;
	
		//работа со строками
		if (isLineOr==0){ 
			if (numOfMov>0) {	// вставляем пустые строки - сдвиг вниз
				array.add(posOfMov, line);
				numOfMov--;
			}
			else {		// удаляем строки - перемещение вверх
				array.remove(posOfMov);
				posOfMov--;
				if (posOfMov<0) return array; //проверка от чрезмерного удаления
				numOfMov++;
			}
		}
		//работа со столбцами		
		else { 
			// вставляем пустые слолбцы - сдвиг вправо	
			if(numOfMov>0){ 
				for (int i = 0; i<array.size() ; i++ ) {
					array.get(i).add(posOfMov,0); //вставляем столбец
				}
				numOfMov--;
			}
			// удаляем столбци - сдвиг влево	
			else{	
				for (int i = 0; i<array.size() ; i++ ) {
					array.get(i).remove(posOfMov); //вставляем столбец
				}
				posOfMov--;
				if (posOfMov<0) return array; //проверка от чрезмерного удаления
				numOfMov++;
			}
		}
	mover(array, numOfMov, posOfMov, isLineOr); //рекурсивный вызов метода
	return array;		
	}
}
