package softServ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/* Create classes Polygon, Triangle and Square with method for setting visibility (invisibility)
and method for calculating of perimeter. Give your suggestions about relations 
between classes (is-a, has-a, use-a, etc.). Find solution for avoiding of duplicate code.
Write well commented code with examples of using these classes.
	Write code for reading and writing collection of these objects from (into) file.
	Find object with maximal perimeter.
	The object with maximal perimeter set as invisible.
	Write code for handling the incorrect format of incoming file. */

public abstract class Polygon implements Serializable{
	
	public ArrayList <Integer> sides;
	public boolean isVisible = true;
	public void setVisible(){
		this.isVisible=true;
	}
	public void setInVisible(){
		this.isVisible=false;
	}
	
	public int perimeter(){
		int res =0;
		for (int i = 0; i<this.sides.size(); i++){
			res+=this.sides.get(i);
		}
		return res;
	}

	private static ArrayList <Polygon> polygonsArr = new ArrayList <Polygon>();
	
	/** @return the polygonsArr	 */
	public static ArrayList <Polygon> getPolygonsArr() {
		return polygonsArr;
	}

	/** @param polygonsArr the polygonsArr to set  */
	public static void setPolygonsArr(ArrayList <Polygon> polygonsArr) {
		Polygon.polygonsArr = polygonsArr;
	}
	
	
	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i<this.sides.size(); i++){
			if (this.isVisible==true){
				res+=" "+this.sides.get(i);
			}
		}
		return res;
	}
	
	
	
	public static class Triangle extends Polygon{
		
		Triangle(Integer a, Integer b, Integer c){
			this.sides = new ArrayList <Integer>(3);
			this.sides.add(a);
			this.sides.add(b);
			this.sides.add(c);
			super.getPolygonsArr().add(this);
		} 
	}

	public static class Square extends Polygon {
	
		Square(int a, int b, int c, int d){
			this.sides = new ArrayList <Integer>(4);
			this.sides.add(a);
			this.sides.add(b);
			this.sides.add(c);
			this.sides.add(d);
			super.getPolygonsArr().add(this);
		}
		
	}
	
	public static void main(String arg[]) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		Triangle triang1 = new Triangle(2,15,8);
		System.out.println(triang1.perimeter());
		
		Square squar1 = new Square(2,3,4,3);
		System.out.println(squar1.perimeter());
		
		Square squar2 = new Square(2,10,10,9);
		System.out.println(squar2.perimeter());
		
		Triangle triang3 = new Triangle(1,3,1);
		System.out.println(triang3.perimeter());
		
		System.out.println(Polygon.getPolygonsArr());
	
	//Вивід многокутника з найбільшим периметром
		Polygon max = Polygon.getPolygonsArr().get(0);
		for (Polygon i: Polygon.getPolygonsArr()){
			if (i.perimeter()>=max.perimeter()) max=i;
		}
		System.out.println("Многокутник з найбільшим периметром = "+max);
		max.setInVisible(); //робимо многокутник невидимим
		System.out.println(Polygon.getPolygonsArr());
				
		//создание цепи потоков с потоком вывода объекта в конце
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.dat"));
		out.writeObject(Polygon.getPolygonsArr());
		out.close();
		
		//зчитування об'єкту з файлу
		ObjectInputStream in =  new ObjectInputStream (new FileInputStream("objects.dat"));
		ArrayList <Polygon> readObject = (ArrayList )in.readObject();
		ArrayList <Polygon> readMax = readObject;
		in.close();
	
		System.out.println("\nВивід зчитаного об'єкту "+readMax);
		((Polygon) readMax.get(2)).setVisible();//робимо многокутник видимим
		System.out.println("\nВивід зчитаного об'єкту "+readMax);
	}

}
