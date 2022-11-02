/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Theeraj Subhakaar AS
 */
public class python {
    public static void main(String args[]) throws IOException {
        String prg = "import sys";
        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Theeraj Subhakaar AS\\AppData\\Local\\Programs\\Python\\Python310\\simple code.py"));
        out.write(prg);
        out.close(); 
        Process p = Runtime.getRuntime().exec("C:\\Users\\Theeraj Subhakaar AS\\AppData\\Local\\Programs\\Python\\Python310\\simple code.py");
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String ret = in.readLine();
        System.out.println("value is : "+ret);
        
    }
}
