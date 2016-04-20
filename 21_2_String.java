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
	public ArrayList <Character> arrStr = new ArrayList <Character>();
	
	//конструктор по умолчанию, позволяющий создать строку длиной 80 символов;
	public String(){
		for(int i = 0; i<=8;i++)
			this.arrStr.add('X');
	}
	
	//конструктор, позволяющий создавать строку произвольного размера;
	public String(int j){
		for(int i = 0; i<=j;i++)
			this.arrStr.add('Y');
	}
	
	// конструктор, который создаёт строку и инициализирует её строкой, полученной от пользователя.
	public String(ArrayList <Character> str){
			this.arrStr = String.write().arrStr;
		}
		
		
		// ввод строки с клавиатуры
		public static String write() {
			System.out.println("Введите строку: ");
			String st = new String(0);
			st.arrStr = new ArrayList <Character>(); //обнуляем массив символов
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
				for(int r ;  (r = reader.read()) != -1;){
				
				//int r;
				//while ((r = reader.read()) != -1) {
					st.arrStr.add((char)reader.read());
				}
				reader.close(); // close the stream
				return st;
		        
			} catch (Exception e) {
				e.printStackTrace();
				return st;
			}	
		}
			
	
		
		// вывод строки
		public void show() {
			System.out.println("Введённая строка: " + this.arrStr);
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
		String st3 = write();
		st3.show();
		
    }
}
