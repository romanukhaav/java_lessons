package lesson10;
/* Дан массив случайных чисел в диапазоне от -20 до +20.
 * Необходимо найти позиции крайних отрицательных элементов 
 * (самого левого отрицательного элемента и самого правого отрицательного элемента) 
 * и отсортировать элементы, находящиеся между ними. 
 */

public class ArrayPositionSort {

			
	public static void main(String[] args){   //
			
			// формуємо масив випадкових чисел
			int arrayRandom [] = new int [14];
			for (int i = 0; i<14; i++){
				arrayRandom [i] = (int)(21+Math.random()*(-42));
				System.out.print(arrayRandom [i]+" ");
			}
			
			// Знаходимо крайній лівий відємний елемент (визначаємо позицію Pos1)
			int Pos1 = -1;
			for (int i = 0; i<14; i++){
				if (arrayRandom [i]<0) { 
					Pos1=i;
					break;
				}
			}
			
			// Знаходимо крайній правий відємний елемент (визначаємо позицію Pos2)
			int Pos2 = -1;
			for (int i = 13; i>0; i--){
				if (arrayRandom [i]<0) {
					Pos2=i;
					break;
				}
			}
			System.out.println("\nПозиції від'ємних елементів "+Pos1+" "+Pos2);
			
					
			// Сортуємо елементи масиву між Pos1 та Pos2: сортування за зростанням
			int compareElement;
			for (int j=Pos1+1; j<Pos2; j++) {
				compareElement=arrayRandom[j];			
				for (int i=Pos1+1; i<Pos2; i++) {
					if (compareElement<arrayRandom[i] ) {
						compareElement=arrayRandom[i];
						arrayRandom[i]=arrayRandom[j];
						arrayRandom[j]=compareElement;
					}
				}			
			}
			
			//друкуємо сортований масив
			System.out.println("\nВідсортований масив");
			for (int i=0; i<arrayRandom.length; i++)
				System.out.print(arrayRandom[i]+" "); 
			
		}
}
