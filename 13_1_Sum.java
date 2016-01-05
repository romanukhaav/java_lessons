package lesson13;
/* Посчитать сумму двух чисел и записать в третье.
 * (Используя Generics, классы-обертки и обработку ошибок)*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Sum extends JFrame {
	private static final long serialVersionUID = 1L; // ще не розумію навіщо то

	private void updateCounter() {
	   countLabel.setText("  Результат = "+result);
	}
	
    private Integer result = 0;
	private JLabel countLabel;
	private JButton addNum;
	private TextField num1;
	private TextField num2;
	
	public <T> Sum(){
	    super("Сумма двух чисел");
	    
	    //Подготавливаем компоненты объекта
	    countLabel = new JLabel("  ");
	    addNum = new JButton("Add");
	    num1 = new TextField("Введите первое число", 15);
	    num2 = new TextField("Введите второе число", 15);

	    //Подготавливаем временные компоненты
	    JPanel buttonsPanel = new JPanel(new FlowLayout());
	    
	    //Расставляем компоненты по местам
	    add(num1, BorderLayout.NORTH);
	    add(num2, BorderLayout.CENTER);
	    buttonsPanel.add(addNum);
	    buttonsPanel.add(countLabel);
	    
	    add(buttonsPanel, BorderLayout.SOUTH);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	
	    // добавляем слушатель кнопки и обработчик события
	    addNum.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  try{
	    		  result = Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText());
	    		  updateCounter(); //Сообщаем приложению результат
    		  }
    		  catch(Exception err) {
    			  countLabel.setText("  Ошибка! введите числа");
    		  }
    	  }
    	});
     
	}
	  
	public static void main (String[] args) {
		Sum app = new Sum();
	    app.setVisible(true);
	    app.setSize(300,130);
	  }
}
