package Clinic.base;

import static java.lang.System.out;
import java.util.Scanner;

public class Display {
    
    public static void print(String item)
    {
        out.print(item);
    }
    
    public static void print(char item)
    {
        out.print(item);
    }
    
    public static void print(int item)
    {
        out.print(item);
    }
    
    public static void print(boolean item)
    {
        out.print(item);
    }
    
    public static void print(double item)
    {
        out.print(item);
    }
    
    public static void print(float item)
    {
        out.print(item);
    }
    
    public static void println(String item)
    {
        out.println(item);
    }
    
    public static void println(char item)
    {
        out.println(item);
    }
    
    public static void println(int item)
    {
        out.println(item);
    }
    
    public static void println(boolean item)
    {
        out.println(item);
    }
    
    public static void println(double item)
    {
        out.println(item);
    }
    
    public static void println(float item)
    {
        out.println(item);
    }
    
    public static void cls()
    {
        out.print("\033[H\033[2J");
        out.flush();
    }
    
    public static void pause()
    {
        Scanner s = new Scanner(System.in);
        out.print("Press ENTER to continue");
        s.nextLine();
    }
    
    public static void pause(String msg)
    {
        Scanner s = new Scanner(System.in);
        out.print(msg);
        s.nextLine();
        //out.flush();
        //s.close();
    }
}