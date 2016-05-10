package lesson22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
/*Добавить в строковый класс функцию, которая создает строку,
 * содержащую пересечение двух строк, то есть общие символы для двух строк.
 * Например, результатом пересечения строк "sdqcg" "rgfas34" будет строка "sg".
 * Для реализации функции перегрузить оператор * (бинарное умножение). 
*/
public class String {
	public char symbol;
	public ArrayList <Character> arrStr = new ArrayList <Character>();
	
	//конструктор по умолчанию, позволяющий создать строку длиной 80 символов;
	public String(){
		for(int i = 0; i<=20;i++)
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
		System.out.println("\n\nВведите строку: ");
		String st = new String(0);
		st.arrStr = new ArrayList <Character>(); //обнуляем массив символов
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			for(char symbol; (symbol = (char)reader.read()) != '\n';){
				st.arrStr.add(symbol); //наполняем массив обьекта символами строки
			}
			reader.close(); // close the stream
			st.arrStr.remove(st.arrStr.size()-1); //удаляем последний символ перевода каретки
			return st;
		       
		} catch (Exception e) {
			e.printStackTrace();
			return st;
		}	
	}
					
	// вывод строки
	public void show() {
		//System.out.println("\nВывод строки: ");
		for(char symbol:this.arrStr) System.out.print(symbol);
	}

	// пересечение двух строк
		public static String joint(String str1, String str2) {
			System.out.println("\nПересечение строк: ");
			String str3 = new String(0);
			str3.arrStr = new ArrayList <Character>();//обнуляем массив символов
			for(char symbol:str1.arrStr){
				if (str2.arrStr.contains(symbol) && !str3.arrStr.contains(symbol)) {
					str3.arrStr.add(symbol);
					continue;
				}
			}
			return str3;
		}
		
		/*
		// пересечение двух строк
		public static String joint(String str1, String str2) {
			System.out.println("\nПересечение строк: ");
			String str3 = new String(0);
			str3.arrStr = new ArrayList <Character>();//обнуляем массив символов
			for(int i = 0; i<str1.arrStr.size(); i++){
				if (str2.arrStr.contains(str1.arrStr.get(i))) {
					str3.arrStr.add(str1.arrStr.get(i));
					
					continue;
				}
			}
			return str3;
		}
		*/
	
	public static void main(java.lang.String[] args)  {
	       				

		String st1 = new String();
		st1.show();			
		String st2 = write();
		st2.show();
		
		//фігня :( ??
		//String st3 = write();
		//st3.show();
		
		joint(st1,st2).show();
	}
}
