
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;
import java.text.DateFormat;


public class Server {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String  URL = "jdbc:mysql://localhost:3306/";

    static final String user = "root";
    static final String pass = "2002";
    public static Scanner sc = new Scanner(System.in);
    static Statement stmt = null;
    static Statement stmt2 = null;
    static Statement stmt3 = null;
    static Connection conn = null;
    static String sql_command = "";
    static DataOutputStream out = null;
    static DataInputStream in = null;
    static OutputStream OutputStream = null;
    static ObjectOutputStream objectOutputStream = null;
    
    public static void main(String[] args) throws Exception {
        int id, opt, opt2;
        String admn, pswd;
        boolean logged = false;

        ServerSocket socket = new ServerSocket(5000);
        System.out.println("\nServer Started\nWaiting for Client...");
        Socket s = socket.accept();
        System.out.println("Connection established !");

        in = new DataInputStream(s.getInputStream());
        out = new DataOutputStream(s.getOutputStream());
        OutputStream outputStream = s.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,user,pass);
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            
            sql_command = "USE pro";
            stmt.executeUpdate(sql_command);
            System.out.println("\nConnected to MySQL DataBase !");
            
            do{
                opt = in.readInt();
                
                switch(opt){
                case 1:
                    System.out.println("\n\t--- ADD EXPENSES ---");
                    addExpense();
                    break;
                
            }
                
            }while(opt!=5);
            
            
            
            
        }catch (SQLException se ) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("\nDisconnected from MySQL !");
    }
    static void addExpense(){
        int id;
        String City;
        String Country;
        String Smart_Mobility ;
        String Smart_Environment;
        String Smart_Government ;
        String Smart_Economy;
        String Smart_People;
        String Smart_Living;
        String SmartCity_Index;
        String SmartCity_Index_relative_Edmonton;
        
        
        try{
            id = Server.in.readInt();
            City= Server.in.readUTF();
            Country=Server.in.readUTF();
            Smart_Mobility= Server.in.readUTF();
            Smart_Environment = Server.in.readUTF();
            Smart_Government = Server.in.readUTF();
            Smart_Economy = Server.in.readUTF();
            Smart_People = Server.in.readUTF();
            Smart_Living = Server.in.readUTF();
            SmartCity_Index = Server.in.readUTF();
            SmartCity_Index_relative_Edmonton = Server.in.readUTF();
                    
            
            
           
            
            //System.out.print(date);
            //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
            sql_command = "INSERT INTO persons(Id,City,Country,Smart_Mobility,Smart_Environment,Smart_Government,Smart_Economy,Smart_People,Smart_Living,SmartCity_Index,SmartCity_Index_relative_Edmonton) VALUES ("+id+",'"+City+"','"+Country+"','"+Smart_Environment +"','"+Smart_Mobility +"','"+Smart_Government +"','"+Smart_Economy +"','"+Smart_People+"','"+Smart_Living+"','"+SmartCity_Index +"','"+SmartCity_Index_relative_Edmonton+"')";
            stmt.executeUpdate(sql_command);
            out.writeUTF("new data is Added Successfully!!!!");
        
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}