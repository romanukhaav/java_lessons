package Lesson7;

/*Дан двухмерный массив размерностью 3X4. 
 * Необходимо найти колличество элементов значение которых равно нулю. 
 */

public class ArrayZeroElements {	
	
	public static void main (String[] arg) {
		int [][] Array = new int[3][4];
		int ZeroElements = 0;
		for (int i = 0; i<3; i++ ) {
			for (int j = 0; j<4; j++ ) {
				Array[i][j] = (int)(Math.random()*3);
				System.out.print(Array[i][j] + " ");
				if (Array[i][j]==0) ZeroElements++;
			}
			System.out.println();
		}
		System.out.println("Колличество нулевых елементов = " + ZeroElements );
	}
}
