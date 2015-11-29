package lesson9;

import java.util.Scanner;

public class ReadConsole {
	
	
	public static int readInt(){
		int num = 0;
		boolean isInput = false;
		
		while (isInput!=true){
			try{
				System.out.println("\nВведите натуральное число: ");
				@SuppressWarnings("resource")
				Scanner	readNumber = new Scanner(System.in);
				if (readNumber.hasNextInt()) {
					num = readNumber.nextInt();
					System.out.println("Вы ввели число = "+ num);
					isInput=true;
				}
				else System.out.println("Ошибка! Введите натуральное число!");
				
			}
			catch(Exception e){
		        System.out.println("Введите число!");
		    }
		}
		return num;
	}
	
	public static Double readDouble(){
		Double num = 0.0;
		boolean isInput = false;
		
		while (isInput!=true){
			try{
				System.out.println("Введите действительное число (дробная часть через запятую): ");
				@SuppressWarnings("resource")
				Scanner	readNumber = new Scanner(System.in);
				if (readNumber.hasNextDouble()) {
					num = readNumber.nextDouble();
					System.out.println("Вы ввели число = "+ num);
					isInput=true;
				}
				else System.out.println("Ошибка! Введите действительное число!");
				
			}
			catch(Exception e){
		        System.out.println("Введите число!");
		    }
		}
		return num;
	}
	
	public static void main (String [] args) {
		readInt();
	}
}
