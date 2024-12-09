package Clinic.base;

import static Clinic.base.Display.*;

import java.util.Scanner;

import Clinic.classes.objects.Pair;


public class Input
{
    Scanner scanner = new Scanner(System.in);
    
    public Input()
    {
        
    }
    
    public Pair choice(String prompt, int choices)
    {
        int input;
        
        print(prompt);
        
        try{
            String s = scanner.nextLine();
            char c = s.charAt(0);
            input = Character.getNumericValue(c);
            
            if (!Character.isDigit(c))
            {
                throw new Throwable("Type mismatch");
            }
            
            int value; String log;
            if (input >= 0 && input <= choices)
            {
                
                if (s.length() > 1)
                {
                    log = "Out of bounds.";
                    value = 999;
                }
                else
                {
                    value = input;
                    log = "";
                }
            }
            else
            {
                value = input;
                log = "Out of bounds.";
            }
            return new Pair(value, log);
        }
        catch (Throwable e){
            //scanner.nextLine();
            int value = -1;
            String log = "Please enter an integer";
            return new Pair(value, log);
        }
        
    }
    
    public Pair line(String prompt, String input)
    {
        //Scanner scanner = new Scanner(System.in);
        
        print(prompt);
        
        if (input.length() == 0)
        {
            String res = scanner.nextLine();
            if (res.length() == 0)
            {
                if (Cancel())
                {
                    return new Pair(res, -1);
                }
                else
                {
                    return new Pair(res, 0);
                }
            }
            else
            {
                return new Pair(res, 1);
            }
        }
        else
        {
            println(input);
            return new Pair(input, 1);
        }
    }
    
    public boolean Cancel()
    {
        print("Cancel? (\'Y\' to cancel): ");
        
        String s = scanner.nextLine();
        
        if (s.length() == 0)
        {
            return false;
        }
        
        char c = s.toUpperCase().charAt(0);
        
        if (c == 'Y')
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public int integer(String prompt)
    {
        print(prompt);
        int i;
        
        try
        {
            i = scanner.nextInt();
        }
        catch (Throwable t)
        {
            i = -99;
            scanner.nextLine();
        }
        return i;
    }
}