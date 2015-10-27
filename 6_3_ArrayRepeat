package lesson6;

//Написать программу, которая находит в массиве значения, повторяющиеся 
//два и более раз, и показывает их на экран.


public class ArrayRepeat {
	public static void main(String[] args){
		int masiv [] = {1,1,15,6,2,3,2,21,4,9,2,2,4,5,1,5,9,11};
		
		for(int i=0; i<masiv.length; i++){
			int test=0;
			for(int j=i+1; j<masiv.length; j++){
				if (masiv[i]==masiv[j]){
					test=1;
				}
				else{continue;}	
			}
			if (test==1) {System.out.print(masiv[i]+" ");}	
		}
	}
}
