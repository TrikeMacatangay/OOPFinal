package Clinic.classes;

import static Clinic.base.Display.*;

import java.time.LocalDate;

import Clinic.base.Input;
import Clinic.classes.objects.Pair;
import Clinic.classes.objects.Resident;
import Clinic.collections.*;


public class App {
    
    
    Input customInput = new Input();
    //Menus
    Security auth = new Security();
    Registration reg = new Registration();
    Scheduling sched = new Scheduling();
    //Collections
    Residents residents = new Residents();
    Schedules schedules = new Schedules();
    
    public App()
    {
        
    }

    private void Preload()
    {
        residents.Register(new Resident("Aleara", "Yunic", "Aravon", 1, LocalDate.of(2002, 01, 30)));
        residents.Register(new Resident("Aiden", "Feracron", "Gariona", 0, LocalDate.of(2000, 2, 28)));
        residents.Register(new Resident("John", "Doe", 0, LocalDate.of(2005, 05, 16)));
        residents.Register(new Resident("Jane", "Doe", 1, LocalDate.of(2005, 05, 16)));
        residents.Register(new Resident("Ryn", "Kipling", 1, LocalDate.of(1977, 07, 22)));
    }
    
    public void Run()
    {
        cls();
        Preload();
        auth.Authorization();
        cls();
        sched.LoadCollections(schedules, residents);
        Pair p;
        boolean up = true;
        
        while (up)
        {
            println("BRGY Health Records System\n");
            println("1. Register Resident");
            println("2. View Resident");
            println("3. Residents");
            println("4. Schedule Appointment");
            println("5. View Schedule\n");
            
            p = customInput.choice("Action: ", 5);
            int choice = p.getValue();
            
            switch(choice)
            {
                case -1: println(p.showLog()); pause(""); break;
                
                case 1: 
                Pair pair = reg.RegMenu();
                if (pair.isValid())
                {
                    residents.Register(pair.getResident());
                }
                break;

                case 2: residents.ResidentMenu(); break;

                case 3: residents.ViewList(); pause(""); break;

                case 4: sched.SchedMenu(); break;

                case 5: cls(); schedules.printScheduleToday(); pause(""); break;
                
                default: print(p.showLog()); 
                pause("");
            }
            cls();
        }
    }
}