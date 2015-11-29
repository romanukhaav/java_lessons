package lesson9;
/*Написать функцию, которая принимает в качестве параметров вещественное число 
 *и количество знаков после десятичной точки, которые должны остаться.
 *Задачей функции является округление вышеуказанного вещественного числа с заданной точностью.*/

public class Rounding {
	
	static Double rounding(Double num, int roundNum){
		
		num = num*Math.pow(10,roundNum);
		int nx = (int) Math. round (num);
		num = nx/Math.pow(10,roundNum);
		return num;
				
	}
	
	public static void main(String[] arg) {
		System.out.println("\n__________________________\nРезультат округления: "+ rounding(ReadConsole.readDouble(), ReadConsole.readInt()));
	}
}
