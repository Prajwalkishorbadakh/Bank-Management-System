
package bank.managemet.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
       JButton login, singUp, clear;
        JTextField cardTextField;
        JPasswordField pinTextField;
    
    Login()
    {
        setTitle("Automated  Teller machine ");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
           JLabel text =new JLabel(" welcome to ATM");
           text.setFont(new Font("Osward",Font.BOLD,38));
           text.setBounds(230, 40, 450, 40);
           add(text);
           
           JLabel cardNo =new JLabel("  Card No");
           cardNo.setFont(new Font("Ralway",Font.BOLD,28));
           cardNo.setBounds(120, 140, 400, 40);
           add(cardNo);
            cardTextField=new JTextField();
           cardTextField.setBounds(300,150 ,250, 30);
           add(cardTextField);
           
           JLabel pin =new JLabel(" PIN");
           pin.setFont(new Font("Ralway",Font.BOLD,28));
           pin.setBounds(130, 210, 400, 40);
           add(pin);
            pinTextField=new JPasswordField();
            pinTextField.setBounds(300,220 ,250, 30);
           add(pinTextField);
           
           
            login=new JButton("SING IN");
           login.addActionListener(this);
           login.setBounds(300,280 ,120 ,30 );
           login.setBackground(Color.BLACK);
           login.setForeground(Color.WHITE);
           add(login);
          
           clear=new JButton("CLEAR");
           clear.addActionListener(this);
           clear.setBounds(430,280 ,120 ,30 );
          clear.setBackground(Color.BLACK);
           clear.setForeground(Color.WHITE);
           add(clear);
           
             singUp=new JButton("SING UP");
            singUp.addActionListener(this);
           singUp.setBounds(300,320 ,250 ,30 );
          singUp.setBackground(Color.BLACK);
           singUp.setForeground(Color.WHITE);
           add(singUp);
           
           
        getContentPane().setBackground(Color.white);
        
       setSize(800,400);
       setVisible(true);
       setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae)
    {
           if(ae.getSource()==clear)
           {
               cardTextField.setText("");
                pinTextField.setText("");
           }
           else if (ae.getSource()== login)
           {
               Conn conn=new Conn();
               String cardnumber=cardTextField.getText();
               String pinnumber=pinTextField.getText();
               String query ="select * from login where cardnumber='"+cardnumber+"' and pin ='"+pinnumber+"'";
               
               try {
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                JOptionPane.showMessageDialog(null, "Inccorect Card Number or Pin");
                }
                   
               } catch (Exception e) {
                   System.out.println(e);
               }
           }
           else if( ae.getSource()==singUp)
           {
               setVisible(false);
               new Signupone().setVisible(true);
           }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
