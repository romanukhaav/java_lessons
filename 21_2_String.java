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

public class String {
	public char symbol;
	public ArrayList <Character> str = new ArrayList <Character>();
	
	public String(){
		for(int i = 0; i<=80;i++)
			this.str.add('X');
	}
	
	public String(int j){
		for(int i = 0; i<=j;i++)
			this.str.add('Y');
	}
	
	// конструктор со строкой, введённой с клавиатуры
		String(ArrayList <Character> str){
			this.str = str;
		}
		
		
		// ввод строки с клавиатуры
		public static ArrayList <Character> write() {
			System.out.println("Ну давай уже, вводи свою строку: ");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
				ArrayList <Character> arrChar = new ArrayList <Character>();
				arrChar.add((char)reader.read());
				return arrChar;
			} catch (Exception e) {
				e.printStackTrace();
				ArrayList <Character> falseArrChar = new ArrayList <Character>();
				return falseArrChar;
			}
		}
	
		
		// вывод строки
		public void show() {
			System.out.println("Введённая строка: " + this.str);
		}

	
		public static void main(java.lang.String[] args)
    {
       /* BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        java.lang.String strNumber = bufReader.readLine();        
        int number = Integer.parseInt(strNumber);
        
      
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(bReader.readLine());
            */
		String st1 = new String();
		String st2 = new String(20);
		st1.show();
		st2.show();
    }
}
