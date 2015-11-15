package lesson9;

//Написать шаблон функции для поиска 
//среднего арифметического значений массива.


public class Generics {
	
	static <M extends Number> Double average(M[] arr) {
		Double sum = 0.0;
		for(int i=0; i<arr.length; i++){
			
			String takeToString = arr[i].toString(); //роблю приведення елементу до String 
			//System.out.println("Test toString() = "+ takeToString); 
			Double convToDouble = Double.parseDouble(takeToString); // конвертую String в Double
			sum = sum+convToDouble;
			System.out.print(arr[i]+" ");
			
		}
		return sum/arr.length;
	}
		
	
	public static void main(String[] args){
		Integer masiv1 [] = {4,5,1,5,9,8,4444444,-67};
		System.out.println("\n Среднее арифметическое в массиве1 = " + average(masiv1)+"\n");
		
		Short masiv2 [] = {556, 87, 54};
		System.out.println("\n Среднее арифметическое в массиве2 = " + average(masiv2)+"\n");
		
		Double masiv3 [] = {-88.64,-65.56565, 658.00274};
		System.out.println("\n Среднее арифметическое в массиве3 = " + average(masiv3)+"\n");
	}
}
