package lesson21;

/*Разработать класс Person, который содержит соответствующие члены для хранения: 
имени, 
возраста, 
пола и 
телефонного номера. 
Напишите функции-члены, которые смогут изменять эти члены данных индивидуально.
Напишите функцию-член Person::Print(), которая выводит отформатированные данные о человеке.*/

public class Persona {
	public java.lang.String name;
	public int age;
	public java.lang.String male;
	public java.lang.String phone;
	
	
	public void setName(java.lang.String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMale(java.lang.String male) {
		this.male = male;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	
	public java.lang.String toString(){
		return "\nПривет! Я " + this.name
			 + ".\nМне "+ this.age +" лет"
			 + ".\nЯ " + this.male
			 + ".\nМой телефон: " + this.phone;
	}

	public Persona(java.lang.String string, int age, java.lang.String string2, java.lang.String string3){
		
		this.name = string;
		this.age = age;
		this.male = string2;
		this.phone = string3;
		
	}
	
	public Persona(java.lang.String name){
		
		this.name = name;
		
	}
	
	
	public static void main(java.lang.String[] arg){
		Persona pers1 = new Persona("Валентин", 28, "мужчина", "097-777-77-77");
		Persona pers2 = new Persona("Валентина", 26, "женщина", "093-333-33-33");
		Persona pers3 = new Persona("Евгений");
		Persona pers4 = new Persona("Евгения");
		pers3.setAge(32);
		pers3.setMale("мужчина");
		pers3.setPhone("050-050-50-50");
		pers4.setAge(19);
		pers4.setMale("женщина");
		pers4.setPhone("095-555-55-55");
		System.out.println(pers1);
		System.out.println(pers2);
		System.out.println(pers3);
		System.out.println(pers4);
	}

}
