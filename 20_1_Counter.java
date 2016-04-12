package lesson20;

/* Цифровой счетчик, это переменная с ограниченным диапазоном.
 * Значение которой сбрасывается, когда ее целочисленное значение достигает 
 * определенного максимума (например, k принимает значения в диапазоне от 0..100).
 * В качестве примера такого счетчика можно привести цифровые часы, счетчик километража.
 * Опишите класс такого счетчика. Обеспечьте возможность установления максимального
 * и минимального значений, увелечения счетчика на 1, возвращения текущего значения. 
 */

public class Counter {
	
	private int Value, Min, Max;
	
	public static void main(String[] arg){
		
		Counter myCount = new Counter();
		System.out.println(myCount);
		myCount.getValue();
		myCount.addOne();
		myCount.getValue();
		myCount.addOne();
		myCount.getValue();
		System.out.println(myCount);
		System.out.println("Максимум ставим = 3\n");
		myCount.setMax(3);
		myCount.addOne();
		myCount.addOne();
		System.out.println(myCount);
		
	}
	
	public Counter(){
		setMin(0);
		setMax(10);
		this.Value=0;
	}  
	
	public Counter(int Min, int Max){
		setMin(Min);
		setMax(Max);
		this.Value=0;		
	}
	
	public void setMax(int num){
		this.Max=num;
	}
	
	public void setMin(int num){
		this.Min=num;
	}
	
	public int getValue(){
		return this.Value;
	}
	
	public void addOne(){
		System.out.println("Добавляем единицу");
		this.Value++;
		if(this.Value>=this.Max) {
			this.Value=this.Min;
			System.out.println("Вы достигли наибольшего значения, счетчик обнуляется " + getValue() );
		}
	}

	public void reduseOne(){
		this.Value--;
		if(this.Value<=this.Min) { 
			this.Value=this.Min;
			System.out.println("Вы достигли наименшего значения," + getValue() + " дальнейшее уменьшение невозможно");
		}
	}
	
	public String toString(){
		return    "\nСчетчик: "
				+ "\nзначение = "+getValue()
				+ "\nминимум = " + this.Min
				+ "\nмаксимум = "	+ this.Max
				+"\n--------------------\n";
	}
}
