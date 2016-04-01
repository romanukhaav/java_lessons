package lesson18;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*Создать программу, фильтрующую текст, загруженный с файла.
 * Задача программы заключается в считывании текста и отбражении его на экране,
 * используя замену заданного набора символов на пробелы.
 * Программа должна предлагать следующие варианты наборов символов для фильтрации:
 * Символы латинского алфавита
 * Символы кириллицы
 * Символы пунктуации
 * Цифры
 * Фильтры могут накладываться последовательно. При повторной установке существующего 
 * фильтра данный фильтр должен сниматься.
 */	

public class TextFilters {
	//фильтры текста
	private static final String SYMBOLS1 = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЇїйцукенгшщзхъфывапролджэячсмитьбю";
	private static final String SYMBOLS2 = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
	private static final String SYMBOLS3 = ".,-!;?\":";
	private static final String SYMBOLS4 = "0123456789";

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		String line;
		String mark1 = "off", mark2 = "off", mark3 = "off", mark4 = "off"; //для красоты :)
		int h=11;
		ArrayList <String> fileArray = new ArrayList <String> (); //массив для текста
		String filterArray[] = {"","","",""}; //массив фильтров
		
		//путь к файлу без привязки к операционной системе 
		//http://www.friendlyfunction.com/ru/category/java/java-filesystem/
		String filename = "file.txt";
		String dir = System.getProperty("user.dir");
		System.out.println("Путь System.getProperty(\"user.dir\") = "+dir);
		String fullPath = dir + File.separator + filename;
		System.out.println("Полный путь: " + fullPath+"\n");
		
				
		//читаем и выводим начальный файл
				System.out.println("**исходный текст**");
				File file = new File(fullPath);
				try {
					br = new BufferedReader(new InputStreamReader (new FileInputStream(file)));
					while ((line = br.readLine()) != null) {
						System.out.println(line);
						fileArray.add(line); // наполняем массив строк для последующей обработки
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						br.close();
					} catch (Exception e) {
					}
				}
		
		//считываем число и обрабатываем установку фильтра						
				try {
					while(true){ //нескончаемый цыкл - выход через подач нуля в метод setFilter
						sc = new Scanner(System.in);
						
						while (h!=0 || h!=1 || h!=2 || h!=3 || h!=4 ) {
							System.out.println("\n\nУстановите\\удалите фильтр:"
									+ "\n1) - кирилица; " + mark1
									+ "\n2) - латинница; "+ mark2
									+ "\n3) - знаки препинания; "+ mark3
									+ "\n4) - числа; "+ mark4
									+ "\n0) - выход из программы.");
							h = sc.nextInt();
							if (h==0||h==1||h==2||h==3||h==4){
								textFilter(fileArray, setFilter(h,filterArray)); //вывод массива
								//устанавливаем маркеры фильтров
								if (filterArray[0]!="") mark1="on"; else mark1="off";
								if (filterArray[1]!="") mark2="on"; else mark2="off";
								if (filterArray[2]!="") mark3="on"; else mark3="off";
								if (filterArray[3]!="") mark4="on"; else mark4="off";
							}
							else System.out.println("!!Введите корректное значение!!");
						}
					}
					
				}
				finally {
					sc.close();
				}
	}
	
	
	//метод фильтрации + вывод результатов:
		public static void textFilter(ArrayList <String> inputArray, String filterSymbols){
			char[] filterArray=filterSymbols.toCharArray();
			System.out.println("\n**текст отфильтрованый**");
			for (String ln:inputArray) {
				for (char ch:filterArray){
					ln = ln.replace(ch, '_');
				}
				System.out.println(ln); //выводим отфильтрованную строку
			}
		}
		
	
	//метод установки фильтров
		public static String setFilter(int num, String Filter[]){
			switch (num){
			case 1:
				if (Filter[0]=="") Filter[0]=SYMBOLS1;
				else Filter[0]="";
				return Filter[0]+Filter[1]+Filter[2]+Filter[3];
			case 2:
				if (Filter[1]=="") Filter[1]=SYMBOLS2;
				else Filter[1]="";
				return Filter[0]+Filter[1]+Filter[2]+Filter[3];
			case 3:
				if (Filter[2]=="") Filter[2]=SYMBOLS3;
				else Filter[2]="";
				return Filter[0]+Filter[1]+Filter[2]+Filter[3];
			case 4:
				if (Filter[3]=="") Filter[3]=SYMBOLS4;
				else Filter[3]="";
				return Filter[0]+Filter[1]+Filter[2]+Filter[3];
			case 0:
				System.out.println("\n***Досвидания***");
				System.exit(0);
			}
			return Filter[0]+Filter[1]+Filter[2]+Filter[3];
		}
	
}
