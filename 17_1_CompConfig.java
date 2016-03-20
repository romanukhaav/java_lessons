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

public class CompConfig {
	static String str = "";
	public static void main(String[] args) {

		Byte b = 3;
		System.out.println("число "+b);
		System.out.println(byteToString(b));
		
		System.out.println("\n\nвосьмой бит ставим = 1");
		b=SetBitToOne(b,7);
		System.out.println("измененное число "+b);
		System.out.println(byteToString(b));

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
