package lesson16;
/*Создать структуру ВИДЕОМАГАЗИН со следующими полями: 

Название фильма 
Режиссер 
Жанр 
Рейтинг популярности 
Цена диска

Реализовать следующие возможности:
Поиск по названию 
Поиск по жанру 
Поиск по режиссеру 
Самый популярный фильм в жанре 
Показ всех записей и добавление 

 */

import java.util.ArrayList;

public class VideoShop {
	
	public static void main (String[] arg) {
		
		ArrayList <VideoShop> movieArr = new ArrayList<VideoShop>();

		movieArr.add(new VideoShop("Тіні забутих предків","Акуджава", "драма", 8, 70));
		movieArr.add(new VideoShop("Буратіно","Нечаєв", "дитячий", 7, 40));
		movieArr.add(new VideoShop("Термінатор","Кемерон", "бойовик", 7, 80));
		movieArr.add(new VideoShop("Собачье сердце","Бортко", "драма", 8, 80));
		movieArr.add(new VideoShop("Пикник на обочине","Тарковский", "фантастика", 9, 100));
		movieArr.add(new VideoShop("Соляріс","Тарковский", "фантастика", 9, 100));
		
		//показывем список фильмов заданного названия;
		System.out.println("__Фільми по назві \"Тіні забутих предків\":");
		for (VideoShop movie :movieArr) {
			if (movie.getName()=="Тіні забутих предків")				
				System.out.println(movie);
		}
		
		//показывем список фильмов заданного жанра;
		System.out.println("\n\n__Фільми по жанру драма:");
		for (VideoShop movie :movieArr) {
			if (movie.getGanre()=="драма")				
				System.out.println(movie);
		}
		
		//показывем список фильмов по режиссеру .
		System.out.println("\n\n__Фільми по режисеру Тарковский:");
		for (VideoShop movie :movieArr) {
			if (movie.getAuthor()=="Тарковский")				
				System.out.println(movie);
		}
		
		//Самый популярный фильм в жанре 
		System.out.println("\n\n__Найпопулярніші фільми:");
		int raiting = 0;
		for (VideoShop movie :movieArr) {			
			if (movie.getRaiting()>=raiting)				
				raiting=movie.getRaiting();
		}
		for (VideoShop movie :movieArr) {
			if (movie.getRaiting()==raiting)				
				System.out.println(movie);
		}
		
		//Показ всех записей 
		System.out.println("\n\n__Усі фільми:");
		for (VideoShop movie :movieArr) {			
			System.out.println(movie);
		}
		
		//добавление
	}
	
	private static int id = 0;
	
	private String name, author, ganre;
	private int raiting, praice, VideoShopId;
	
	
	VideoShop(String name, String author, String ganre, int raiting, int praice) {
		VideoShop.setId(id+1);
		this.setName(name);
		this.setAuthor(author);
		this.setGanre(ganre);
		this.setRaiting(raiting);
		this.setPraice(praice);
		this.setVideoShopId(VideoShop.getId());
	}


	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		VideoShop.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGanre() {
		return ganre;
	}

	public void setGanre(String ganre) {
		this.ganre = ganre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}

	public int getPraice() {
		return praice;
	}

	public void setPraice(int praice) {
		this.praice = praice;
	}
	
	public int getVideoShopId() {
		return VideoShopId;
	}

	public void setVideoShopId(int VideoShopId) {
		this.VideoShopId = VideoShopId;
	}
	
	public String toString(){
		return  "\nФільм:  Назва: "+this.getName()+
				"\\ Режисер: "+this.getAuthor()+
				"\\ Жанр: "+this.getGanre()+
				"\\ Рейтинг: "+this.getRaiting()+
				"\\ Ціна: "+this.getPraice();
	}
	
}
