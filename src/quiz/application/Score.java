package quiz.application;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener {
    
    Score(String name,int score){
    
        setBounds(20,20,1220,650);
    getContentPane().setBackground(Color.BLACK);
    setLayout(null);
   
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/Score.jpeg"));  
        Image i2=i1.getImage().getScaledInstance(500,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(-150, 20,1000, 250);
        add(image);  
        
        JLabel lblscore =new JLabel("ThankYou " + name + " For Playing This Quiz.");
        lblscore.setBounds(100,200,800,300);
        lblscore.setFont(new Font("Mongolian BaitiFont",Font.BOLD,26));
        add(lblscore);
        
        JLabel heading =new JLabel("Your Score is " + score);
        heading.setBounds(100,250,500,300);
        heading.setFont(new Font("Mongolian BaitiFont",Font.BOLD,26));
        add(heading);
        
        JButton again=new JButton("Play Again");
        again.setBounds(100,450,150,40);
        again.setBackground(Color.BLACK);
        again.setForeground(Color.WHITE);
        again.setFont(new Font("Tahoma",Font.PLAIN,18));
        again.addActionListener(this);
        add(again);
        
        
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new Score("User",0);
    }
}
