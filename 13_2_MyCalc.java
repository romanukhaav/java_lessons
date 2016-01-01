package lesson13;

/*Написать примитивный калькулятор.
 * (для примитивного достаточно целых чисел - дробовые леньки доделывать :) ) 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyCalc extends JFrame {
private static final long serialVersionUID = 1L;

  private String result = "0";
  private boolean newNumLable = true; //готовность для ввода нового числа
  boolean getResulAgain = false; //произвести повторно последнюю операцию при повторном нажатии "="
  private Integer x1, x2, operation;
  
  private TextField textArea = new TextField(result, 30);
  
  private JButton addNum      = new JButton("+");
  private JButton subtractNum = new JButton("-");
  private JButton multiplyNum = new JButton("*");
  private JButton divideNum   = new JButton("/");
  private JButton getResult   = new JButton("=");
  private JButton removeNum   = new JButton("C");
  
  private JButton oneNum   = new JButton("1");
  private JButton twoNum   = new JButton("2");
  private JButton threNum  = new JButton("3");
  private JButton fourNum  = new JButton("4");
  private JButton fiveNum  = new JButton("5");
  private JButton sixNum   = new JButton("6");
  private JButton sevenNum = new JButton("7");
  private JButton eightNum = new JButton("8");
  private JButton nineNum  = new JButton("9");
  private JButton zerroNum = new JButton("0");
  

  private void updateCounter() {
  	  //countLabel.setText("= " + result);
  	  textArea.setText(result);
  	}
  
  public MyCalc(){
    super("My calculator");

    //Подготавливаем временные компоненты
    JPanel buttonsPanel = new JPanel(new FlowLayout());
    JPanel numsPanel = new JPanel(new GridLayout(5,3,5,5));
    
    //Расставляем компоненты по местам
    add(textArea, BorderLayout.NORTH);
    numsPanel.add( oneNum);
    numsPanel.add( twoNum);
    numsPanel.add(threNum);
    numsPanel.add(fourNum);
    numsPanel.add(fiveNum);
    numsPanel.add(sixNum);
    numsPanel.add(sevenNum);
    numsPanel.add(eightNum);
    numsPanel.add(nineNum);
    numsPanel.add(zerroNum);
    numsPanel.add(removeNum);
    
    buttonsPanel.add(addNum);
    buttonsPanel.add(subtractNum);
    buttonsPanel.add(multiplyNum);
    buttonsPanel.add(divideNum);
    buttonsPanel.add(getResult);
    

    add(numsPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.PAGE_END);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    
    oneNum.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
  		  if (newNumLable == true) result = "";
  		  result = result+1;     //Добавляем символ
  		  updateCounter(); //Сообщаем приложению, что число изменилось
  		  newNumLable = false;
  	  }
  	});
    
    twoNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  if (newNumLable == true) result = "";
    		  result = result+2;     //Добавляем символ
    		  updateCounter(); //Сообщаем приложению, что число изменилось
    		  newNumLable = false;
    	  }
    });
    
    threNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  if (newNumLable == true) result = "";
    		  result = result+3;     //Добавляем символ
    		  updateCounter(); //Сообщаем приложению, что число изменилось
    		  newNumLable = false;
    	  }
    });
      
    fourNum.addActionListener(new ActionListener(){
      	  public void actionPerformed(ActionEvent e) {
      		  if (newNumLable == true) result = "";
      		  result = result+4;     //Добавляем символ
      		  updateCounter(); //Сообщаем приложению, что число изменилось
      		  newNumLable = false;
      	  }
    });
      
    fiveNum.addActionListener(new ActionListener(){
      	  public void actionPerformed(ActionEvent e) {
      		  if (newNumLable == true) result = "";
      		  result = result+5;     //Добавляем символ
      		  updateCounter(); //Сообщаем приложению, что число изменилось
      		  newNumLable = false;
      	  }
    });
        
    sixNum.addActionListener(new ActionListener(){
       	  public void actionPerformed(ActionEvent e) {
       		  if (newNumLable == true) result = "";
       		  result = result+6;     //Добавляем символ
       		  updateCounter(); //Сообщаем приложению, что число изменилось
       		  newNumLable = false;
       	  }
    });
           
    sevenNum.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
        	 if (newNumLable == true) result = "";
        	 result = result+7;     //Добавляем символ
        	 updateCounter(); //Сообщаем приложению, что число изменилось
        	 newNumLable = false;
       	  }
    });
          
    eightNum.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		if (newNumLable == true) result = "";
    		result = result+8;     //Добавляем символ
    		updateCounter(); //Сообщаем приложению, что число изменилось
    		newNumLable = false;
    	}
    });
    
    nineNum.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
  		  if (newNumLable == true) result = "";
  		  result = result+9;     //Добавляем символ
  		  updateCounter(); //Сообщаем приложению, что число изменилось
  		  newNumLable = false;
  	  }
  	});
          
    zerroNum.addActionListener(new ActionListener(){
          	  public void actionPerformed(ActionEvent e) {
          		  if (newNumLable == true) result = "";
          		  result = result+0;     //Добавляем символ
          		  updateCounter(); //Сообщаем приложению, что число изменилось
          	  }
          	});
            
    addNum.addActionListener(new ActionListener(){ //операция суммирования
    	  public void actionPerformed(ActionEvent e) {
    		  x1=Integer.valueOf(result);
    		  result = "?";
    		  operation = 1;
    		  updateCounter(); //Сообщаем приложению, что число изменилось
    		  getResulAgain = false; //переменная укажет что операция задается впервые
    		  newNumLable = true; //готовность для ввода нового числа
    	  }
    	});
    
    subtractNum.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
		  x1=Integer.valueOf(result);
		  result = "?";
		  operation = 2;
		  updateCounter(); //Сообщаем приложению, что число изменилось
		  getResulAgain = false;
		  newNumLable = true;
	  }
	});
    
    multiplyNum.addActionListener(new ActionListener(){
    	 public void actionPerformed(ActionEvent e) {
   		  x1=Integer.valueOf(result);
   		  result = "?";
   		  operation = 3;
   		  updateCounter(); //Сообщаем приложению, что число изменилось
   		  getResulAgain = false;
   		  newNumLable = true;
   	  }
   	});
    
    divideNum.addActionListener(new ActionListener(){
   	 public void actionPerformed(ActionEvent e) {
  		  x1=Integer.valueOf(result);
  		  result = "?";
  		  operation = 4;
  		  updateCounter(); //Сообщаем приложению, что число изменилось
  		  getResulAgain = false;
  		  newNumLable = true;
  	  }
  	});
    
    removeNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    	      	result = "0"; //уничтожаем запись о числе
    	      	operation = 0; //уничторжаем запись о операции
    	      	newNumLable = true; //готовность принять новое число
    	      	getResulAgain = false; 
    	    	updateCounter();
    	  }
    	});
    
    getResult.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {  		  
  		  if (getResulAgain == true){ //цыкл для повторной обработки последей операции
  	  		 x1=Integer.valueOf(result); 
  		  }
  		  else {
	  		  x2=Integer.valueOf(result);
  		  }
  		  switch (operation){
			  case 1:
				result = Integer.toString(x1+x2);
				break;
			  case 2:
				result = Integer.toString(x1-x2);
				break;
			  case 3:
				result = Integer.toString(x1*x2);
				break;
			  case 4:
				result = Integer.toString(x1/x2);
				break;
  		  }
  		 updateCounter(); //Сообщаем приложению, что количество изменилось
  		 newNumLable = true;
  		 getResulAgain= true; //готовность произвести повторно последне вычисление
  	  }
  	});
}

public static void main(String[] args) {
	MyCalc app = new MyCalc();
    app.setVisible(true);
    app.pack(); //Эта команда подбирает оптимальный размер в зависимости от содержимого окна
  }
}
