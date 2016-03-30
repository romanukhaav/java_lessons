package lesson18;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

	public static void main(String[] args) {
		BufferedReader br = null;
		String line;
		ArrayList <String> fileArray = new ArrayList <String> ();
		
		
		//путь к файлу без привязки к операционной системе 
		//http://www.friendlyfunction.com/ru/category/java/java-filesystem/
		
		String filename = "file.txt";
		String dir = System.getProperty("user.dir");
		System.out.println("Путь System.getProperty(\"user.dir\") = "+dir);
		String fullPath = dir + File.separator + filename;
		System.out.println("Полный путь: " + fullPath+"\n");
		
				
		//читаем и выводим файл
		System.out.println("**исходный текст**");
		File file = new File(fullPath);
		try {
			br = new BufferedReader(new InputStreamReader (new FileInputStream(file)));
			int i=0;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				fileArray.add(line); // наполняем массив строк для последующей обработки
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
			}
		}
				
		//фильтры
		String filterSymbols1 = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЇїйцукенгшщзхъфывапролджэячсмитьбю";
		String filterSymbols2 = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		String filterSymbols3 = ".,-!?\"";
		String filterSymbols4 = "0123456789";
		
		//вывод массива
		//System.out.println(latinFilter(fileArray, filterSymbols1));
		System.out.println("\n\n**текст отфильтрованый**\n");
		latinFilter(fileArray, filterSymbols3);
	}
	
	//метод фильтрации + вывод результатов:
		public static ArrayList <String> latinFilter(ArrayList <String> inputArray, String filterSymbols){
			ArrayList <String> outputArray = new ArrayList <String>();
			char[] filterArray=filterSymbols.toCharArray();
			for (String ln:inputArray) {
				for (char ch:filterArray){
					ln = ln.replace(ch, '_');
				}
				System.out.println(ln);
			outputArray.add(ln);
			}
			return outputArray;
		}
		
	
	//метод установки фильтров !!доделать!!
	
}
