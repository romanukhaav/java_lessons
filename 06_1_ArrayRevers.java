package lesson6;

//Написать программу, которая выводит содержимое массива наоборот.
//Пример: массив 23 11 6 превращается в 6 23 11.


public class ArrayRevers {
	public static void main(String[] args){
		int masiv [] = {1,4,5,9,77};
		
		for(int i=masiv.length-1; i>=0; i--){
			System.out.print(masiv[i]+" ");
		}
	}
}
