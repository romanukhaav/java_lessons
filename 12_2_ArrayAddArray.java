package lesson12;

import java.util.ArrayList;
import java.util.Collections;

/* Даны два массива, упорядоченных по возрастанию: А[n] и B[m].
 * Сформируйте массив C[n+m], состоящий из элементов массивов А и В,
 * упорядоченный по возрастанию
 */

public class ArrayAddArray {
	

public static void main (String [] arg){
		
		ArrayList <Integer> arr1  = new ArrayList<Integer>();

		
		ArrayList <Integer> arr2  = new ArrayList<Integer>();
		for (int i=0; i <10; i++) 	{
			arr1.add((int)(1+Math.random()*(20)));
			arr2.add((int)(1+Math.random()*(20)));			
		}
		
		System.out.println(arr1);
		System.out.println(arr2);
		
		arr1.addAll(arr2);
		System.out.println(arr1);
		
		Collections.sort(arr1);
		System.out.println(arr1);

	}
}
