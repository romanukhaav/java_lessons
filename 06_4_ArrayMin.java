package lesson6;

//Написать программу, которая находит в массиве самое маленькое нечетное число 
//и показывает его на экран

public class ArrayMin {
	public static void main(String[] args){
		int masiv [] = {0,-4,4,5,1,-5,9,8};
		int min = 0;
		
		//шукаємо, чи є взагалі непарні числа у масиві
		for(int i=0; i<masiv.length; i++){
				if (masiv[i]%2!=0){
					min=masiv[i];
					break;
				}
		}
		
		if(min==0){
			System.out.println("В масиве отсутствуют нечетные числа ");
			System.exit(1);
		}
		
		//шукаємо, найменше непарне число
		for(int i=0; i<masiv.length; i++){
				if (masiv[i]%2!=0 && masiv[i]<min){
					min=masiv[i];
				}
		}
		System.out.println("Самое маленькое нечетное число = " + min);	
	}
}
