package Clinic.classes;

import static Clinic.base.Display.*;
import java.util.Scanner;

public class Security {
    
    public Security()
    {
        
    }
    
    private String key = "nurse";
    private String name = "nurse";
    Scanner input = new Scanner(System.in);
    
    public boolean Authorization()
    {
        while (true)
        {
            print("BRGY Health Records System");
            println("\n");
            print("Username: ");
            String n = input.nextLine();
            print("Password: ");
            String p = input.nextLine();
            
            
            if (n.equals(name) && p.equals(key))
            {
                cls();
                return true;
            }
            else
            {
                println("Incorrect credentials.");
                println("Press ENTER to continue");
                input.nextLine();
                cls();
            }
        }
    }
    
    public boolean Authorization(String prompt, boolean loop)
    {
        while (true)
        {
            print(prompt);
            println("\n");
            print("Username: ");
            String n = input.nextLine();
            print("Password: ");
            String p = input.nextLine();
            
            
            if (n.equals(name) && p.equals(key))
            {
                cls();
                return true;
            }
            else if (loop)
            {
                println("Incorrect credentials.");
                pause();
                input.nextLine();
                cls();
            }
            else
            {
                println("Incorrect credentials.");
                pause();
                input.nextLine();
                cls();
                return false;
            }
        }
        
    }
}