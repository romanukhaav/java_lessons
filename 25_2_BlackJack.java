package lesson25;

import java.util.ArrayList;

public class BlackJack {
	
	public static void main(String [] args){
		
//		System.out.println("Игра БлэкДжек");
//		System.out.println("Введите колличество участников от компъютера");
//		System.out.println("Введите колличество участников от игроков");
		
		//створюємо гру за замовчуванням - лише ПК проти користувача
		Game gam1 = new Game();
		
		//запускаємо гру на виконання
		gam1.start();
	}
	
	static class Game{
		PCuser pcUs;
		ArrayList <User> users;
		ArrayList <User> subUsers;
		
		public void start(){
			//проводиться встановлення початкової суми готівки в кожного гравця
			for (User gamer: users) gamer.money=1500;
			
			//виконуються цикли поки не залишиться один гравець з грошима
			//або поки не вийдуть з гри усі гравці користувача
			do 
				{
					//запускаємо субгру - здачі карт і т.д.
					this.subGame();
					
					//здійснюється перевірка, наявності коштів у гравців, якщо нуль то видал з users
					//також в процесі гри кожен учасник користувача може вийти з гри = видал з users
					for (User gamer: users) {
						if (gamer.money<=0) users.remove(gamer);
					}
				}
			while (users.size()>1);
			
			this.end(); //друк результатів гри + вихід з програми
			
		};
		
		public void subGame(){
			//Усі наявні користувачі стають гравцями субгри
			subUsers=(ArrayList<User>)users.clone();
			
			//береться повна колода карт
			Cards subCards = new Cards();
			
			int banck=0; //банк субгри = 0 
			
			//входження субгравців
			for (User gamer: subUsers){
				gamer.score=0; //для кожного гравця кількість очок =0 і 
				
				//проводиться роздача двох карт кожному
				gamer.getCard(subCards.giveCard());
				gamer.getCard(subCards.giveCard());
				
				//кожен робить початкову ставку у банк
				gamer.money-=10;
				banck+=10;
			}
				
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
			//введені гравці подаються у масив гравців
			//при параметах по замовчуванню - два ПК та користувач
			PCuser pcUs = new PCuser();
			User us1 = new User();
			users.add(pcUs);
			users.add(us1);			
		};
		
		Game(int numOfPCusrs, User...usArr){
			//введені користувачі подаються у масив користувачів

			for (int i =0; i<numOfPCusrs; i++) {
				users.add(new PCuser()); //додаємо в масив гравців ПК
			}
			
			for( User us: usArr ){ //додаємо в масив гравців користувача
				users.add(us);
			}
			
		}
		
	}
	
	static class User{
		public int score = 1500, money;
		
		
		public int getCard( Card newCard){
			this.score+=newCard.score;
			return this.score;
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
