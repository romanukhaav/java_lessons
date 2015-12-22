package lesson12;

/* Даны два массива : А[n] и B[m]. Необходимо создать третий массив, в котором нужно собрать: 
 * Элементы обоих массивов; 
 * Общие элементы двух массивов; 
 * Элементы массива A, которые не включаются в B; 
 * Элементы массива B, которые не включаются в A; 
 * Элементы массивов A и B, коотрые не являются общими дял них 
 * (то есть объединение результатов двух предыдущих вариантов). 
 */

import java.util.ArrayList;

public class ArrayProcessing {

	public static void main (String [] arg){
		
		ArrayList <Integer> arr1  = new ArrayList<Integer>();
		ArrayList <Integer> arr2  = new ArrayList<Integer>();
		ArrayList <Integer> arr3  = new ArrayList<Integer>();
		for (int i=0; i <10; i++) 	{
			arr1.add((int)(1+Math.random()*(20)));
			arr2.add((int)(1+Math.random()*(20)));			
		}
		
		System.out.println(arr1);
		System.out.println(arr2);
		
		arr3.addAll(arr1);
		arr3.addAll(arr2);
		System.out.println("\nЭлементы обоих массивов "+arr3);
		
		arr3.clear();
		for (int i=0; i<arr1.size(); i++) {
			if (arr1.contains(arr2.get(i))&&(! arr3.contains((arr2.get(i))))) arr3.add(arr2.get(i));
		}
		System.out.println("\nОбщие элементы двух массивов "+arr3);
		
		arr3.clear();
		for (int i=0; i<arr1.size(); i++) {
			if (!arr2.contains(arr1.get(i))) arr3.add(arr1.get(i));
		}
		System.out.println("\nЭлементы массива A, которые не включаются в B "+arr3);
		
		arr3.clear();
		for (int i=0; i<arr1.size(); i++) {
			if (!arr1.contains(arr2.get(i))) arr3.add(arr2.get(i));
		}
		System.out.println("\nЭлементы массива B, которые не включаются в A "+arr3);
		
		for (int i=0; i<arr1.size(); i++) {
			if (!arr2.contains(arr1.get(i))) arr3.add(arr1.get(i));
		}
		System.out.println("\nЭлементы массивов A и B, коотрые не являются общими дял них "+arr3);
	}
}
