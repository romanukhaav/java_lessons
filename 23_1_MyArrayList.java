package lesson23;

/*Создайте класс динамического массива, в котором реализована проверка выхода за границы массива.
 * Перегрузите операторы: 
 * add(int, Integer) - добавление элемента в конкретное место массива 
 * add(Integer) - добавление элемента в конец массива
 * remove() - удаление элемента из конца массива
 * remove(int, Integer) - удаление элемента из конкретного места массива.
 */

public class MyArrayList extends java.util.ArrayList <Integer> {

	private static final long serialVersionUID = 1L;
	
	public MyArrayList() {
		super();
	}

	public MyArrayList(int i) throws IllegalArgumentException {
		super(i);
		System.out.println("Запуск конструктора создающего лист длинной в "+i);
		for(int j = 0; j<i; j++) 
			super.add(null);
		System.out.println(this+"  СОЗДАНО!!!");
	}

	@Override
	//переписанный метод add(int a, Integer b) с проверкой выхода за пределы массива
	public void add(int a, Integer b){
		System.out.println("Запуск @Override метода add(int "+a+", int "+b+")");
		try{
			super.add(a, b);
		}
		catch (Exception e) {
			System.out.println("ОШИБКА!!! ВЫХОД ЗА ПРЕДЕЛЫ МАССИВА!!! \nРАСШИРЯЕМ МАССИВ");
			for (int i = a-this.size(); i<a; i++) 
				super.add(null);
			super.add(a, b);
		}
	}
	
	/* перегруженный метод add; метод не изменяет текущий объект,
	но возвращает новый объект с уже добавленным елементом */
	public MyArrayList add(int a){
		System.out.println("Запуск метода add(int "+a+")");
		if (this.contains(null)) this.set(this.indexOf(null),a);
		else {
			System.out.println("Массив переполнен - необходимо расширить массив!");
			MyArrayList list = new MyArrayList(this.size()+1);
			for(int j = 0; j<this.size(); j++)
				list.set(j,this.get(j));
			System.out.println("!!!! "+list);
			list.add(a);
			return list;
		}
		System.out.println(this);
		return this;
	}
	
	public Integer remove(){
		System.out.println("Запуск метода remove()");
		return super.remove(this.size()-1);
	}
	
	@Override
	public Integer remove(int a){
		System.out.println("Запуск метода remove("+a+")");
		try{
			return super.remove(a);
			
		}
		catch (Exception e) {
			System.out.println("ОШИБКА!!! ВЫХОД ЗА ПРЕДЕЛЫ МАССИВА!!! \nУДАЛЯЕМ ПОСЛЕДНИЙ ЭЛЕМЕНТ");
			return super.remove(this.size()-1);
		}
	}

	
	public static void main(String[] arg){
		try {
		MyArrayList list1 = new MyArrayList(1);

		list1=list1.add(1);
		System.out.println("****************");
		list1=list1.add(2);
		System.out.println("****************");
		list1=list1.add(3);;
		System.out.println("****************");
		list1=list1.add(4);
		System.out.println("****************");
		
		list1.add(8,99);
		System.out.println(list1);
		
		list1.remove(20);
		System.out.println(list1);
		
		} catch (IllegalArgumentException e) {
			System.out.println("***********"+e+"***********");
			System.out.println("Ошибка! Введите положительное значение длинны листа!");
			//e.printStackTrace();
		}
	}
}
