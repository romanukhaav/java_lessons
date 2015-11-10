package Lesson8;

/*Написать функцию, которая получает в качестве аргументов целое положительное число
 * и систему счисления, в которую это число должно переводится (системы счисления от 2 до 36).
 * Например, при переводе числа 27 в систему счисления 16 должно получиться 1B; 13 в 5-ю - 23;
 * 35 в 18-ю - 1H. 
 */

import java.util.Scanner;

public class Radix {

	private static Scanner readNumber;
	
	//метод преобразования числа с десятеричной в указываемую систему счисления
	private void transfer (int n, int radix) {
		int i=0;
		int Arr [] = new int [n]; 
		for (; n>0; n=n/radix){
			Arr[i]=n%radix;
			i++;
		}
		i--;
		for (; i>=0; i--) {
			if (Arr[i]<=10) System.out.print(Arr[i]);
			else {
				switch (Arr[i]) {
				 	case 10: System.out.print("A"); break;
				 	case 11: System.out.print("B"); break;
				 	case 12: System.out.print("C"); break;
				 	case 13: System.out.print("D"); break;
				 	case 14: System.out.print("E"); break;
				 	case 15: System.out.print("F"); break;
				 	case 16: System.out.print("G"); break;
				 	case 17: System.out.print("H"); break;
				 	case 18: System.out.print("I"); break;
				 	case 19: System.out.print("J"); break;
				 	case 20: System.out.print("K"); break;
				 	case 21: System.out.print("L"); break;
				 	case 22: System.out.print("M"); break;
				 	case 23: System.out.print("M"); break;
				 	case 24: System.out.print("O"); break;
				 	case 25: System.out.print("P"); break;
				 	case 26: System.out.print("Q"); break;
				 	case 27: System.out.print("R"); break;
				 	case 28: System.out.print("S"); break;
				 	case 29: System.out.print("T"); break;
				 	case 30: System.out.print("U"); break;
				 	case 31: System.out.print("V"); break;
				 	case 32: System.out.print("W"); break;
				 	case 33: System.out.print("X"); break;
				 	case 34: System.out.print("Y"); break;
				 	case 35: System.out.print("Z"); break;
				}
			}
		}
	}	
	
	
	public static void main (String [] arg){
		int num = 0;
		int rad = 0;
		
		readNumber = new Scanner(System.in);
		
		while (num==0){
			System.out.println("Введите число: ");
			if (readNumber.hasNextInt()) num = readNumber.nextInt();
			else System.out.println("Введите натуральное число");
		}
		
		while (rad==0){
			System.out.println("Введите систему счисления (от 2 до 36): ");
			if (readNumber.hasNextInt()) rad = readNumber.nextInt();
			else System.out.println("Введите натуральное число");
		}
		
		Radix transRad = new Radix();
		transRad.transfer(num, rad);
		
	}	
}	
