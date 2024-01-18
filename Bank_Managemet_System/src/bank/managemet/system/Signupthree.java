
package bank.managemet.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Signupthree   extends JFrame  implements  ActionListener{
        
            JRadioButton r1,r2,r3,r4;
            JCheckBox c1,c2,c3,c4,c5,c6,c7;
            JButton submit,cancel;
            String formno;
         Signupthree( String formno) {
             this.formno=formno;
             setLayout(null);
             
         setSize(850,820);
        setLocation(350,0);
        setVisible(true);
             
        JLabel l1=new JLabel("Page 3: Account Details ");
        l1.setFont(new Font("Releway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
       
               
        JLabel type=new JLabel("Account Type ");
        type.setFont(new Font("Releway",Font.BOLD,22));
        type.setBounds(100,100,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Accouont");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,150,250,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Accouont");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,150,250,20);
        add(r2);
       
        r3=new JRadioButton("Current Accouont");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,190,250,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Accouont");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,190,250,20);
        add(r4);
        
        ButtonGroup groupaccount=new  ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
                 
        JLabel card =new JLabel("Card Number ");
        card.setFont(new Font("Releway",Font.BOLD,22));
        card.setBounds(100,220,200,30);
        add(card);
        
         JLabel number =new JLabel("xxxx-xxxx-xxxx-4104");
        number.setFont(new Font("Releway",Font.BOLD,22));
        number.setBounds(330,220,300,30);
        add(number);
        
        
         JLabel carddetail =new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Releway",Font.BOLD,12));
        carddetail.setBounds(100,250,300,20);
        add(carddetail);
        
                  
        JLabel pin =new JLabel("Pin Number ");
        pin.setFont(new Font("Releway",Font.BOLD,22));
        pin.setBounds(100,300,200,30);
        add(pin);
        
         JLabel pnumber =new JLabel("xxxx");
        pnumber.setFont(new Font("Releway",Font.BOLD,22));
        pnumber.setBounds(330,300,300,30);
        add(pnumber);
        
         JLabel password =new JLabel("Your 4 Digit Card Password");
        password.setFont(new Font("Releway",Font.BOLD,12));
        password.setBounds(100,330,300,20);
        add(password);
        
        
        JLabel services=new JLabel("Services Required: ");
        services.setFont(new Font("Releway",Font.BOLD,22));
        services.setBounds(100,360,200,30);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,400,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,400,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,450,200,30);
        add(c3);
        
        c4=new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,450,200,30);
        add(c4);
        
        c5=new JCheckBox("Check Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,490,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,490,200,30);
        add(c6);
        
        c7=new JCheckBox("i hereby declared that the above enterd details are correct to the best of Knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,540,520,30);
        add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(150,600,100,30);
        submit.addActionListener(this);
         add(submit);
             
              cancel =new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(390,600,100,30);
        cancel.addActionListener(this);
             add(cancel);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String accountType =null;
            if(r1.isSelected())
            {
                accountType = "Saving Account";
            }
            else if (r2.isSelected())
            {
                accountType = "Fixed Deposit Account"; 
            }
            else if(r3.isSelected())
            {
                accountType ="Current Account";
            }
             else if(r4.isSelected())
            {
                accountType ="Reccuring Degit Account ";
            }
             
           Random random=new Random();
           String cardnumber= ""+Math.abs((random.nextLong()%90000000L)+504093600000000L);
           String pinnumber=""+Math.abs((random.nextLong()%9000L) +1000L);
           String facility="";
           if(c1.isSelected())
           {
               facility=facility+"ATM Card";
           }
           else if(c2.isSelected())
           {
               facility=facility+"Internet Banking";
           }
            else if(c3.isSelected())
           {
               facility=facility+"Mobile Banking";
           }
            else if(c4.isSelected())
           {
               facility=facility+" Email & SMS Alert";
           }
            else if(c5.isSelected())
           {
               facility=facility+"check Book";
           }
            else if(c6.isSelected())
           {
               facility=facility+"E-Statement";
           }
            try {
                if(accountType.equals(""))
                {
                JOptionPane.showMessageDialog(null,"Account Type is required");
                }
                else{
                    Conn conn=new Conn();
                    String query1="insert into singupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                     String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";   
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                            
                       JOptionPane.showMessageDialog(null,"Card number :" + cardnumber+ "\n  Pin: " +pinnumber );
                       
                       setVisible(false);
                       new Deposit(pinnumber).setVisible(false);
                        
                }
            } catch (Exception e) {
                System.out.println(e);
            }
           
        }
        else if (ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
        public static void main(String[] args) {
       new Signupthree("");
    }
}
