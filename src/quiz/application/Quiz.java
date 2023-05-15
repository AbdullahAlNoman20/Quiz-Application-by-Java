package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Quiz extends JFrame implements ActionListener {
    
    String questions[][]=new String[10][5];
    String answers[][]=new String[10][2];
    String useranswers[][]=new String[10][1];
    JLabel qno,question;
    ButtonGroup groupoption;
    JRadioButton opt1,opt2,opt3,opt4;
    public static int timer=15;
    public static int ans_given =0;
    public static int count=0;
    public static int score=0;
            
    JButton next,submit;
    String name;
    
    
    
    Quiz(String name){
     this.name=name;
     
    setBounds(20,20,1220,650);
    getContentPane().setBackground(Color.red);
    setLayout(null);
   
        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("Icon/Start.png"));
        setLayout(null);
        JLabel image=new JLabel(i2);
        image.setBounds(60, 0, 1000, 250);
        add(image);  
        
        qno =new JLabel();
        qno.setBounds(150,100,50,300);
        qno.setFont(new Font("Mongolian BaitiFont",Font.BOLD,20));
        add(qno);
        
        
        question =new JLabel();
        question.setBounds(180,100,1000,300);
        question.setFont(new Font("Mongolian BaitiFont",Font.BOLD,20));
        add(question);
        
        questions[0][0] = "What is the correct way to declare a variable in Java?";
        questions[0][1] = "int x;";
        questions[0][2] = "x = 5;";
        questions[0][3] = "int x = 5;";
        questions[0][4] = "x;";

        questions[1][0] = "Which keyword is used to create an object in Java?";
        questions[1][1] = "create";
        questions[1][2] = "new";
        questions[1][3] = "object";
        questions[1][4] = "make";

        questions[2][0] = "What is the output of the following code?\n int x = 5;\n" +
"System.out.println(x++ + ++x);";
        questions[2][1] = "11";
        questions[2][2] = "12";
        questions[2][3] = "13";
        questions[2][4] = "15";

        questions[3][0] = "What is the access level of a class member with no access modifier?";
        questions[3][1] = "public";
        questions[3][2] = "private";
        questions[3][3] = "protected";
        questions[3][4] = "default (package-private)";

        questions[4][0] = "Which keyword is used to define a constant in Java?";
        questions[4][1] = "static";
        questions[4][2] = "constant";
        questions[4][3] = "final";
        questions[4][4] = "constant final";

        questions[5][0] = "What is the correct syntax for a multi-line comment in Java?";
        questions[5][1] = "/* comment */";
        questions[5][2] = "// comment //";
        questions[5][3] = "/* comment **/";
        questions[5][4] = "// comment";

        questions[6][0] = "Which of the following is NOT a primitive data type in Java?";
        questions[6][1] = "boolean";
        questions[6][2] = "byte";
        questions[6][3] = "string";
        questions[6][4] = "long";

        questions[7][0] = "Which method is called when an object is garbage collected in Java?";
        questions[7][1] = "finalize()";
        questions[7][2] = "delete()";
        questions[7][3] = "collect()";
        questions[7][4] = "clear()";

        questions[8][0] = "Which method is called when an object is created?";
        questions[8][1] = "create()";
        questions[8][2] = "start()";
        questions[8][3] = "main()";
        questions[8][4] = "constructor()";

        questions[9][0] = "What is the correct syntax to declare an array in Java?";
        questions[9][1] = "int[] array;";
        questions[9][2] = "array[] int;";
        questions[9][3] = "int array[];";
        questions[9][4] = "int array[];";
        
        answers[0][1] = "int x = 5;";
        answers[1][1] = "new";
        answers[2][1] = "13";
        answers[3][1] = "default (package-private)";
        answers[4][1] = "final";
        answers[5][1] = "/* comment */";
        answers[6][1] = "string";
        answers[7][1] = "finalize()";
        answers[8][1] = "constructor()";
        answers[9][1] = "int[] array;";
        
        opt1=new JRadioButton();
        opt1.setBounds(180,300,500,50);
        opt1.setBackground(Color.red);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);
        
        opt2=new JRadioButton();
        opt2.setBounds(180,350,500,50);
        opt2.setBackground(Color.red);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3=new JRadioButton();
        opt3.setBounds(180,400,500,50);
        opt3.setBackground(Color.red);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);
        
        opt4=new JRadioButton();
        opt4.setBounds(180,450,500,50);
        opt4.setBackground(Color.red);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);
        
        groupoption=new ButtonGroup();
        groupoption.add(opt1);
        groupoption.add(opt2);
        groupoption.add(opt3);
        groupoption.add(opt4);
        
        next=new JButton("Next");
        next.setBounds(900,370,200,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.red);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.addActionListener(this);
        add(next);
        
        
        // submit button creat
        submit=new JButton("Submit");
        submit.setBounds(900,460,200,50);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.red);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.addActionListener(this);//location
        add(submit);
        submit.setEnabled(false);// 10 number question porjonto false.
        
        
        start(count);
        
        
     setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==next){
            repaint();
           
            ans_given=1;
            if (groupoption.getSelection()==null){
              useranswers[count][0]= "";
          }
          else {
          useranswers[count][0]= groupoption.getSelection().getActionCommand();
          }
            
     
            if (count==8){
            next.setEnabled(false);
            submit.setEnabled(true);
            }
                    
                    
            count++;
            start(count);
        }  
        else if(ae.getSource()==submit){
          ans_given=1;
            if (groupoption.getSelection()==null){
              useranswers[count][0]= "";
          }
          else { //next button
          useranswers[count][0]= groupoption.getSelection().getActionCommand();
          }
              
              for (int i=0; i<useranswers.length;i++){
              
                  if(useranswers[i][0].equals(answers[i][1])){
                      score+=10;
                  }
                  else{
                  score+=0;
                  }
              }
              
              setVisible(false);
              new Score(name,score);
        }
    }

    
    
    public void paint(Graphics g){
    super.paint(g);
    
    String time = "Time left - " +timer + "seconds";// 15 seconds
    g.setColor(Color.white);
    g.setFont(new Font("Tahoma",Font.PLAIN,22));
    
    if(timer>0){
            g.drawString(time, 900, 360);
    }
    else{
    g.drawString("Times Up!!", 900, 360);
    }
          timer--;//14
          try{
              Thread.sleep(1000);
              repaint();
          }catch(Exception e){
          e.printStackTrace();
          
          }
          
          if (ans_given==1){
          ans_given=0;
          timer=15;
          }
          else if(timer<0) {
          timer=15;
          
          
          if (count==8){
            next.setEnabled(false);
            submit.setEnabled(true);
            }
          
          if (count==9){//submit 
          
              if (groupoption.getSelection()==null){
              useranswers[count][0]= "";
          }
          else { //next button
          useranswers[count][0]= groupoption.getSelection().getActionCommand();
          }
              
              for (int i=0; i<useranswers.length;i++){
              
                  if(useranswers[i][0].equals(answers[i][1])){
                      score+=10;
                  }
                  else{
                  score+=0;
                  }
              }
              
              setVisible(false);
              new Score (name,score);
              
              
          }
          else{
          
              if (groupoption.getSelection()==null){
              useranswers[count][0]= "";
          }
          else { //next button
          useranswers[count][0]= groupoption.getSelection().getActionCommand();
          }
          
          count++;
          start(count);
          }
          
          
    }
          
          
    }
    
    public void start(int count){
    
        qno.setText("" + (count + 1) + ". "); 
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoption.clearSelection();
        
    }
    
    public static void main(String[] args) {
        
        new Quiz("User");
    }
    
}
