package lesson20;

import java.util.ArrayList;

public class Group {
	
	public static void main(String[] arg) {
		
		Group geography = new Group("Geography");
		Student st1 = new Student("Маша", 19, geography);
		Student st2 = new Student("Петя", 20, geography);
		Student st3 = new Student("Тамара", 18, geography);
		System.out.println("\nСтудентов в группе = "+geography.getStCount().getValue());
		
		for (Student st: geography.getStList() ) {
			System.out.println(st);
		}
	}
	
	
	//конструктор класса
	public Group(String name){
		this.grName = name;
		this.stCount = new Counter();
		this.getStCount().setMax(40);//максимальное колличество студентов в группе = 40
	}
	
	private String grName; //название группы
	
	public String getGrName() {
		return grName;
	}
	public void setGrName(String grName) {
		this.grName = grName;
	}
	
	private Counter stCount; //счетчик студентов
	
	public Counter getStCount() {
		return stCount;
	}
	public void setStCount(Counter stCount) {
		this.stCount = stCount;
	}
	
	private ArrayList <Student> stList = new ArrayList <Student> ();//список студентов
	
	public ArrayList<Student> getStList() {
		return stList;
	}
	public void setStList(ArrayList<Student> stList) {
		this.stList = stList;
	}
	
}
