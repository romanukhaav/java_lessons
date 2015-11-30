package lesson10;

/*Дан массив чисел размерностью 10 элементов. Написать функцию, которая сортирует массив 
 * по возрастанию или по убыванию, в зависимости от третьего параметра функции.
 * Если он равен 1, сортировка идет по убыванию, если 0, то по возрастанию.
 * Первые 2 параметра функции - это массив и его размер, третий параметр по умолчанию равен 1.
 *
 */


public class ArraySortFunc {
	// метод сортування при трьох вхідних параметрах
	public static <M> void arraySortFunc(M[] arr, int arrayLength, int sortIndex) {
		try{
			//створюємо конвертований масив
			System.out.println("\n\n Исходный масив");
			Double arrayConverted [] = new Double [arrayLength];	
			for(int i=0; i<arr.length; i++){
				String takeToString = arr[i].toString();	//роблю приведення елементу до String 
				arrayConverted[i] = Double.parseDouble(takeToString); // конвертую String в Double
				System.out.print(arrayConverted[i]+" ");
			}
			
			//сортуємо масив
			Double compareElement;
			String str ="";
			for (int j=0; j<arrayConverted.length; j++) {
				compareElement=arrayConverted[j];
				
				for (int i=0; i<arrayConverted.length; i++) {
					if (sortIndex!=0) { //сортування за спаданням
						str = "убыванию !!!";
						if (compareElement>arrayConverted[i] ) {
							compareElement=arrayConverted[i];
							arrayConverted[i]=arrayConverted[j];
							arrayConverted[j]=compareElement;
						}
					}
					else{ //сортування за зростанням
						if (compareElement<arrayConverted[i] ) {
							str = "возростанию !!!";
							compareElement=arrayConverted[i];
							arrayConverted[i]=arrayConverted[j];
							arrayConverted[j]=compareElement;
						}
					}
				}			
			}
			
			System.out.println("\n!!! сортировка по "+str);
			for (int i=0; i<arrayConverted.length; i++)
				System.out.print(arrayConverted[i]+" "); //друкуємо сортований масив			
		}
		
		catch (Exception e) {
			System.out.println("Ошибка! Ваш масив содержит нечисловые значения");
			System.out.println(e);
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}	
	
	//перегружений метод для двох елементів
	public static <M> void arraySortFunc(M[] arr, int arrayLength) {
		try{
			//створюємо конвертований масив
			System.out.println("\n\n Исходный масив");
			Double arrayConverted [] = new Double [arrayLength];	
			for(int i=0; i<arr.length; i++){
				String takeToString = arr[i].toString();	//роблю приведення елементу до String 
				arrayConverted[i] = Double.parseDouble(takeToString); // конвертую String в Double
				System.out.print(arrayConverted[i]+" ");
			}
					
			//сортуємо масив - сортування за спаданням			
			System.out.println("\n сортитовка по убыванию");
			Double compareElement;
			for (int j=0; j<arrayConverted.length; j++) {
				compareElement=arrayConverted[j];
				for (int i=0; i<arrayConverted.length; i++) {
					if (compareElement>arrayConverted[i] ) {
						compareElement=arrayConverted[i];
						arrayConverted[i]=arrayConverted[j];
						arrayConverted[j]=compareElement;
					}
				}			
			}
			
			for (int i=0; i<arrayConverted.length; i++) //друкуємо сортований масив
				System.out.print(arrayConverted[i]+" "); 	
		}
		
		catch (Exception e) {
			System.out.println("Ошибка! Ваш масив содержит нечисловые значения");
			System.out.println(e);
			for(int i=0; i<arr.length; i++) //друкуємо масив
				System.out.print(arr[i]+" ");
		}
	}
	
	
	public static void main(String[] args){
		Integer masiv1 [] = {46,53,-1,65,-9,82,34,-7,62,-15};
		arraySortFunc(masiv1,10,1);
		
		Short masiv2 [] = {46,53,-1,65,-9,82,34,-7,62,-15};
		arraySortFunc(masiv2,10,0);
		
		Double masiv3 [] = {65.00,-9.00,82.00,46.00,53.00,-1.00,34.00,-7.00,62.00,-15.00};
		arraySortFunc(masiv3,10);
		
		Long masiv4 [] = {-9l,34l,-7l,-1l,65l,-15l,62l,46l,53l,82l};
		arraySortFunc(masiv4,10,0);
		
		String masiv5 [] = {"один", "два", "три","четыре", "пять", "шесть","семь", "восемь", "9", "10"};
		arraySortFunc(masiv5,10);
	}
}
