package lesson20;

import java.util.Date;

public class Student {

	
	private int stId, stAge, stAvgMark; //ID, возраст, средняя оценка студента
	
	public int getStAge() {
		return stAge;
	}
	public void setStAge(int stAge) {
		this.stAge = stAge;
	}

	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}

	public int getStAvgMark() {
		return stAvgMark;
	}
	public void setStAvgMark(int stAvgMark) {
		this.stAvgMark = stAvgMark;
	}
	
	private String stName; //имя студента
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	
	private Group group; //группа студента
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	private Date stEntryDate; //дата поступления

	public String toString(){  //переписываем вывод
		return "\nПривет я " + this.getStName()
				+", мне " + this.getStAge() + " лет."
				+"\nЯ учусь в группе " + this.getGroup().getGrName()
				+", мой ID = "+ this.getStId();	
	}	
	
	//инициализатор
	{
		System.out.println("Встречайте - у нас новый студент!");	
	}
	
	public Student(String name, int age, Group gr) {
		this.stName = name;
		this.stAge = age;
		this.group = gr;
		this.stEntryDate = new Date(System.currentTimeMillis());
		this.stId = gr.getStCount().getValue();
		this.stAvgMark = 0;
		this.group.getStCount().addOne();//плюсуем одного студента к счетчику группы
		this.group.getStList().add(this); //вносим студента в ArrayList группы
	}
	
}
