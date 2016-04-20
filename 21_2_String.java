package lesson21;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*Разработать класс String, который в дальнейшем будет использоваться для работы со строками.
 * Класс должен содержать:
 * конструктор по умолчанию, позволяющий создать строку длиной 80 символов;
 * конструктор, позволяющий создавать строку произвольного размера;
 * конструктор, который создаёт строку и инициализирует её строкой, полученной от пользователя.
 * Класс должен содержать методы для ввода строк с клавиатуры и вывода строк на экран.
 */

public class Str1 {
	public char symbol;
	public ArrayList <Character> str = new ArrayList <Character>();
	
	public Str1(){
		for(int i = 0; i<=80;i++)
			this.str.add('X');
	}
	
	public Str1(int j){
		for(int i = 0; i<=j;i++)
			this.str.add('Y');
	}
	
	// конструктор со строкой, введённой с клавиатуры
		Str1(ArrayList <Character> str){
			this.str = str;
		}
		
		/*
		// ввод строки с клавиатуры
		public static ArrayList <Character> write() {
			System.out.println("Ну давай уже, вводи свою строку: ");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
				ArrayList <Character> arrChar = new ArrayList <Character>();
				arrChar.add(reader.read());
				return arrChar;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/
		
		// вывод строки
		public void show() {
			System.out.println("Введённая строка: " + this.str);
		}

	
		public static void main(String[] args)
    {
       /* BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        java.lang.String strNumber = bufReader.readLine();        
        int number = Integer.parseInt(strNumber);
        
      
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(bReader.readLine());
            */
		Str1 st1 = new Str1();
		Str1 st2 = new Str1(20);
		st1.show();
		st2.show();
    }
}
