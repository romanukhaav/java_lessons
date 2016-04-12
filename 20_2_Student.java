package lesson20;

import java.util.Date;

public class Student {

	
	private int stId, stAge, stAvgMark;
	
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

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	private String stName;
	private Date stEntryDate;
	private Group group;
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String toString(){
		return "\nПривет я " + this.getStName()
				+", мне " + this.getStAge() + " лет."
				+"\nЯ учусь в группе " + this.getGroup().getGrName()
				+", мой ID = "+ this.getStId();
		
	}
	
	//инициализатор
	{
		
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
