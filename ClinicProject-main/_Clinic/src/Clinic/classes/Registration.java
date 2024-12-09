package Clinic.classes;

import static Clinic.base.Display.*;
import Clinic.base.Input;
import Clinic.classes.objects.Pair;
import Clinic.classes.objects.Resident;

import java.time.LocalDate;
import java.time.Month;

public class Registration {
    Input customInput = new Input();
    public Registration()
    {

    }

    public Pair RegMenu()
    {
        String fName = "";
        String mName = "";
        String lName = "";
        
        int sex = 2;
        
        
        Pair checker;
        
        while (true)
        {
            cls();
            
            println("Resident Registration\n");
            
            //These input codes allow the program to temporarily
            //remember previously inputted strings even after it loops
            //This also creates the option to cancel the operation in the middle
            //of the process
            checker = customInput.line("First Name: ", fName);
            if (checker.getState() == 0) {
                continue;
            }else if (checker.getState() == -1) {
                return new Pair(new Resident(), false);
            } else {fName = checker.getString();}
            
            checker = customInput.line("Middle Name: ", mName);
            if (checker.getState() == 0) {
                continue;
            } else if (checker.getState() == -1) {
                return new Pair(new Resident(), false);
            } else {mName = checker.getString();}
            
            checker = customInput.line("Last Name: ", lName);
            if (checker.getState() == 0) {
                continue;
            } else if (checker.getState() == -1) {
                return new Pair(new Resident(), false);
            } else {lName = checker.getString();}
            
            cls();
            break;
        }
        
        Pair p; boolean up = true;
        
        while (up)
        {
            println("Resident Registration\n");
            println("[1] Male");
            println("[2] Female");
            println("[3] Other");
            
            p = customInput.choice("Sex: ", 3);
            int choice = p.getValue();
            
            switch(choice)
            {
                case -1: 
                    if (customInput.Cancel()) {cls(); return new Pair(new Resident(), false);}
                    else {break;}
                
                case 1: 
                case 2:
                case 3: sex = choice; up = false; break;
                
                default: print(p.showLog()); 
                pause("");
            }
            cls();
        }
        
        up = true;
        int month, day, year;
        LocalDate birthDate = LocalDate.now();
        String dateStr;
        
        while (up)
        {
            cls();
            println("Resident Registration\n");
            
            println("Enter Birthdate:\n");
            
            month = customInput.integer("Month: ");
            day = customInput.integer("Day: ");
            year = customInput.integer("Year: ");
            
            try
            {
                birthDate = LocalDate.of(year, month, day);
                
                Month m = Month.of(month);
                dateStr = m.name() + " " + day + ", " + year;
                
                println("Birthdate: " + dateStr);
                pause("");
                break;
            }
            catch (Exception e)
            {
                if (month == -99 || day == -99 || year == -99)
                {
                    println("Please only enter integers.");
                    pause("");
                    continue;
                }
                
                dateStr = month + "-" + day + "-" + year;
                String s = dateStr + " is not a valid date.";
                println(s);
                pause("");
            }
        }
        
        Resident res = new Resident(fName, mName, lName, sex-1, birthDate);
        pause("Resident registered.");
        
        return new Pair(res, true);
        
    }
}
