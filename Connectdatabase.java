import com.mysql.cj.xdevapi.Statement;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connectdatabase {
    
    Statement stmt = null;
    
    public static void main(String[] args){
        
        try{
        String  user = "root";
        String password = "2002";
        String url = "jdbc:mysql://localhost:3306/pro";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c= DriverManager.getConnection(url, user,password);
        if(c!=null){
            System.out.println("Success");
        }
        else{
            System.out.println("Fail");
        }
        java.sql.Statement stmt=c.createStatement();  
        java.sql.ResultSet rs=stmt.executeQuery("select * from persons");   
        while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11));  
        c.close();
        
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Connectdatabase.class.getName()).log(Level.SEVERE,null,ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connectdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}