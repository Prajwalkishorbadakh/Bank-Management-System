
package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Withdrawl extends JFrame implements  ActionListener{
    
    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    Withdrawl(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
              image.setBounds(0,0,800,800);
              add(image);
              
              JLabel text=new JLabel("Enter the Amount you want to Withdrawl");
              text.setForeground(Color.white);
              text.setFont(new Font("System",Font.BOLD,16));
              text.setBounds(155,250,500,35);
              image.add(text);
              
               amount =new JTextField();
              amount.setFont(new Font("relaway",Font.BOLD,22));
              amount.setBounds(145,300,300,25);
              image.add(amount);
              
               withdrawl=new JButton("Withdraw");
              withdrawl.setBounds(300,434,140,25);
              withdrawl.addActionListener(this);
              image.add(withdrawl);
              
                back=new JButton("Back");
              back.setBounds(300,465,140,25);
                 back.addActionListener(this);
              image.add(back);
              
        
    setSize(800,800);
    setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==withdrawl)
        {
              String number=amount.getText();
              Date  date=new Date();
              if(number.equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Please enter the amount you to withdrawl ");
              }
              else
              {
                  try {
                        Conn conn=new Conn();
                        String qurey="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                        conn.s.executeUpdate(qurey);
                         JOptionPane.showMessageDialog(null,"RS " + number + " Withdrawl Succesfully" );
                         setVisible(false);
                         new Transactions(pinnumber).setVisible(true);
                  } catch (Exception e) {
                      System.out.println(e);
                  }
              }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
