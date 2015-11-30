package lesson10;

/* Дан массив из 20 целых чисел со значениями от 1 до 20.
 * Необходимо:
 * написать функцию, разбрасывающую элементы массива произвольным образом;
 * создать случайное число из того же диапазона и найти позицию этого случайного числа в массиве;
 * отсортировать элементы массива, находящиеся слева от найденной позиции по убыванию,
 * а элементы массива, находящиеся справа от найденной позиции по возрастанию.*/

public class ArrayTo20 {
	
	// метод довільного розкидання елементів масиву 
	public static void arrayDesortFunc( int[] arr) {

			System.out.println("Початковий масив");
			for(int i=0; i<arr.length; i++){
				System.out.print(arr[i]+" ");
			}
			
			//розкидаємо масив
			int deSortElement;				
			for (int i=0; i<arr.length; i++) {
				int j = (int)(1+Math.random()*(arr.length-1));
				deSortElement=arr[i];
				arr[i]=arr[j];
				arr[j]=deSortElement;
			}

			System.out.println("\n\nЗмішаний масив");
			for (int i=0; i<arr.length; i++)
				System.out.print(arr[i]+" "); //друкуємо масив			
		}
		
		
	
	public static void main(String[] args){
		int masiv1 [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,};
		
		arrayDesortFunc(masiv1); //перемішуємо масив
		
		int randomedElement = (int)(1+Math.random()*(masiv1.length)); //генеруємо довільний елемент
		System.out.println("\n\nДовільний елемент = "+randomedElement);
		
		//визначаємо позицію елемента в масиві
		int position = 0;
		for(int i=0; i<masiv1.length; i++){
			if (randomedElement==masiv1[i]){
				position = i;
				System.out.print("Позиція елемента = "+position);
				break;
			}
		}
		
		//сортування за спаданням до позиції
		for(int j=0; j<position; j++){
			int compareElement=masiv1[j];
			for (int i=0; i<position; i++) { 
				if (compareElement>masiv1[i] ) {
					compareElement=masiv1[i];
					masiv1[i]=masiv1[j];
					masiv1[j]=compareElement;
				}
			}
		}
		
		//сортування за зростанням після позиції
		for(int j=position+1; j<masiv1.length; j++){
			int compareElement=masiv1[j];
			for (int i=position+1; i<masiv1.length; i++) {
				if (compareElement<masiv1[i] ) {
					compareElement=masiv1[i];
					masiv1[i]=masiv1[j];
					masiv1[j]=compareElement;
				}
			}
		}
	
		System.out.println("\n\nКінцевий масив");
		for(int i=0; i<masiv1.length; i++){
			System.out.print(masiv1[i]+" ");
		}
	}
	
}
