
package bank.managemet.system;
import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    public Conn()
    {
        try {
           
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
            s=c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void executeUpadte(String query1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
