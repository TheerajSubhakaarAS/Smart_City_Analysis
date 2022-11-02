import java.net.*;
import java.io.*;
import java.awt.Desktop;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;
import java.util.IntSummaryStatistics;

public class Projectclient {

    static DataInputStream in = null;
    static DataOutputStream out = null;
    static ObjectInputStream ois = null;
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)throws Exception {
         try{
    Socket socket=new Socket("127.0.0.1",8888);
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="", temp1="";
    while(!clientMessage.equals("bye")){
        
        System.out.println();
        System.out.println("Please select : ");
        System.out.println("1. Summary statistics");
        System.out.println("2. linear regression");
        System.out.println("3. correlation coefficient");
        System.out.println("4. t-test");
        System.out.println("5. Bar Chart");
        System.out.println("6. Pie Chart");
        System.out.println("7. Line Chart");
        System.out.println("8. Control Charts");
        System.out.println("9. Add new data");
        System.out.println("10. delete data");
        System.out.println("11. update particular field in  data");
        System.out.println("12. DISPLAYING DATA");
        System.out.println("13.Skewness");
        System.out.println("Enter number :");
        
        clientMessage=br.readLine();
        temp1= clientMessage;
        
        outStream.writeUTF(clientMessage);
        outStream.flush();
        serverMessage=inStream.readUTF();
        String temp = serverMessage.substring(0,4);
      
      if (temp1.equals("2"))
      {
          System.out.println("The Predicted value of smart living is :");
      }
       if (temp1.equals("3"))
      {
          System.out.println("The Correlation COefficient between smart living and smart economy :");
      }
       
       if (temp1.equals("4"))
      {
          System.out.println("The T test for smart environment and smart economy :");
      }
        if (temp1.equals("13"))
      {
          System.out.println("The Skewness of this particular Datast is :");
      }
        if(temp.equals("http"))
      {
          Desktop d = Desktop.getDesktop();
          d.browse(new URI(serverMessage));
      }
      
      else 
      {
          System.out.print(serverMessage);
          System.out.println();
      }
      
      
    }
    outStream.close();
    outStream.close();
    socket.close();
  }catch(Exception e){
    System.out.println(e);
  }
    }
    
}
