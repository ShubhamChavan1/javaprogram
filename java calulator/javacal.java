import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class javacal implements ActionListener {
  
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functiButtons = new JButton[8];
    JButton addButton,subButton,mulButton;
    JButton divButton,equButton,decButton;
    JButton delButton,clrButton;
    JPanel panel;
     
    Font myFont = new Font("Ink free",Font.ITALIC,30);
    double num1=0,num2=0,result=0;
    char operator;

    javacal(){
       
        frame = new JFrame("java calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(50, 25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        equButton = new JButton("=");
        decButton = new JButton(".");
        clrButton = new JButton("clear");
        delButton = new JButton("delete");


        functiButtons[0] = addButton;
        functiButtons[1] = subButton;
        functiButtons[2] = divButton;
        functiButtons[3] = mulButton;
        functiButtons[4] = equButton;
        functiButtons[5] = decButton;
        functiButtons[6] = clrButton;
        functiButtons[7] = delButton;

        for(int i = 0; i<8 ; i++){
            functiButtons[i].addActionListener(this);
            functiButtons[i].setFont(myFont);
            functiButtons[i].setFocusable(false);
        }

        for(int i =0;i<10;i++){
            numberButtons[i] = new JButton (String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430 , 145, 50);
        clrButton.setBounds(205,430,145,50);

        panel =new JPanel(); 
        panel.setBounds(50,100,300,300 );
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        ImageIcon myImageIcon = new ImageIcon("cal.png");
        frame.setIconImage(myImageIcon.getImage()); 
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
  
     }  
  
    public static void main(String[] args) {
        
        
        javacal cal = new javacal();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }    
        }
            if(e.getSource() == decButton){
                textField.setText(textField.getText().concat("."));
            }

            if(e.getSource() == addButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='+';
                textField.setText("");
            }

            if(e.getSource() == subButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='-';
                textField.setText(" ");
            }

            if(e.getSource() == divButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='/';
                textField.setText(" ");
            }

            if(e.getSource() == mulButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='*';
                textField.setText(" ");
            }

            if(e.getSource() == equButton){
                num2 = Double.parseDouble(textField.getText());
        
            switch (operator) {
                case '+':
                   result=num1+num2;
                   break;
                case '-' :
                   result=num1 - num2;
                   break;
                case '*':
                    result=num1*num2; 
                    break;
                case '/':
                    result= num1/num2;
                    break;        
            }
            textField.setText(String.valueOf(result));
            num1=result;
       }   
       if(e.getSource()==clrButton){
        textField.setText("");
       }

       if(e.getSource()==delButton){
        String calstring = textField.getText();
        textField.setText("");
        for(int i = 0; i<calstring.length()-1;i++){
             textField.setText(textField.getText()+calstring.charAt(i));
        }
       }
    }
}
