package lesson9;

//Написать шаблон функции для поиска 
//среднего арифметического значений массива.

public class Generics {
	
	static <M /*extends Number*/> Double average(M[] arr) {
		try{
			Double sum = 0.0;
			for(int i=0; i<arr.length; i++){
				String takeToString = arr[i].toString(); //роблю приведення елементу до String 
				//System.out.println("Test toString() = "+ takeToString); 
				Double convToDouble = Double.parseDouble(takeToString); // конвертую String в Double
				sum = sum+convToDouble;
				System.out.print(arr[i]+"  ");
				
			}
			return sum/arr.length;
		}
		catch (Exception e) {
			System.out.println("Ошибка! Ваш масив содержит нечисловые значения");
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			return 0.00;
		}
	}
	
	public static void main(String[] args){
		Integer masiv1 [] = {4,5,-41,65,-79,8,444,-67};
		System.out.println("\nСреднее арифметическое в массиве1 = " + average(masiv1)+"\n");
		
		Short masiv2 [] = {556, 87, 54};
		System.out.println("\nСреднее арифметическое в массиве2 = " + average(masiv2)+"\n");
		
		Double masiv3 [] = {-88.64, -65.565, 658.0027};
		System.out.println("\nСреднее арифметическое в массиве3 = " + average(masiv3)+" \n");
		
		Long masiv4 [] = {};
		System.out.println("\nСреднее арифметическое в массиве4 = " + average(masiv4)+"\n");
		
		String masiv5 [] = {"один", "два", "три"};
		System.out.println("\nСреднее арифметическое в массиве2 = " + average(masiv5));
	}
}
