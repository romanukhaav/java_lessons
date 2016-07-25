package lesson25;

import java.util.ArrayList;

public class BlackJack {
	
	public static void main(String [] args){
		
		System.out.println("Игра БлэкДжек");
		System.out.println("Введите колличество участников от компъютера");
		System.out.println("Введите колличество участников от игроков");
		
		//створюємо гру з заданою кількістю гравців
		Game gam1 = new Game();
		
		//запускаємо гру на виконання
		gam1.start();
	}
	
	static class Game{
		PCuser pcUs;
		ArrayList <User> users;
		ArrayList <User> subUsers;
		
		public void start(){
			//проводиться встановлення початкової суми готівки в кожного користувача
			//виконуються цикли поки не залишиться один гравець з грошима
			//або поки не вийдуть з гри усі гравці користувача
			do {
				this.subgame();
				//здійснюється перевірка, наявності коштів у гравців, якщо нуль то видал з users
				//також в процесі гри кожен учасник користувача може вийти з гри = видал з users
			}
			while (users.size()>1);
			this.end(); //друк результатів гри + вихід з програми
			
		};
		
		public void subgame(){
			subUsers=(ArrayList<User>)users.clone();
			//проводиться роздача двох карт 
			do {
				this.cicle();
				//почергово хід надається кожному користувачу поки не зпасують усі крім одного,
				//або поки хтось не відкриє карти
			}
			while (this.subUsers.size()>1);
			
		};
		
		public void cicle(){
			//прочергово надається хід кожному користувачу
			//pas() = видалення з subusers
			//getcard() = взяти карту з колоди
			//doubl() = подвоїти ставку
			//open() = відкрити карти і завершити субгру
			
		};
		
		public void end(){};
		
		Game(){
			PCuser pcUs = new PCuser();
			User us1 = new User();
		};
		
		Game(User...us1){
			PCuser pcUs = new PCuser();
			this.users = new ArrayList <User>();
		}
		
	}
	
	static class User{
		public int score = 1500, money;
		
		
		public int getCard(){
			return score;
		}
		
		public void pas(){};
		
		public void doubl(){}; 
		
	};
	
	static class PCuser extends User {
		
	};
	
	static class Cards{
		ArrayList <Card> cards;
		
		public Card giveCard(){
			//видаємо будь-яку карту з колоди
			return cards.get(0);
		}
		
		Cards(){
			cards = new ArrayList <Card>();
			String[] lear = {"черв", "бубн","пик","хрест"};
			for (String lr: lear){
				for (int i = 1; i<=10; i++){
					Card cr = new Card();
					cr.lear = lr;
					cr.score = i;
					cr.name = i +" "+lr;
					cards.add(cr);
				}
				// додаємо валет, дама, король туз
				Card cr = new Card();
				cr.lear = lr;
				cr.score = 10;
				cr.name = " валет "+lr;
				cards.add(cr);
				
				cr.lear = lr;
				cr.score = 10;
				cr.name = "дама "+lr;
				cards.add(cr);
				
				cr.lear = lr;
				cr.score = 10;
				cr.name = "король "+lr;
				cards.add(cr);
				
				cr.lear = lr;
				cr.score = 11;
				cr.name = "туз "+lr;
				cards.add(cr);
			}
		}
	}
	
	static class Card{
		String name;
		String lear;
		String visual;
		int score;
		
	};
	
}
