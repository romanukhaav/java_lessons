package lesson12;

import java.util.ArrayList;

/*Дан массив целых чисел. Поменяйте местами элементы массива с четными и нечетными индексами 
 * (т.е. те элементы массива, которые стоят на четных местах, поменяйте с элементами, которые 
 * стоят на нечетных местах).
 */

public class ArraysChangeElements {
	
	public static void main (String [] arg){
		
		ArrayList <Integer> arr  = new ArrayList<Integer>();
		for (int i=0; i <20; i++) 	arr.add(i);
		System.out.println(arr);
		if (arr.size()%2!=0){
			System.out.println("Для коректной перестановки колличество элементов масива должно быть парным!!!");
			System.exit(0);
		}
		int elem;
		for (int i=0; i <arr.size(); i++) {
			if (i%2==0) {
				elem = arr.get(i);
				arr.set(i,arr.get(i+1));
				arr.set(i+1,elem);
			}
		}
		System.out.println(arr);
	}
}
