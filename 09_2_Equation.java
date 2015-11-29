package lesson9;

/* Написать перегруженные шаблоны функций для нахождения корней
 * линейного (a*x + b = 0) и квадратного (a*x2+b*x + c = 0) уравнений.
 * Замечание: в функции передаются коэффициенты уравнений. 
 */

public class Equation {
	
	private static int equation(int a, int b){
		int x = -b/a;
		return x;
	}
	
	private static void equation(int a, int b, int c){
		int x1 = (- b+(int)Math.sqrt(b*b-4*a*c))/(2*a);
		int x2 = (- b-(int)Math.sqrt(b*b-4*a*c))/(2*a);
		System.out.println("x1 = "+ x1);
		System.out.println("x2 = "+ x2);
	}

	public static void main (String [] args) {
		System.out.println("Решаем линейные и квадратные уравнения \n");
		System.out.println("Результат работы функции equation(2,8) \n x = "+equation(2,8)+"\n");
		System.out.println("Результат работы функции equation(1,1,-6)");
		equation(1,1,-6);
		ReadConsole.readInt();
	}	
}
