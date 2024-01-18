
package bank.managemet.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Pinchange extends  JFrame implements ActionListener{
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
   Pinchange(String pinnumber)
   {
       this.pinnumber=pinnumber;
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,800,800);
       add(image);
       
        JLabel text=new JLabel("Change your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(225,250,500,35);
       image.add(text);
       
       JLabel pintext=new JLabel("New Pin:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(145,300,500,25);
       image.add(pintext);
       
        pin=new JPasswordField();
       pin.setFont(new Font("Raleway",Font.BOLD,25));
       pin.setBounds(300,350,140,25);
       image.add(pin);
       
       
        JLabel repintext=new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(145,350,180,25);
       image.add(repintext);
       
          repin=new JPasswordField();
       repin.setFont(new Font("Raleway",Font.BOLD,25));
       repin.setBounds(300,300,140,25);
       image.add(repin);
       
        change=new JButton("Change");
       change.setBounds(300,434,140,25);
       change.addActionListener(this);
       image.add(change);
       
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
       if(ae.getSource()==change){
       try {
           
           String npin=pin.getText();
           String rpin=repin.getText();
           
           if(!npin.equals(rpin))
           {
           JOptionPane.showMessageDialog(null,"Entered Pin does not match" );
           return;
           }
           if(npin.equals(" "))
           {
                 JOptionPane.showMessageDialog(null,"Please Enter new Pin" );
                    return;
           }
            if(rpin.equals(" "))
           {
                 JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin" );
                    return;
           }
            Conn conn=new Conn();
            
            String query1="update bank set pin='"+rpin+"''where pin='"+pinnumber+"'";
            
            String query2="update login set pin='"+rpin+"'where pin='"+pinnumber+"'";
            
            String query3="update singupthree set pin='"+rpin+"'where pin='"+pinnumber+"'";
            
           conn.executeUpadte(query1); 
           conn.executeUpadte(query2);
           conn.executeUpadte(query3);
           
           JOptionPane.showMessageDialog(null,"Pin changed Successfully" );
           
           setVisible(false);
           new Transactions(rpin).setVisible(true);
           
           
       } catch (Exception e) {
           System.out.println(e);
       }
       }else
       {
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
   }
    
    public static void main(String[] args) {
        
        new  Pinchange("");
    }
}
