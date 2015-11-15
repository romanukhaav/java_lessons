package Lesson7;

/*Дана квадратная матрица порядка n (n строк, n столбцов).
 * Найти наибольшее из значений элементов, расположенных в тёмно-синих частях матриц.
 * Все массивы заполняются случайным образом.
*/

public class ArrayMaxElement {public static void main (String[] arg) {
	int n = 9; //размерность матрицы
	
	int [][] Array = new int[n][n]; //масив значений
	char [][] Array1 = new char[n][n]; //масив для отображения сегментов
	int MaxElements = 0;
	
	for (int i = 0; i<n ; i++ ) {
		for (int j = 0; j<n; j++ ) {
			Array[i][j] = (int)(Math.random()*100);
			if (Array[i][j]<=9) 
				System.out.print("0"+Array[i][j] + " ");
			else
				System.out.print(Array[i][j] + " ");
			if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
		}
		System.out.println();
	}
	System.out.println("Наибольший елемент = " + MaxElements );
	
	
	//заповнюю і роздруковую масив варіант a)
	System.out.println();
	System.out.println("Вариант a)");
	MaxElements=0;
	for (int i = 0; i<n; i++ ) {
		for (int j = 0; j<n; j++ ) {
			if (i<j) {   //умова відбору елементів
				Array1[i][j]='*';
				if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
			}
			else Array1[i][j]='.';
			System.out.print(Array1[i][j] + "  ");
		}
		System.out.println();
	}
	System.out.println("Наибольший в сегменте = " + MaxElements );
	
	//заповнюю і роздруковую масив варіант б)
	System.out.println();
	System.out.println("Вариант б)");
	MaxElements=0;
	for (int i = 0; i<n ; i++ ) {
		for (int j = 0; j<n; j++ ) {
			if (i>=j) {			//умова відбору елементів
				Array1[i][j]='*';
				if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
			}
			else Array1[i][j]='.';
			System.out.print(Array1[i][j] + "  ");
		}
		System.out.println();
	}
	System.out.println("Наибольший в сегменте = " + MaxElements );
	
	//заповнюю і роздруковую масив варіант в)
	System.out.println();
	System.out.println("Вариант в)");
	MaxElements=0;
	for (int i = 0; i<n ; i++ ) {
		for (int j = 0; j<n; j++ ) {
			if (i<-j+n && i<=j) {  //умова відбору елементів
				Array1[i][j]='*';
				if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
			}
			else Array1[i][j]='.';
			System.out.print(Array1[i][j] + "  ");
		}
		System.out.println();
	}
	System.out.println("Наибольший в сегменте = " + MaxElements );
	
	//заповнюю і роздруковую масив варіант г)
		System.out.println();
		System.out.println("Вариант г)");
		MaxElements=0;
		for (int i = 0; i<n ; i++ ) {
			for (int j = 0; j<n; j++ ) {
				if (i>=-j+n-1 && i>j-1) { //умова відбору елементів
					Array1[i][j]='*';
					if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
				}
				else Array1[i][j]='.';
				System.out.print(Array1[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("Наибольший в сегменте = " + MaxElements );
		
		
		//заповнюю і роздруковую масив варіант д)
		System.out.println();
		System.out.println("Вариант д)");
		MaxElements=0;
		for (int i = 0; i<n; i++ ) {
			for (int j = 0; j<n; j++ ) {
				if (i>=-j+n-1 && i>j-1 || i<-j+n && i<=j) { //відбір сегменту
					Array1[i][j]='*';
					if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
				}
				else Array1[i][j]='.';
				System.out.print(Array1[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("Наибольший в сегменте = " + MaxElements );

		
		//заповнюю і роздруковую масив варіант е)
		System.out.println();
		System.out.println("Вариант е)");
		MaxElements=0;
		for (int i = 0; i<n; i++ ) {
			for (int j = 0; j<n; j++ ) {
				if (i<-j+n-1 && i>j || i>=-j+n && i<j) {  //відбір сегменту
					Array1[i][j]='*';
					if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
				}
				else Array1[i][j]='.';
				System.out.print(Array1[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("Наибольший в сегменте = " + MaxElements );
		
		//заповнюю і роздруковую масив варіант ж)
		System.out.println();
		System.out.println("Вариант ж)");
		MaxElements=0;
		for (int i = 0; i<n ; i++ ) {
			for (int j = 0; j<n; j++ ) {
				if (i<-j+n-1 && i>j) {   //умова відбору елементів
					Array1[i][j]='*';
					if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
				}
				else Array1[i][j]='.';
				System.out.print(Array1[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("Наибольший в сегменте = " + MaxElements );
		
		//заповнюю і роздруковую масив варіант з)
		System.out.println();
		System.out.println("Вариант з)");
		MaxElements=0;
		for (int i = 0; i<n; i++ ) {
			for (int j = 0; j<n; j++ ) {
				if (i>=-j+n && i<j) {   //умова відбору елементів
					Array1[i][j]='*';
					if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
				}
				else Array1[i][j]='.';
				System.out.print(Array1[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("Наибольший в сегменте = " + MaxElements );
		
	
	//заповнюю і роздруковую масив варіант и)
	System.out.println();
	System.out.println("Вариант и)");
	MaxElements=0;
	for (int i = 0; i<n; i++ ) {
		for (int j = 0; j<n; j++ ) {
			if (i>=-j+n-1) {  //умова відбору елементів
				Array1[i][j]='*';
				if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
			}
			else Array1[i][j]='.';
			System.out.print(Array1[i][j] + "  ");
		}
		System.out.println();
	}
	System.out.println("Наибольший в сегменте = " + MaxElements );
	
	//заповнюю і роздруковую масив варіант к)
		System.out.println();
		System.out.println("Вариант к)");
		MaxElements=0;
		for (int i = 0; i<n; i++ ) {
			for (int j = 0; j<n; j++ ) {
				if (i<-j+n) {        //умова відбору елементів
					Array1[i][j]='*';
					if (Array[i][j]>MaxElements) MaxElements=Array[i][j];
				}
				else Array1[i][j]='.';
				System.out.print(Array1[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("Наибольший в сегменте = " + MaxElements );
}
}
