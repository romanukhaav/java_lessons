package lesson17;

/*Написать программу для хранения в битовом поле информации о конфигурации компьютера.
1 - корпус: AT – 0, ATX – 1;
2 - видео: видео на борту – 0, карта – 1
3 - проц (>= i3)
4 - memory (>=ddr3)
5 - memorySize (>=4Gb)
6 - hdd (sata)
7 - hddSize (>=500Gb)
8 - cd/dvd
 */

import java.util.Scanner;

public class CompConfig {
	


	
	public static void main(String[] args) {
		   

		byte b = readConfig();
		System.out.println("ID конфигурации вашего ПК = "+b);
		System.out.println(byteToString(b));
		
		/*System.out.println("\n\nвосьмой бит ставим = 1");
		b=SetBitToOne(b,7);
		System.out.println("измененное число "+b);
		System.out.println(byteToString(b));
*/
	}
	
	private static byte readConfig() {
		byte n = 0;
		System.out.println("Введите конфигурацию компьютера\nВводить еденицу или ноль");
		Scanner br = new Scanner(System.in);;
		
		
		System.out.println("1 Введите конфигурацию корпуса: AT – 0, ATX – 1");
		int h=15;
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		System.out.println("Вы ввели "+h);
		if (h==1) n = SetBitToOne (n, 0);
		else n = SetBitToZero (n, 0); 
		h=12;
		
		System.out.println("2 Введите конфигурацию  видео: видео на борту – 0, видеокарта – 1");
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		if (h==1) n = SetBitToOne (n, 1);
		else n = SetBitToZero (n, 1); 
		h=12;
		
		System.out.println("3 Введите конфигурацию процессора: ниже i3 - 0, i3 и выше - 1");
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		if (h==1) n = SetBitToOne (n, 2);
		else n = SetBitToZero (n, 2);
		h=12;
		
		System.out.println("4 Введите конфигурацию памяти: ниже DDR3 – 0, DDR3 и выше – 1");
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		if (h==1) n = SetBitToOne (n, 3);
		else n = SetBitToZero (n, 3);
		h=12;
		
		System.out.println("5 Введите обьем памяти: меньше 4Gb – 0, 4Gb и больше – 1");
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		if (h==1) n = SetBitToOne (n, 4);
		else n = SetBitToZero (n, 4);
		h=12;
		
		System.out.println("6 Введите конфигурацию жесткого диска: IDE – 0, SATA – 1");
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		if (h==1) n = SetBitToOne (n, 5);
		else n = SetBitToZero (n, 5);
		h=12;
		
		System.out.println("7 Введите обьем жесткого диска: меньше 500Gb – 0, 500Gb и больше – 1");
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		if (h==1) n = SetBitToOne (n, 6);
		else n = SetBitToZero (n, 6);
		h=12;
		System.out.println("8 Введите наличие привода cd/dvd: отсутствует - 0, пристутствует – 1");
		while (h!=1 || h!=0) {
			h = br.nextInt();
			if (h==1||h==0) break;
			else System.out.println("Введите корректное значение! 0 или 1");
		}
		if (h==1) n = SetBitToOne (n, 7);
		else n = SetBitToZero (n, 7);		
        
        return n;
	}
	
	private static byte BitSetted (byte n, int i){ // (n - число, i - бит начиная с нуля)
		return (byte)((n >> i) & 1);
	}
	
	private static byte SetBitToOne (byte n, int i){
		return (byte)(n | (1 << i));
	}
	
	private static byte SetBitToZero (byte n, int i){
		return (byte)(n & ~(1 << i));
	}
	
	private static String byteToString(byte b) {
		String s = "";
	    for (int i = 0; i < 8; i++) {
	      s = ((b >> i) & 1)+s;
	    }
	    return s;
	}
		  
}
