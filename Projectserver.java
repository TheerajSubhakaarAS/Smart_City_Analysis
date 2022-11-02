
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.JFrame;
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants; 
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;
import pieChart.PieChartJFrame;
import java.util.stream.IntStream;
import java.util.IntSummaryStatistics;

class ServerClientThread extends Thread {
  Socket serverClient;
  int clientNo;
  int squre;
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
  }
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
    private static final List<Integer> x = asList(4565,4905,8095,5580,4330,6180,5415,5200,5535,8935,6380,4945,5980,5165,4285,8590,5360,7235,7130); // Consecutive hours developer codes
    private static final List<Integer> y = asList(9090,9090,7280,7200,7730,9920,7500,7200,10000,6220,7960,9090,7730,7200,9920,6220,9090,6220,8710);
   
    static float Mean(float arr[], int n)
    {
        float sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + arr[i];
        return sum / n;
    }
    static float standardDeviation(float arr[], int n)
    {
        float sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + (arr[i] - Mean(arr, n))
                  * (arr[i] - Mean(arr, n));
 
        return (float)Math.sqrt(sum / (n - 1));
    }
    static double mean(double arr[], int n)
    {
        double sum = 0;
         
        for (int i = 0; i < n; i++)
            sum = sum + arr[i];
         
        return sum / n;
    }
    static double standardDeviation(double arr[],
                                            int n)
    {
         
        double sum = 0 ;
         
        // find standard deviation
        // deviation of data.
        for (int i = 0; i < n; i++)
            sum = (arr[i] - mean(arr, n)) *
                        (arr[i] - mean(arr, n));
                 
        return Math.sqrt(sum / n);
    }
    static double skewness(double arr[], int n)
    {
        // Find skewness using
        // above formula
        double sum = 0;
         
        for (int i = 0; i < n; i++)
            sum = (arr[i] - mean(arr, n)) *
                    (arr[i] - mean(arr, n)) *
                        (arr[i] - mean(arr, n));            
         
        return sum / (n * standardDeviation(arr, n) *
                          standardDeviation(arr, n) *
                          standardDeviation(arr, n) *
                          standardDeviation(arr, n));
    }
    static float tTest(float arr1[], int n,
                        float arr2[], int m)
    {
        float mean1 = Mean(arr1, n);
        float mean2 = Mean(arr2, m);
        float sd1 = standardDeviation(arr1, n);
        float sd2 = standardDeviation(arr2, m);
 
        // Formula to find t-test
        // of two set of data.
        float t_test = (mean1 - mean2) /
                       (float)Math.sqrt((sd1 * sd1) /
                       n + (sd2 * sd2) / m);
        return t_test;
    }
    static float correlationCoefficient(int X[],
                                    int Y[], int n)
    {
       
        int sum_X = 0, sum_Y = 0, sum_XY = 0;
        int squareSum_X = 0, squareSum_Y = 0;
       
        for (int i = 0; i < n; i++)
        {
            // sum of elements of array X.
            sum_X = sum_X + X[i];
       
            // sum of elements of array Y.
            sum_Y = sum_Y + Y[i];
       
            // sum of X[i] * Y[i].
            sum_XY = sum_XY + X[i] * Y[i];
       
            // sum of square of array elements.
            squareSum_X = squareSum_X + X[i] * X[i];
            squareSum_Y = squareSum_Y + Y[i] * Y[i];
        }
       
        // use formula for calculating correlation 
        // coefficient.
        float corr = (float)(n * sum_XY - sum_X * sum_Y)/
                     (float)(Math.sqrt((n * squareSum_X -
                     sum_X * sum_X) * (n * squareSum_Y - 
                     sum_Y * sum_Y)));
       
        return corr;
    }
       
    static void addExpense(){
        System.out.println("working !");
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Enter id :");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter City :");
            City= sc.nextLine();
            System.out.println("Enter Country :");
            Country=sc.nextLine();
            System.out.println("Enter Smart_Mobility :");
            Smart_Mobility= sc.nextLine();
            System.out.println("Enter Smart_Environment :");
            Smart_Environment = sc.nextLine();
            System.out.println("Enter Smart_Government :");
            Smart_Government = sc.nextLine();
            System.out.println("Enter Smart_Economy :");
            Smart_Economy = sc.nextLine();
            System.out.println("Enter Smart_People :");
            Smart_People = sc.nextLine();
            System.out.println("Enter Smart_Living :");
            Smart_Living = sc.nextLine();
            System.out.println("Enter SmartCity_Index :");
            SmartCity_Index = sc.nextLine();
            System.out.println("Enter SmartCity_Index_relative_Edmonton :");
            SmartCity_Index_relative_Edmonton = sc.nextLine();  
            
            //System.out.print(date);
            //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
            sql_command = "INSERT INTO persons(Id,City,Country,Smart_Mobility,Smart_Environment,Smart_Government,Smart_Economy,"
                    + "Smart_People,Smart_Living,SmartCity_Index,SmartCity_Index_relative_Edmonton) "
                    + "VALUES ("+id+",'"+City+"','"+Country+"','"+Smart_Environment +"','"+Smart_Mobility 
                    +"','"+Smart_Government +"','"+Smart_Economy +"','"+Smart_People+"','"+Smart_Living+"','"
                    +SmartCity_Index +"','"+SmartCity_Index_relative_Edmonton+"')";
            stmt.executeUpdate(sql_command);
            }catch(Exception e) {
            e.printStackTrace();
        }
    }
    static Double predictForValue(int predictForDependentVariable) {
        if (x.size() != y.size())
            throw new IllegalStateException("Must have equal X and Y data points");

        Integer numberOfDataValues = x.size();

        List<Double> xSquared = x
                .stream()
                .map(position -> Math.pow(position, 2))
                .collect(Collectors.toList());

        List<Integer> xMultipliedByY = IntStream.range(0, numberOfDataValues)
                .map(i -> x.get(i) * y.get(i))
                .boxed()
                .collect(Collectors.toList());

        Integer xSummed = x
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Integer ySummed = y
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Double sumOfXSquared = xSquared
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Integer sumOfXMultipliedByY = xMultipliedByY
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        int slopeNominator = numberOfDataValues * sumOfXMultipliedByY - ySummed * xSummed;
        Double slopeDenominator = numberOfDataValues * sumOfXSquared - Math.pow(xSummed, 2);
        Double slope = slopeNominator / slopeDenominator;

        double interceptNominator = ySummed - slope * xSummed;
        double interceptDenominator = numberOfDataValues;
        Double intercept = interceptNominator / interceptDenominator;

        return (slope * predictForDependentVariable) + intercept;
    }

    static void Delete(){
        System.out.println("working !");
        Scanner sc = new Scanner(System.in);
        int id;
        
        
        
        try{
            System.out.println("Enter id :");
            id = sc.nextInt();
             
           
            //System.out.print(date);
            //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
            
            sql_command = "DELETE  FROM persons where id = "+id+"";
            stmt.executeUpdate(sql_command);
            }catch(Exception e) {
            e.printStackTrace();
        }
    }
    static void update(){
        System.out.println("working !");
        Scanner sc = new Scanner(System.in);
        int id;
        String Smart_Economy;
        String Smart_People;
        
        try{
            System.out.println("Enter id :");
            id = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Enter Smart_Economy :");
            Smart_Economy = sc.nextLine();
            System.out.println("Enter Smart_People :");
            Smart_People = sc.nextLine();
           
            //System.out.print(date);
            //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
            sql_command = "UPDATE persons SET Smart_Economy='"+Smart_Economy+"',Smart_People ='"+Smart_People+"' WHERE Id = "+id+"";
            stmt.executeUpdate(sql_command);
            }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
  public void run(){
      
      
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage="", serverMessage="";
      while(!clientMessage.equals("bye")){
         clientMessage=inStream.readUTF();
         switch(clientMessage)
         {
             case "5":
                  serverMessage="bar chart displayed";
                  outStream.writeUTF(serverMessage);
                  outStream.flush(); 
                  SwingUtilities.invokeAndWait(()->{  
                  BarChartExample example=new BarChartExample("Bar Chart Window");  
                  example.setSize(800, 400);  
                  example.setLocationRelativeTo(null);  
                  example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
                  example.setVisible(true);  
                  });
                  break;
                  
             case "6":
                 PieChartJFrame pcjf =new PieChartJFrame();
                 pcjf.setVisible(true);
                 serverMessage="Pie Chart displayed";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
                 break;
                 
             case "8":
                 serverMessage="http://127.0.0.1:3665/";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
                 break;
             case "7":
                 SwingUtilities.invokeLater(() -> {  
                 LineChartExample example = new LineChartExample("Line Chart Example");  
                 example.setAlwaysOnTop(true);  
                 example.pack();  
                 example.setSize(600, 400);  
                 example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
                 example.setVisible(true);  
                 });
                 serverMessage = "line chart is being displayed !.";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
                   break ;
             case "9":
                 try {
                      Class.forName(DRIVER);
                      conn = DriverManager.getConnection(URL,user,pass);
                      stmt = conn.createStatement();
                      stmt2 = conn.createStatement();
            
                      sql_command = "USE pro";
                      stmt.executeUpdate(sql_command);
                      System.out.println("\nConnected to MySQL DataBase !");
                       System.out.println("\n\t--- ADD EXPENSES ---");
                       addExpense();
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
                  serverMessage = "data has been entered !";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
                  break;
                case "10":
                 try {
                      Class.forName(DRIVER);
                      conn = DriverManager.getConnection(URL,user,pass);
                      stmt = conn.createStatement();
                      stmt2 = conn.createStatement();
            
                      sql_command = "USE pro";
                      stmt.executeUpdate(sql_command);
                      System.out.println("\nConnected to MySQL DataBase !");
                       System.out.println("\n\t--- delete---");
                       Delete();
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
                  
                  serverMessage = "data has been Deleted !";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
                  break;
                case "11":
                 try {
                      Class.forName(DRIVER);
                      conn = DriverManager.getConnection(URL,user,pass);
                      stmt = conn.createStatement();
                      stmt2 = conn.createStatement();
            
                      sql_command = "USE pro";
                      stmt.executeUpdate(sql_command);
                      System.out.println("\nConnected to MySQL DataBase !");
                       System.out.println("\n\t---update---");
                       update();
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
                  serverMessage = "data has been Updated !";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
                  break;
                case "12":
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
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "
                +rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "
                +rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11));  
        c.close();
        
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Connectdatabase.class.getName()).log(Level.SEVERE,null,ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connectdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        serverMessage = "data has been displayed !";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
         break;
        case "2":
            System.out.println("working !!!!!!");
            System.out.println("enter a value:");
            int a = sc.nextInt();
            System.out.println("the predicted value is :");
            System.out.println(predictForValue(a));
            serverMessage = predictForValue(a).toString();
            outStream.writeUTF(serverMessage);
            outStream.flush();
            
            break;
        case "1":
            IntStream stream = IntStream.of(4565,4905,8095,5580,4330,6180,5415,5200,5535,8935,6380,4945,5980,5165,4285,8590,5360,7235,7130);
  
            // Using IntStream summaryStatistics()
            IntSummaryStatistics summary_data = stream.summaryStatistics();       
            serverMessage=summary_data.toString();
            outStream.writeUTF(serverMessage);
            outStream.flush();
            
            break;
           case "3":
                int X[] = {4565,4905,8095,5580,4330,6180,5415,5200,5535,8935,6380,4945,5980,5165,4285,8590,5360,7235,7130};
        int Y[] = {9090,9090,7280,7200,7730,9920,7500,7200,10000,6220,7960,9090,7730,7200,9920,6220,9090,6220,8710};
       
        // Find the size of array.
        int n = X.length;
       
        // Function call to correlationCoefficient.
        System.out.println("the correlation between two variables:");
        System.out.printf("%6f",correlationCoefficient(X, Y, n));
        float coefficient = correlationCoefficient(X, Y, n);
        serverMessage = String.valueOf(coefficient);
            outStream.writeUTF(serverMessage);
            outStream.flush();
       
                
                  break;
        case "4":
            float arr1[] = {4565,4905,8095,5580,4330,6180,5415,5200,5535,8935,6380,4945,5980,5165,4285,8590,5360,7235,7130};
 
        // Calculate size of first array.
            int c = arr1.length;
        float arr2[] = {9090,9090,7280,7200,7730,9920,7500,7200,10000,6220,7960,9090,7730,7200,9920,6220,9090,6220,8710};
 
        // Calculate size of second array.
        int m = arr2.length;
 
        // Function call.
        System.out.println("the t-test");
        System.out.print(tTest(arr1, c, arr2, m));
        float test = tTest(arr1, c, arr2, m);
        serverMessage = String.valueOf(test);
            outStream.writeUTF(serverMessage);
            outStream.flush();
            
        break;
        case "13":
                  double arr[] = { 4565,4905,8095,5580,4330,6180,5415,5200,5535,8935,6380,4945,5980,5165,4285,8590,5360,7235,7130 };
                         
        // calculate size of array.
        int v = arr.length;
         
        // skewness Function call
        System.out.println(skewness(arr, v));
        serverMessage=String.valueOf(skewness(arr, v));
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
                 
             default:
                 serverMessage="Thank you";
                 outStream.writeUTF(serverMessage);
                 outStream.flush();
         }
        
      }
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception ex){
      System.out.println(ex);
    }finally{
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}

public class Projectserver {    

    public static void main(String[] args)throws Exception {    
         try{
      ServerSocket server=new ServerSocket(8888);
      int counter=0;
      System.out.println("Server Started ....");
      while(true){
        counter++;
        Socket serverClient=server.accept();  //server accept the client connection request
        System.out.println(" >> " + "Client No:" + counter + " started!");
        ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
        sct.start();
      }
    }catch(Exception e){
      System.out.println(e);
    }
     
    }
}



















































