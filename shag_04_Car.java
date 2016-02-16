package oop;
/*Создать класс Car со следующими полями:
 * id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
 * Определить конструкторы и методы setТип(), getТип(), toString(). 
 * Создать массив объектов.
 * Вывести: 
 * a) список автомобилей заданной марки; 
 * b) список автомобилей заданной модели, которые эксплуатируются больше n лет; 
 * c) список автомобилей заданного года выпуска, цена которых больше указанной.
 */


public class Car {
	
	public static void main (String[] arg) {
		
		Car[] carArr = new Car[8];

		carArr[1] = new Car("Москвич","ИЖ412", 1981, "червоний", 800, "AB3654BC");
		carArr[2] = new Car("Volkswagen","Golf", 1985, "синій", 3000, "AС9372BC");
		carArr[3] = new Car("Renault","Megane", 2004, "оливковий", 6000, "ВК7688BВ");
		carArr[4] = new Car("Renault","Logan", 2008, "сірий", 8000, "AР3569MN");
		carArr[5] = new Car("Volkswagen","Passat", 2008, "коричневий", 8500, "AА1293ВВ");
		carArr[6] = new Car("Toyota","Auris", 2016, "синій", 1000, "AA3838AT");
		carArr[7] = new Car("AB8822BC");
		carArr[0] = new Car();
		
		//показывем список автомобилей заданной марки;
		System.out.println("Авто Renault:");
		for (Car avto :carArr) {
			if (avto.getMark()=="Renault")				
				System.out.println(avto);
		}
		
		//показывем список автомобилей заданной модели, которые эксплуатируются больше 4 лет;
		System.out.println("\n\nАвто Volkswagen, старіші ніж 4 роки:");
		for (Car avto :carArr) {
			if (avto.getMark()=="Volkswagen" && (2016-avto.getYear()>4))
				System.out.println(avto);
		}
		
		//показывем список автомобилей заданного года выпуска, цена которых больше указанной.
		System.out.println("\n\nАвто 2008 року, дорожчі 8000$:");
		for (Car avto :carArr) {
			if (avto.getYear()==2008 && (avto.getPraice()>8000))
				System.out.println(avto);
		}
	}
	
	private static int id = 0;
	
	private String mark, model, color, number;
	private int year, praice, carId;
	
	Car() {
		Car.setId(id+1);
	}
	
	Car(String number) {
		Car.setId(id+1);
		this.setNumber(number);
	}
	
	Car(String mark, String model, int year, String color, int praice, String number) {
		Car.setId(id+1);
		this.setMark(mark);
		this.setModel(model);
		this.setYear(year);
		this.setColor(color);
		this.setPraice(praice);
		this.setNumber(number);
		this.setCarId(Car.getId());
	}


	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Car.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPraice() {
		return praice;
	}

	public void setPraice(int praice) {
		this.praice = praice;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public String toString(){
		return  "\nАвто:\nМарка "+this.getMark()+
				"\nМодель "+this.getModel()+
				"\nРік "+this.getYear()+
				"\nКолір "+this.getColor()+
				"\nЦіна $ "+this.getPraice()+
				"\nНомер "+this.getNumber()+
				"\nКод ID "+this.getCarId();
	}
	
}
