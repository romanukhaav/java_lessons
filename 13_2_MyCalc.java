package lesson13;

/*Написать примитивный калькулятор.*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyCalc extends JFrame {
private static final long serialVersionUID = 1L;

  private String result = "";
  private Integer x1, x2, operation;
  
  private JLabel countLabel = new JLabel("= " + result);
  
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
  	  countLabel.setText("= " + result);
  	}
  
  public MyCalc(){
    super("My calculator");

    //Подготавливаем временные компоненты
    JPanel buttonsPanel = new JPanel(new FlowLayout());
    JPanel numsPanel = new JPanel(new FlowLayout());
    
    //Расставляем компоненты по местам
    add(countLabel, BorderLayout.NORTH); 
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
    
    buttonsPanel.add(addNum);
    buttonsPanel.add(subtractNum);
    buttonsPanel.add(multiplyNum);
    buttonsPanel.add(divideNum);
    buttonsPanel.add(getResult);
    buttonsPanel.add(removeNum);

    add(numsPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.PAGE_END);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    
    oneNum.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
  		  result = result+1;     //Добавляем символ
  		  updateCounter(); //Сообщаем приложению, что количество изменилось
  	  }
  	});
    
    twoNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  result = result+2;     //Добавляем символ
    		  updateCounter(); //Сообщаем приложению, что количество изменилось
    	  }
    });
    
    threNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  result = result+3;     //Добавляем символ
    		  updateCounter(); //Сообщаем приложению, что количество изменилось
    	  }
    });
      
    fourNum.addActionListener(new ActionListener(){
      	  public void actionPerformed(ActionEvent e) {
      		  result = result+4;     //Добавляем символ
      		  updateCounter(); //Сообщаем приложению, что количество изменилось
      	  }
    });
      
    fiveNum.addActionListener(new ActionListener(){
      	  public void actionPerformed(ActionEvent e) {
      		  result = result+5;     //Добавляем символ
      		  updateCounter(); //Сообщаем приложению, что количество изменилось
      	  }
    });
        
    sixNum.addActionListener(new ActionListener(){
       	  public void actionPerformed(ActionEvent e) {
       		  result = result+6;     //Добавляем символ
       		  updateCounter(); //Сообщаем приложению, что количество изменилось
       	  }
    });
    /*oneNum twoNum threNum  fourNum  fiveNum  sixNum   sevenNum eightNum nineNum  zerroNum*/
           
    sevenNum.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
        	 result = result+7;     //Добавляем символ
        	 updateCounter(); //Сообщаем приложению, что количество изменилось
       	  }
    });
          
    eightNum.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
       	  result = result+8;     //Добавляем символ
       	  updateCounter(); //Сообщаем приложению, что количество изменилось
    	}
    });
    
    nineNum.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
  		  result = result+9;     //Добавляем символ
  		  updateCounter(); //Сообщаем приложению, что количество изменилось
  	  }
  	});
          
    zerroNum.addActionListener(new ActionListener(){
          	  public void actionPerformed(ActionEvent e) {
          		  result = result+0;     //Добавляем символ
          		  updateCounter(); //Сообщаем приложению, что количество изменилось
          	  }
          	});
            
    addNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  x1=Integer.valueOf(result);
    		  result = "";
    		  operation = 1;
    		  updateCounter(); //Сообщаем приложению, что количество изменилось
    	  }
    	});
    
    subtractNum.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
		  x1=Integer.valueOf(result);
		  result = "";
		  operation = 2;
		  updateCounter(); //Сообщаем приложению, что количество изменилось
	  }
	});
    
    multiplyNum.addActionListener(new ActionListener(){
    	 public void actionPerformed(ActionEvent e) {
   		  x1=Integer.valueOf(result);
   		  result = "";
   		  operation = 3;
   		  updateCounter(); //Сообщаем приложению, что количество изменилось
   	  }
   	});
    
    divideNum.addActionListener(new ActionListener(){
   	 public void actionPerformed(ActionEvent e) {
  		  x1=Integer.valueOf(result);
  		  result = "";
  		  operation = 4;
  		  updateCounter(); //Сообщаем приложению, что количество изменилось
  	  }
  	});
    
    removeNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    	      	result = ""; //уничтожаем запись о числе
    	    	updateCounter(); 
    	  }
    	});
    
    getResult.addActionListener(new ActionListener(){
  	  public void actionPerformed(ActionEvent e) {
  		  x2=Integer.valueOf(result);
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
  	  }
  	});
}

public static void main(String[] args) {
	MyCalc app = new MyCalc();
    app.setVisible(true);
    app.pack(); //Эта команда подбирает оптимальный размер в зависимости от содержимого окна
  }
}

/* Доробити:
 *  1) введення відємних чисел
 * 	2) параметри вікна калькулятора по замовчуванню
 *  3) робота з дробовими числами
 */		
