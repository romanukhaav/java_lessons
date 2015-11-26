package lesson10;

/*Дан массив чисел размерностью 10 элементов. Написать функцию, которая сортирует массив 
 * по возрастанию или по убыванию, в зависимости от третьего параметра функции.
 * Если он равен 1, сортировка идет по убыванию, если 0, то по возрастанию.
 * Первые 2 параметра функции - это массив и его размер, третий параметр по умолчанию равен 1.*/


public class ArraySortFunc {
	
	public static <M> void arraySortFunc(M[] arr, int arrayLength, int sortIndex) {
		//try{
			//створюємо конвертований масив
			Double arrayConverted [] = new Double [arrayLength];	
			for(int i=0; i<arr.length; i++){
				String takeToString = arr[i].toString();	//роблю приведення елементу до String 
				arrayConverted[i] = Double.parseDouble(takeToString); // конвертую String в Double
				System.out.print(arrayConverted[i]+" ");
			}
			System.out.println();
			//створюємо сортований масив - сортування за зростанням
			Double arraySorted [] = new Double [arrayLength];		
			for(int i=1; i<arrayConverted.length-1; i++){
				arraySorted[i]=arrayConverted[0];
				//знаходимо початковий елемент у масиві
				for(int j=0; j<=arraySorted.length-1; j++){
					
					if (arraySorted[i]>=arrayConverted[j]) {arraySorted[i]=arrayConverted[j];}
				}
		//		System.out.print(arraySorted[0]);
			}
			for(int i=0; i<arraySorted.length-1; i++){ System.out.print(arraySorted[i]+" ");}
		/*}
		
		catch (Exception e) {
			System.out.println(e);
			System.out.println("Ошибка! Ваш масив содержит нечисловые значения");
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			//return 0.00;
		}
		
	}	
	
	public static <M> void arraySortFunc(M[] arr, int arrayLength) {
			try{
				Double sum = 0.0;
				for(int i=0; i<arr.length; i++){
					String takeToString = arr[i].toString(); //роблю приведення елементу до String 
					//System.out.println("Test toString() = "+ takeToString); 
					Double convToDouble = Double.parseDouble(takeToString); // конвертую String в Double
					sum = sum+convToDouble;
					System.out.print(arr[i]+"  ");
					
				}
				//return sum/arr.length;
			}
			catch (Exception e) {
				System.out.println("Ошибка! Ваш масив содержит нечисловые значения");
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i]+" ");
				}
			}	
		*/
	}
	
	
	public static void main(String[] args){
		Integer masiv1 [] = {4,5,-41,65,-79,8,444,-67,62,-15};
		arraySortFunc(masiv1,10,0);
		
		/*
		Short masiv2 [] = {556, 87, 54};
		arraySortFunc(masiv2,10);
		
		Double masiv3 [] = {-88.64, -65.565, 658.0027};
		arraySortFunc(masiv3,10);
		
		Long masiv4 [] = {1l, 34l, -455l};
		arraySortFunc(masiv4,10);
		
		String masiv5 [] = {"один", "два", "три"};
		arraySortFunc(masiv5,10);
		*/
	}
}
