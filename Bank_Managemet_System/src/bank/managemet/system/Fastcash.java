
package bank.managemet.system;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class Fastcash extends JFrame implements  ActionListener {
 
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,exit;
       String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
       
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,800,800);
         add(image);
        
         
         JLabel text=new JLabel("Select withdrawl amount");
         text.setBounds(165,280,500,35);
         text.setFont(new Font("System",Font.BOLD,18));
         text.setForeground(Color.white);
        image. add(text);
        
         deposit=new JButton("Rs 100");
        deposit.setBounds(150,370,140,25);
        deposit.addActionListener(this);
        image. add(deposit);
        
          withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(300,370,140,25);
         withdrawl.addActionListener(this);
        image. add(withdrawl);
        
           fastcash=new JButton("Rs 1000");
        fastcash.setBounds(150,402,140,25);
         fastcash.addActionListener(this);
        image. add(fastcash);
        
           ministatement=new JButton("Rs 2000");
        ministatement.setBounds(300,402,140,25);
         ministatement.addActionListener(this);
        image. add(ministatement);
        
           pinchange=new JButton("rs 5000");
        pinchange.setBounds(150,434,140,25);
        pinchange.addActionListener(this);
        image. add(pinchange);
        
         balance=new JButton("Rs 10000");
        balance.setBounds(300,434,140,25);
        balance.addActionListener(this);
        image. add(balance);
        
           exit=new JButton("Back");
        exit.setBounds(300,465,140,25);
         exit.addActionListener(this);
        image. add(exit);
        
            
          setSize(800,800);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
        
   
    }
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==exit)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    else 
    {
       String amount= ((JButton)ae.getSource()).getText().substring(3);//500
       Conn c =new Conn();
        try {
            ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            int balance= 0;
            
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                balance += Integer.parseInt(rs.getString("amount"));
                }else
                {
                balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if(ae.getSource()!=exit && balance < Integer.parseInt(amount))
            {
            JOptionPane.showMessageDialog(null,"Insufficient Balance");
            return;
            }
            Date date=new Date();
            String query="insert into bank values ('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Sucessfully" );
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
   
    }
    public static void main(String[] args) {
        
        new Fastcash("");
    }
    
    
}
