import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Client {
    static DataInputStream in = null;
    static DataOutputStream out = null;
    static ObjectInputStream ois = null;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)throws IOException {
        
        int opt;
        Socket s= new Socket("localhost",5000);
        System.out.println("Connected to Server !");

        in = new DataInputStream(s.getInputStream());
        out = new DataOutputStream(s.getOutputStream());
        ois = new ObjectInputStream(in);
        
        do{
            System.out.printf("\n\t\t--- EXPENSE TRACKER ---\n\n1.Add Expenses\n2.Add Category\n3.View Expenses via date\n4.View Expenses via category\n5.Exit\n\nEnter your option : ");            
            opt = sc.nextInt();
            out.writeInt(opt);
            sc.nextLine();
            
            switch(opt){
                case 1:
                    System.out.print("\n\t--- ADD EXPENSES ---");
                    addExpense();
                    break;
                case 2:
                    System.out.print("\n\t--- ADD A NEW EXPENSE CATEGORY ---");
                    addCategory();
                    break;
                case 3:
                    System.out.println("\n\t--- VIEW EXPENSES VIA DATE ---");
                    viewDateExpenses();
                    break;
                case 4:
                    System.out.println("\n\t--- VIEW EXPENSES VIA CATEGORY ---");
                    viewCatExpenses();
                    break;
            }
            
        }while(opt!=5);
}
    static void addExpense(){
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
        System.out.println("\nADD YOUR EXPENSE:");
        try{
            System.out.print("Enter the id: ");
            id = sc.nextInt();
            out.writeInt(id);
            sc.nextLine();
            
            System.out.print("Enter the City: ");
            City = sc.nextLine();
            out.writeUTF(City);
            
            
            System.out.print("Enter the Country: ");
            Country = sc.nextLine();
            out.writeUTF(Country);
            
            System.out.print("Enter the Smart_Mobility: ");
            Smart_Mobility = sc.nextLine();
            out.writeUTF(Smart_Mobility);
            
            System.out.print("Enter the Smart_Environment: ");
            Smart_Environment = sc.nextLine();
            out.writeUTF(Smart_Environment);
            
            System.out.print("Enter the Smart_Government: ");
            Smart_Government = sc.nextLine();
            out.writeUTF(Smart_Government);
            
            System.out.print("Enter the Smart_Economy: ");
            Smart_Economy = sc.nextLine();
            out.writeUTF(Smart_Economy);
            
            System.out.print("Enter the Smart_People: ");
            Smart_People = sc.nextLine();
            out.writeUTF(Smart_People);
            
            System.out.print("Enter the Smart_Living: ");
            Smart_Living = sc.nextLine();
            out.writeUTF(Smart_Living);
            
            System.out.print("Enter the SmartCity_Index: ");
            SmartCity_Index = sc.nextLine();
            out.writeUTF(SmartCity_Index);
            
            System.out.print("Enter the SmartCity_Index_relative_Edmonton: ");
            SmartCity_Index_relative_Edmonton = sc.nextLine();
            out.writeUTF(SmartCity_Index_relative_Edmonton);  
            
            
            System.out.println(in.readUTF());
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        

    }
    static void addCategory(){
        int id, temp;
        String category;
        boolean flag=false;
        
        try{
            System.out.print("\n\t ENTER CATEGORY :");
            category = sc.nextLine();
            out.writeUTF(category);
            
            flag = in.readBoolean();
            if(flag) {
                System.out.println("\nCourse ID already exists !");
                return;
            }
            
            System.out.println("\nCategory Created Successfully !");
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    static void viewDateExpenses(){
        String date1,date2;int cnt =-1;
        ArrayList<ArrayList<String> > Expenses = new ArrayList<ArrayList<String> >();
        try{
            System.out.print("Enter the start date: ");
            date1 = sc.nextLine();
            System.out.print("Enter the end date: ");
            date2 = sc.nextLine();
            out.writeUTF(date1);
            out.writeUTF(date2);
            
            cnt = in.readInt();
            if(cnt==0) {
                System.out.println("\nNo EXPENSES BETWEEN THE GIVEN DATES !");
                return;
            }
            System.out.println("\nEXPENSES FOUND !!!");
            ArrayList expenses = (ArrayList)ois.readObject();
            
            System.out.println(expenses);
            for (int i = 0; i < expenses.size();i++) 
	      { 
                  if(i==0){
                      continue;
                  }
	          System.out.print(expenses.get(i)+ "   ");
                  if(i%3 == 0)
                  {
                     System.out.print("\n");                      
                  }
	      }   
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    static void viewCatExpenses(){
        String Category;int cnt=-1;
        try{
            System.out.print("Enter the category: ");
            Category =sc.nextLine();
            out.writeUTF(Category);
            
            cnt = in.readInt();
            if(cnt==0) {
                System.out.println("\nNo EXPENSES IN THE GIVEN CATEGORY !");
                return;
            }

            System.out.println("\nEXPENSES FOUND !!!");

            ArrayList expenses = (ArrayList)ois.readObject();
            
            for (int i = 0; i < expenses.size();i++) 
	      { 
                  if(i%2==0){
                      System.out.print("\n");
                  }
	          System.out.print(expenses.get(i)+ "   ");
                  
	      }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}