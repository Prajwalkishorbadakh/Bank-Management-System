
package bank.managemet.system;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements  ActionListener {
 
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,exit;
       String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
       
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,800,800);
         add(image);
        
         
         JLabel text=new JLabel("Please Select your Transaction");
         text.setBounds(165,280,500,35);
         text.setFont(new Font("System",Font.BOLD,18));
         text.setForeground(Color.white);
        image. add(text);
        
         deposit=new JButton("Deposit");
        deposit.setBounds(150,370,140,25);
        deposit.addActionListener(this);
        image. add(deposit);
        
          withdrawl=new JButton(" Cash Withdrawl");
        withdrawl.setBounds(300,370,140,25);
         withdrawl.addActionListener(this);
        image. add(withdrawl);
        
           fastcash=new JButton("Fast Cash");
        fastcash.setBounds(150,402,140,25);
         fastcash.addActionListener(this);
        image. add(fastcash);
        
           ministatement=new JButton("  Mini statement");
        ministatement.setBounds(300,402,140,25);
         ministatement.addActionListener(this);
        image. add(ministatement);
        
           pinchange=new JButton("Pin change");
        pinchange.setBounds(150,434,140,25);
        pinchange.addActionListener(this);
        image. add(pinchange);
        
         balance=new JButton("  Balance Enquiry");
        balance.setBounds(300,434,140,25);
        balance.addActionListener(this);
        image. add(balance);
        
           exit=new JButton("Exit");
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
    System.exit(0);
    }
    else if(ae.getSource()==deposit)
    {
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
        
    }
    else if(ae.getSource()==withdrawl)
    {
        setVisible(false);
        new Withdrawl(pinnumber).setVisible(true);
    }
    else if( ae.getSource()==fastcash)
    {
        setVisible(false);
        new  Fastcash(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==pinchange)
    {
        setVisible(false);
        new Pinchange(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==balance)
    {
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==ministatement)
            {
                setVisible(false);
                new Ministatement(pinnumber).setVisible(true);
            }
    }
    public static void main(String[] args) {
        
        new Transactions("");
    }
    

}
