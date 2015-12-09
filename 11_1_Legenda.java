package lesson11;

/* Легенда гласит, что где-то в Ханое находится храм, в котором размещена следующая конструкция:
 * на основании укреплены 3 алмазных стержня, на которые при сотворении мира Брахма нанизал 64 
 * золотых диска с отверстием посередине, причем внизу оказался самый большой диск, 
 * на нем – чуть меньший и так далее, пока на верхушке пирамиды не оказался самый маленький диск.
 * Жрецы храма обязаны перекладывать диски по следующим правилам:
 * 1. За один ход можно перенести только один диск.
 * 2. Нельзя класть больший диск на меньший.
 * Руководствуясь этими нехитрыми правилами, жрецы должны перенести исходную пирамиду с 1-го
 * стержня на 3-й. Как только они справятся с этим заданием, наступит конец света.
 * Мы предлагаем Вам в качестве домашнего задания - решить данную задачу с помощью рекурсии.
 */
import java.math.*;

public class Legenda {
	
	/* обчислення загальної кількості переміщень:
	 * 1)пірамідка з одного диску переміщується за один рух
	 * 2)для переміщення пірамідки з двома дисками потрібно три рухи - зняти верхній шар перемістити нижній
	 * диск і поставити верхній шар назад = 1+1+1
	 * 3)для переміщення пірамідки з трьома дисками потрібно зняти верхній шар (два диски = 3 рухи)
	 * перемістити нижній диск (1 рух) + поставити наверх верхній шар = ще 3 рухи  = 3+1+3 = 7
	 * 4) для переміщення пірамідки з 4 дисків = 7+1+7 = 15
	 * і т.д....
	 * тобто загальна формула N = N*2+1
	 * для обчислення рухів поміщаємо у цикл з 64 разів
	 */ 
	
	static int disks = 6; //задаємо кількість дисків (бо 64 то забагато :) )
	
	public static void main(String[] arg) {
		
		
		System.out.println("Кількість дисків буде = "+disks);
		BigInteger N = BigInteger.valueOf(1);
		 	 
		for (int i=1; i<disks; i++) {
			N = N.multiply(BigInteger.valueOf(2)); 
			N = N.add(BigInteger.valueOf(1));
		}
		
		System.out.println("\n(припускаємо, що 1 переміщення робиться за секунду) ");
		System.out.println("секунд на всі переміщення = "+N);
		System.out.println("хвилин на всі переміщення = "+N.divide(BigInteger.valueOf(60)));
		System.out.println("годин на всі переміщення  = "+N.divide(BigInteger.valueOf(3600)));
		System.out.println("днів на всі переміщення   = "+N.divide(BigInteger.valueOf(3600*24)));
		System.out.println("років на всі переміщення  = "+N.divide(BigInteger.valueOf(3600*24*365)));
		
		System.out.println("\nПочатковий масив");
		
		//створюємо та виводимо двомірний масив з глибиною n
		int array [][]= new int[disks][3];
		for (int i = 0; i<array.length; i++) {
			array[i][0]=i+1;
			array[i][1]=0;
			array[i][2]=0;
			System.out.println(array[i][0]+" "+array[i][1]+" "+array[i][2]);
		}
		
		//застосовуємо нашу функцію переміщення елементів та виводимо результат

		muvPiram(disks,0,1,2,array);
		
		System.out.println("\nДиски переміщено!!!");
		for (int i = 0; i<array.length; i++) {
			System.out.println(array[i][0]+" "+array[i][1]+" "+array[i][2]);
		}
	}
	
	
	/* !!реалізація переміщення масиву!!
	 * загальний принцип рекурсії
	 * muv_piram(64,m1,m3) = muv_piram(63,m1,m2) + muv_disk(64,m1,m3) + muv_piram(63,m2,m3)
	 * ----------------------------
	 * muv_piram(63,m1,m2) = muv_piram(62,m1,m3) + muv_disk(63,m1,m2) + muv_piram(62,m3,m2)
	 * muv_disk(64,m1,m3)
	 * muv_piram(63,m2,m3) = muv_piram(62,m2,m1) + muv_disk(63,m2,m3) + muv_piram(62,m1,m3)
	 * ----------------------------
	 * muv_piram(62,m1,m3) = muv_piram(61,m1,m2) + muv_disk(62,m1,m3) + muv_piram(61,m2,m3)
	 * muv_disk(63,m1,m2)
	 * muv_piram(62,m3,m2) = muv_piram(61,m3,m1) + muv_disk(62,m3,m2) + muv_piram(61,m1,m2)
	 * muv_disk(64,m1,m3)
	 * muv_piram(62,m2,m1) = muv_piram(61,m2,m3) + muv_disk(62,m2,m1) + muv_piram(61,m3,m1)
	 * muv_disk(63,m1,m2)
	 * muv_piram(62,m1,m3) = muv_piram(61,m1,m2) + muv_disk(62,m1,m3) + muv_piram(61,m2,m3)
	 * ----------------------------
	 *
	 * .......
	 * .......
	 * muv_piram(1,m1,m3)  = muv_piram(0,m1,m2) +  muv_disk(1,m1,m3) +  muv_piram(0,m2,m3) = muv_disk(1,m1,m3)
	 */
	
	// для зручності скористаємось двомірним масивом 64*3
	// будемо переміщати елементи з першого стовбчика масиву у третій
  
    //функція переміщення пірамідки з n елеминтів, з стовбчика m0 в m2 через m1
	public static int[][] muvPiram(int n,int m0, int m1, int m2, int[][] array){ 
	// функція muvPiram - здійснює перекладання muvDisk ЛИШЕ при умові, що працює з одним 
	//елементом, а коли у нас пірамідка функція рекурсивоно викликає сама себе
		if(n==0) return array;
		muvPiram(n-1,m0,m2,m1,array);
		muvDisk(n,m0,m2,array);
		muvPiram(n-1,m1,m0,m2,array);
		return array;
		}
	
	//функція переміщення елементу n з стовбчика m0 в m2
	public static void muvDisk(int n, int m0, int m2, int[][] array){ 		 		
		//array[n-1][m0]=0;
		//array[n-1][m2]=n;	
		//_а Вместо простого переложения диска n на столбец m2 в ту же позицию, с которой диск взят на столбце m0
		//_а ложим диск на низ столбца m0
		for (int i=disks-1; i>=0; i--) {
			if (array[i][m2]==0) {
				array[i][m2]=n;
				
				for (int j=disks-1; j>=0; j--) {
					if (array[j][m0]==n) {
						array[j][m0]=0;
						break;
					}
				}
				
				break;
			}
		}
		
		System.out.println("\nПроміжне відображення"); 
		for (int i = 0; i<array.length; i++) {
			System.out.println(array[i][0]+" "+array[i][1]+" "+array[i][2]);
		}
	}
}
