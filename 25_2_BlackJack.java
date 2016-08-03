package lesson25;

import java.util.ArrayList;
import java.util.Random;

public class BlackJack {
		// случайное значение
		static Random random = new Random();
		
	public static void main(String [] args){
		
		System.out.println("Игра БлэкДжек");
//		System.out.println("Введите колличество участников от компъютера");
//		System.out.println("Введите колличество участников от игроков");
		
		//створюємо гру за замовчуванням - лише ПК проти користувача
		Game gam1 = new Game();
		
		//запускаємо гру на виконання
		gam1.start();
	
	}
	
	static class Game{
		ArrayList <User> usersGame = new ArrayList <User>();;
		
		public void start(){
			//проводиться встановлення початкової суми готівки в кожного гравця
			for (User gamer: usersGame) gamer.money=1500;
			
			//виконуються цикли поки не залишиться один гравець з грошима
			//або поки не вийдуть з гри усі гравці користувача
			do 
				{
					//запускаємо субгру - здачі карт і т.д.
					SubGame subGame = new SubGame(usersGame);
					
					//здійснюється перевірка, наявності коштів у гравців, якщо нуль то видал з users
					//також в процесі гри кожен учасник користувача може вийти з гри = видал з users
					for (User gamer: usersGame) {
						if (gamer.money<=0) usersGame.remove(gamer);
					}
				}
			while (usersGame.size()>1);
			
			this.end(); //друк результатів гри + вихід з програми
			
		}

		public void end(){
			System.out.println(this.usersGame);
		};
		
		//конструктор по замовчуванню
		Game(){ 
			System.out.println("Гра за замовчуванням: ПК проти користувача");
			//введені гравці подаються у масив гравців
			//при параметах по замовчуванню - два ПК та користувач
			usersGame.add(new PCuser());
			usersGame.add(new User());
		}
		
		//конструктор з мультипараметром
		Game(int numOfPCusrs, User...usArr){
			//введені користувачі подаються у масив користувачів

			for (int i =0; i<numOfPCusrs; i++) {
				usersGame.add(new PCuser()); //додаємо в масив гравців ПК
			}
			
			for( User us: usArr ){ //додаємо в масив гравців користувача
				usersGame.add(us);
			}
			
		}
		
	}
	
	static class SubGame{
		
		//береться повна колода карт
		Cards subCards = new Cards();
		
		int banck=0;  //банк субгри = 0 
		int stavka=1; //початкове значення ставки
		
		ArrayList<User> subGamers; //гравці субгри
		
		//конструктор subGame
		SubGame(ArrayList<User> gamers){
			this.subGamers=(ArrayList<User>)gamers.clone();
			System.out.println("Партія");
			System.out.println(gamers);
			
			//входження субгравців
			for (User gamer: gamers){
				gamer.score=0; //для кожного гравця кількість очок = 0 і 
										
				//проводиться роздача двох карт кожному
				gamer.getCard(subCards.giveCard());
				gamer.getCard(subCards.giveCard());
				
				//кожен робить початкову ставку у банк
				gamer.money-=10*stavka;
				banck+=10;
			}
				
			do {
				this.cicle(gamers);
				//почергово хід надається кожному користувачу поки не зпасують усі крім одного,
				//або поки хтось не відкриє карти
				//gamers.remove(gamers.size()-1); //симуляція відсіву гравців
			}
			while (gamers.size()>1);
			//процедура передачі резултатів виконання субгри у гру
		}
		
		public ArrayList<User> cicle(ArrayList<User> subUsers){
			//друкуємо поточний стан гравців
			System.out.println(subUsers);
			
			//прочергово надається хід кожному користувачу
			for (User subuser: subUsers){
				
				//якщо клас гравця User
				if (subuser.getClass() != null ) { //!!! правильно порівняти клас!!!
					//зробіть ваш хід
					
					//pas() = видалення з subusers
					//getcard() = взяти карту з колоди
					//doubl() = подвоїти ставку
					//open() = відкрити карти і завершити субгру
					
					//симуляція виходу з гри для тесту
					subuser.subExit(this);
				}
				
				else { //якщо клас гравця PCuser
						
						//математика обчислення автоматичного ходу 
						
						if (subuser.score<=10) subuser.getCard(subCards.giveCard());
						if (subuser.score>=10&&subuser.score<=15){ 
							//процент взяття карти 50%	
						}
						if (subuser.score==21){ 
							//процент подвоєння ставки 80%				
						}
						if (subuser.score>21){ 
							//процент пасування 90%
						}
						
						//симуляція виходу з субгри
						subuser.subExit(this);
					}
				}				
			
			return subUsers;
		}
		
	}
	
	static class User{
		public String name = "Пользователь";
		public ArrayList<Card> userCards= new ArrayList<Card>();
		
		public int score = 0, money = 1500;
		
		public void step(){}
		
		public int getCard( Card newCard){
			this.userCards.add(newCard);
			this.score+=newCard.score;
			return this.score;
		}
			
		public void pas(){
			//гравець пропускає хід
			
		}
		
		public Object subExit(SubGame subGame){
			
			System.out.println("Хватить - виходжу з субгри! "+this);
			
			return subGame.subGamers.remove(this); //вихід гравця з субгри
			
			
		}
		
		public void doubl(){} 
		
		public String toString(){
			return this.name+": "+this.money+"; score: "+this.score;
		}
		
	}
	
	static class PCuser extends User {
		public String name = "Компьютер";
		public void step(){}
		
		public String toString(){
			return this.name+": "+this.money+"; score: "+this.score;
		}
	}
	
	static class Cards{
		ArrayList <Card> cards;
		// случайное значение
		
		public Card giveCard(){
			//видаємо будь-яку карту з колоди
			int randomPosition = random.nextInt(cards.size());
			return cards.get(randomPosition);
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
	}
	
}
