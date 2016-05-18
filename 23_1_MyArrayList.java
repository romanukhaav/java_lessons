package lesson23;

import java.io.IOException;


/*Создайте класс динамического массива, в котором реализована проверка выхода за границы массива.
 * Перегрузите операторы: 
 * add(int, Integer) - добавление элемента в конкретное место массива 
 * add(Integer) - добавление элемента в конец массива
 * del(Integer) - удаление элемента из конца массива
 * del(int, Integer) - удаление элемента из конкретного места массива.
 */

public class MyArrayList extends java.util.ArrayList <Integer> {

	private static final long serialVersionUID = 1L;
	
	public MyArrayList() {
		super();
	}

	public MyArrayList(int i) throws IllegalArgumentException {
		super(i);
		System.out.println("Запуск конструктора создающего лист длинной в "+i);
		for(int j = 0; j<i; j++) super.add(null);
		System.out.println(this+"\n");
	}

	public MyArrayList add(int a, int b){
		System.out.println("Запуск переписанного метода add(int "+a+", int "+b+")");
		System.out.println("*********");
		return this;
	}
	
	public MyArrayList add(int a){
		System.out.println("Запуск переписанного метода add(int "+a+")");
		System.out.println("Длинна листа до - "+this.size());
		if (this.contains(null)) this.set(this.indexOf(null),a);
		else {
			System.out.println("Массив переполнен - необходимо расширить массив!");
			return this;
		}
		System.out.println(this);
		System.out.println("Длинна листа после - "+this.size());
		return this;
	}
	
	public void del(){
		System.out.println("Хa");
	}
	public void del(int a){
		System.out.println("Хa-xa");
	}

	
	public static void main(String[] arg){
		try {
		MyArrayList list1 = new MyArrayList(2);
		list1.add(55);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("***********"+e+"***********");
			System.out.println("Ошибка! Введите положительное значение длинны листа!");
			//e.printStackTrace();
		}
		
		
		//list1.add(0,8);
		//System.out.println(list1);
	}
}
