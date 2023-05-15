package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener {
    
    String name;
    JButton back,start;
    Rules(String name) {
        
        this.name=name;
     
        setBounds(20,20,1220,650);
    getContentPane().setBackground(Color.red);
    setLayout(null);
    
        JLabel heading=new JLabel("Welcome "+name+" to DIU Quiz Application, Read All the Rules Carefully And Attend The Quiz.Good Luck!");
        heading.setBounds(50, 40, 1100, 30);
        heading.setFont(new Font("Mongolian BaitiFont",Font.BOLD,20));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        JLabel rules=new JLabel("");
        rules.setBounds(50, 35, 950, 600);
        rules.setFont(new Font("Mongolian BaitiFont",Font.PLAIN,16));
        rules.setForeground(Color.WHITE);
        rules.setText(
            "<html>"+ 
                "1 Users should read the instructions and guidelines for the quiz carefully before starting the quiz." + "<br><br>" +
                "2 Users should answer all questions to the best of their ability, as incomplete answers may result in a lower score." + "<br><br>" +
                "3 Users should complete the quiz within the designated time limit." + "<br><br>" +
                "4 Users should not refresh or leave the quiz page during the quiz, as it may cause the quiz to malfunction and result in an incomplete score." + "<br><br>" +
                "5 Users should not use external resources, such as search engines or textbooks, to answer quiz questions." + "<br><br>" +
                "6 Users should keep their personal information, such as name and contact details, secure and not share it with others on the quiz application." + "<br><br>" +
                "7 Users should not impersonate other users or quiz administrators on the quiz application." + "<br><br>" +
                "8 Users should not use or reproduce any copyrighted or trademarked materials in the quiz without proper permission. Good Luck" + "<br><br>" +
            "<html>"
);
        add(rules);
        
        back=new JButton("Back");
        back.setBounds(50,550,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start=new JButton("Start");
        start.setBounds(200,550,100,30);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
      
    setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
        if (ae.getSource()==start){
            setVisible(false);
   new Quiz(name);
    }  
        else if (ae.getSource()== back){
        
        setVisible(false);
        new Login();
    }
    
    }
    
    public static void main(String[] args) {
        
        new Rules("User");
    }
    
}
