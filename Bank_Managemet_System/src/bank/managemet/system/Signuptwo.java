
package bank.managemet.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Signuptwo extends JFrame implements ActionListener{
    
    
  
    JTextField   pan,adhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
     
      JComboBox religion,category,occupation,education,income;
      String formno;
    
    Signuptwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
     
        setTitle("New Account Appication Form - Page 2");
       
        
        JLabel additionlDetails=new JLabel("page 2:Additionl Deteila");
        additionlDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionlDetails.setBounds(290,80,400,30);
        add(additionlDetails);
        
        JLabel name=new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christion","Other"};
         religion =new JComboBox(valReligion);
         religion.setBackground(Color.white);
          religion.setBounds(300,140,400,30);
          add(religion);
        
      
        
        JLabel fname=new JLabel("Category :");
       fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         String valCategory[]={"general","OBC","SC","ST","Other"};
         category = new JComboBox(valCategory);
          category.setBounds(300,190,400,30);
          category.setBackground(Color.white);
          add(category);
           
        
        JLabel dob=new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
         String valIncome[]={"Null","< 1,50,000"," < 2,50,0000","< 5,00,000","Upto 10,00,000"};
         income = new JComboBox(valIncome);
          income.setBounds(300,240,400,30);
          income.setBackground(Color.white);
          add(income);
        
     
        
          JLabel gender=new JLabel("Educational ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
       gender.setBounds(100,290,200,30);
        add(gender);
        
         
        JLabel email=new JLabel("Qualification :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
       email.setBounds(100,315,200,30);
        add(email);
        
         String educationValues[]={"Non-Graduation","Graduate"," Post-Graduate","doctrate","Other"};
         education = new JComboBox(educationValues);
          education.setBounds(300,315,400,30);
          education.setBackground(Color.white);
          add(education);
       
        
        
           JLabel marital=new JLabel("Occupation :");
         marital.setFont(new Font("Raleway",Font.BOLD,22));
       marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[]={"Salaried","Self-Employed"," Bussiness","Student","Retired","Other"};
        occupation= new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
          occupation.setBackground(Color.white);
          add(occupation);
       
        
    
        
             JLabel address=new JLabel("Pan Number :");
         address.setFont(new Font("Raleway",Font.BOLD,22));
       address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
       pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(300,440,400,30);
        add(pan);
        
          JLabel city=new JLabel("Adhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
       city.setBounds(100,490,200,30);
        add(city);
        
          adhar =new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(300,490,400,30);
        add(adhar);
        
        
         JLabel state=new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
       state.setBounds(100,540,200,30);
        add(state);
        
         syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
         syes.setBackground(Color.white);
        add( syes);
        
          sno=new JRadioButton("No");
         sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
         add( sno);
         
          ButtonGroup marriedgroup=new ButtonGroup();
         marriedgroup.add(syes);
        marriedgroup.add(sno);
     
        
          JLabel pincode=new JLabel("Existing Account :");
       pincode.setFont(new Font("Raleway",Font.BOLD,22));
       pincode.setBounds(100,590,200,30);
        add(pincode);
        
        
         eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
         eyes.setBackground(Color.white);
        add( eyes);
        
          eno=new JRadioButton("No");
         eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
         add( eno);
         
          ButtonGroup emarriedgroup=new ButtonGroup();
         emarriedgroup.add(eyes);
        emarriedgroup.add(eno);
     
        
         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,630,80,30);
       next.addActionListener(this);
       
        add(next);
        
        getContentPane().setBackground(Color.white);
        
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion =(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome= (String)income.getSelectedItem();
        String seducation =(String) education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitozen=null;
        
        if(syes.isSelected())
        {
        seniorcitozen="yes";
        }
        else if(sno.isSelected())
        {
        seniorcitozen="NO";
        }
       
        String exisitingaccount=null;
        if(eyes.isSelected())
        {
            exisitingaccount="yes";
        }
        else if(eno.isSelected())
        {
            exisitingaccount="No";
        }
     
        
        String span= pan.getText();
        String sadhar= adhar.getText();
       
        try {
        
            Conn c=new Conn();
            String query="insert into singuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitozen+"','"+exisitingaccount+"')";
           c.s.executeUpdate(query);
            setVisible(false);
            new Signupthree(formno).setVisible(true);
         
        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }
    public static void main(String[] args) {
        new Signuptwo("");
    }
}
 