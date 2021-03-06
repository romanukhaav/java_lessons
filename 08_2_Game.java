package Lesson8;

/*Игра «кубики». Условие: имеется два игральных кубика со значениями от 1 до 6.
 *  Игра происходит с компьютером, кубики бросаются поочередно.
 *  Побеждает тот, у кого сумма выпавших очков по итогам пяти бросков больше.
 *  Предусмотрите возможность получения первого хода человеком или компьютером.
 *  Кубики отображаются с помощью символов. В конце игры 
 *  необходимо выводить среднюю сумму по броскам для обоих участников. */

import java.util.Scanner;

public class Game {
	private int gamer1Sum;
	private int gamer2Sum;
	private String gamer1Name;
	private String gamer2Name;
	private static Scanner scan;
	
	// в класі Game прописуємо метод кидати
	public int drop() {
		return (int)(1+Math.random()*(7-1));
	}
		
	// в класі Game прописуємо метод друкувати результати
	public void printRes(int num) {
		switch (num)
		{
		 	case 1:
				System.out.println(" _____\n|     |\n|  *  |\n|_____|");
				break;
		 	case 2:
		 		System.out.println(" _____\n|*    |\n|     |\n|____*|");
		 		break;
			case 3:
				System.out.println(" _____\n|*    |\n|  *  |\n|____*|");
				break;
			case 4:
		    		System.out.println(" _____\n|*   *|\n|     |\n|*___*|");
		    		break;
		    	case 5:
		    		System.out.println(" _____\n|*   *|\n|  *  |\n|*___*|");
		    		break;
		    	case 6:
		    		System.out.println(" _____\n| * * |\n| * * |\n|_*_*_|");
		    		break;
		}	
	}
	
	// в класі Game прописуємо метод обрахунок середньої суми
	public double  average(int sum) {
		return (double)sum/5;
	}
	
	
	public static void main (String [] arg){
		Game newG = new Game();	
		System.out.println("ИГРА - КОСТИ \n");
		System.out.println("Введите, кто бросает первым:\n1 - игрок\n2 - компьютер");
		
		scan = new Scanner(System.in);
		int whoFirst = scan.nextInt();
		
		if (whoFirst == 1) {
			newG.gamer1Name = "игрок";
			newG.gamer2Name = "компьютер";
		}
		else {
			newG.gamer1Name = "компьютер";
			newG.gamer2Name = "игрок";
		}
		

		
		System.out.println();
		for (int i=1; i<6; i++){  		//Цикл кидків
			scan.nextLine();
			System.out.println("Бросок №"+i);
			System.out.println("\nБросает "+newG.gamer1Name);
			int drop = newG.drop();
			newG.gamer1Sum = newG.gamer1Sum+drop;
			newG.printRes(drop);
			
			System.out.println("\nБросает "+newG.gamer2Name);
			drop = newG.drop();
			newG.printRes(drop);
			newG.gamer2Sum = newG.gamer2Sum+drop;
			
			System.out.println();
			if (i<5) System.out.println("Для продолжения нажмите 'ввод' \n");
		}
		
		System.out.println(newG.gamer1Name+" набрал "+newG.gamer1Sum);
		System.out.println(newG.gamer2Name+" набрал "+newG.gamer2Sum);
		
		
		
		
		System.out.println();
		if (newG.gamer1Sum > newG.gamer2Sum) System.out.println("!!!Победил "+newG.gamer1Name+"!!!\n");
		else if (newG.gamer1Sum < newG.gamer2Sum) System.out.println("!!!Победил "+newG.gamer2Name+"!!!\n");
		else System.out.println("Победила дружба! :)\n");
		
		System.out.println(newG.gamer1Name+": средняя сумма по броскам = "+newG.average(newG.gamer1Sum));
		System.out.println(newG.gamer2Name+": средняя сумма по броскам = "+newG.average(newG.gamer2Sum));
	}

}
