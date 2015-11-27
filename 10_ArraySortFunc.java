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
			System.out.println("\n\n сортування за зростанням");
			
			//сортуємо масив - сортування за зростанням
			Double arraySorted[] = new Double [arrayLength];
			arraySorted[0]=arrayConverted[0];
			for (int j=1; j<arrayConverted.length; j++) {
				
			
					//знаходимо найменший елемент масиву
					Double compareElement=arrayConverted[j];
					for (int i=0; i<arrayConverted.length; i++) {
						if (compareElement>arrayConverted[i] && compareElement>=arraySorted[j-1]) compareElement=arrayConverted[i];
					}
		//			System.out.println("\n\n найменший елемент масиву = "+compareElement);
			
					arraySorted[j]=compareElement;
			}
			
			
			/*Double arraySorted[] = new Double [arrayLength];
			Double compareElement;	
			arraySorted[0]=arrayConverted[0];
			for(int i=0; i<arrayConverted.length; i++){
				compareElement = arrayConverted[i];
				int k=i;
				if (k==0) k++;
				for(int j=0; j<arrayConverted.length; j++){
					if (compareElement>=arrayConverted[j]&&compareElement<arraySorted[k-1]) {
					compareElement=arrayConverted[j];
					//arrayConverted[j]=arrayConverted[i];
					}
				}
				arraySorted[i]=compareElement;
			}
			*/
			
			for(int i=0; i<arraySorted.length; i++){ System.out.print(arraySorted[i]+" ");}
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
		Integer masiv1 [] = {46,53,-1,65,-9,82,34,-7,62,-15};
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
