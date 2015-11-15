package lesson6;

//Написать программу, которая находит сумму четных 
//и сумму нечетных элементов массива.

public class ArraySum {
	public static void main(String[] args){
		int masiv [] = {4,5,1,5,9,8};
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<masiv.length; i++){

				if (masiv[i]%2!=0){
					sum1=sum1+masiv[i];
				}
				else{
					sum2=sum2+masiv[i];
				}	
		}
		System.out.println("Сумма нечетных = " + sum1);
		System.out.println("Сумма четных = " + sum2);
	}
}
