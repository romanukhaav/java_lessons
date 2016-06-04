package lesson24;

import java.util.ArrayList;

/*Создать класс для работы с матрицами. Предусмотреть, как минимум, функции для сложения матриц, 
 * умножения матриц, транспонирования матриц, присваивания матриц друг другу, установка и 
 * получение произвольного элемента матрицы. Необходимо перегрузить соответствующие операторы.*/

public class Matrix {
	
	ArrayList<ArrayList<Integer>> array  = new ArrayList<ArrayList<Integer>>(); //массив значений
	public int lines = 4; //строки матрицы - по умолчанию 4
	public int rows = 4; //столобцы матрицы - по умолчанию 4
	
	Matrix(){ //конструктор по умолчанию
		this.array = new Matrix(lines, rows).array;
	}
	
	Matrix(int n, int m){ //конструктор матрицы заданной размерности
		this.lines = n;
		this.rows = m;
		System.out.println(" Создаем матрицу "+this.lines+"*"+this.rows);
		ArrayList<Integer> line = new ArrayList<Integer>(); //строка для вставки
		// заполняем и выводим массив
			for (int i = 0; i<n ; i++ ) {  		
				array.add(new ArrayList<Integer>());
				for (int j = 0; j<m; j++ ) {
					array.get(i).add(j,((i+1)+j+1)); //заполняем цифрами от 10 и выше
				}
				System.out.println(array.get(i));
				line.add(i,0); //заполняем нулями строку для вставки
			}
			System.out.println();
	}
	
	//установка элеманта матрицы
	public void set(int i, int j, Integer elem){
			//System.out.println("Установка элеманта матрицы: ("+i+","+j+") = "+elem);
			try{
				this.array.get(i).set(j, elem);
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("Выход за пределы матрицы! Задайте корректную позицию элемента.");
			}		
	}
		
	//получение элемента матрицы
	public Integer get(int i, int j){
			try{
				return this.array.get(i).get(j);
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("Выход за пределы матрицы! Задайте корректную позицию элемента.");
				return null;
			}
	}
		
	
	//сложение матриц
	public Matrix add(Matrix m){
		System.out.println("Сложение матриц:"+"\n"+this+"++++++++\n"+m);
		if (this.lines!=m.lines||this.rows!=m.rows) {
			System.out.println("Ошибка! Матрицы разной размерности! Сложение невозможно!");
			return null;
		}
		for (int i = 0; i< this.lines; i++){
			for (int j = 0; j < this.rows; j++){
				this.set(i, j, this.get(i, j)+m.get(i, j));
			}
		}
		return this;
	}
	
	//присваивание матриц
	public Matrix asgn(Matrix m){
		System.out.println("Присваивание матриц:"+"\n"+this+"=============\n"+m);
		if (this.lines!=m.lines||this.rows!=m.rows) {
			System.out.println("Ошибка! Матрицы разной размерности! Сложение невозможно!");
			return null;
		}
		for (int i = 0; i< this.lines; i++){
			for (int j = 0; j < this.rows; j++){
				this.set(i, j, m.get(i, j));
			}
		}
		return this;
	}
	
	//транспонирование матриц
	public Matrix transp(){
		System.out.println("Транспонирование матрицы:"+"\n"+this);
		Matrix m = new Matrix(this.rows, this.lines); 
		
		for (int i = 0; i< m.lines; i++){
			for (int j = 0; j < m.rows; j++){
				m.set(i, j, this.get(j,i));
			}
		}
		return m;
	}
	
	//умножение матриц
	public Matrix multipl(Matrix m){
		System.out.println("Умножение матриц:"+"\n"+this+"*******\n"+m);
		
		if (this.rows!=m.lines) {
			System.out.println("Умножение матриц невозможно!: "+this.rows+" != "+m.lines);
			return null;
		}
		
		Matrix m1 = new Matrix(this.rows, m.lines);
		System.out.println("Заполняем елементы");
		int elem=0;
		for (int x=0; x<this.rows; x++)
			for (int y=0; y<m.lines; y++){
				
				for (int i = 0; i<m.rows; i++){
					for (int j = 0; j<this.lines; j++){
						elem += this.get(j, x)*m.get(y,i);
					}
				}
				
				m1.set(x, y, elem);
				elem=0;
				
			}				
		
		
		/*for (int i = 0; i<m.rows; i++){
			for (int j = 0; j<this.lines; j++){
				for (int n = 0; n<this.rows; n++){
					elem += this.get(j, n)*m.get(n,i);
				}					
				m1.set(i, j, elem);
				elem=0;
			}
		}*/
		return m1;
	}
	
	@Override
	public String toString(){ //Вывод матрицы
			 String str ="";
			for (ArrayList <Integer> i : this.array){
				for (Integer j : i){
					str+=j.toString()+" ";
				}
				str+="\n";
			}
		return str;
	}
	
	
	public static void main(String [] args) {
		
		Matrix m1 = new Matrix(3,2);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
		
		Matrix m2 = new Matrix(3,2);
		System.out.println(m1.add(m2));
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
		
		System.out.println(m1.asgn(m2));
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
		
		System.out.println("Проверка сеттера - добавляем нули");
		m1.set(0, 0, 0);
		m1.set(0, 1, 0);
		m1.set(1, 1, 0);
		m1.set(2, 0, 0);
		System.out.println(m1);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
		
		Matrix m3 = m1.transp();
		System.out.println(m3);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
		
		
		System.out.println("Выводим результат\n"+m1.multipl(m3));
	}
	
}
