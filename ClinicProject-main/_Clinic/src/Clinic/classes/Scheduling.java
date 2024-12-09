package Clinic.classes;

import static Clinic.base.Display.*;
import Clinic.base.Input;

import Clinic.classes.objects.Pair;
import Clinic.classes.objects.Record;
import Clinic.classes.objects.Slot;

import Clinic.collections.Schedules;
import Clinic.collections.Residents;
import Clinic.classes.objects.Schedule;

public class Scheduling {
    Input customInput = new Input();
    Schedules schedules;
    Residents residents;

    public Scheduling()
    {
        
    }

    public void LoadCollections(Schedules schedule, Residents residents)
    {
        schedules = schedule;
        this.residents = residents;

    }

    public void SchedMenu()
    {
        Pair p;
        while (true) 
        {
            cls();
            println("Schedules\n");

            schedules.showSchedules();
            println("0. Return\n");
            
        
            p = customInput.choice("Action: ", 5);
            int choice = p.getValue();
            
            switch(choice)
            {
                case -1: println(p.showLog()); pause(""); break;

                case 1:
                case 2:
                case 3:
                case 4:
                case 5: AppointMenu(schedules.getSchedule(choice-1));
                        break;
                
                case 0: return;
                
                default: print(p.showLog()); 
                pause("");
            }
            cls();
        }
    }

    private void AppointMenu(Schedule schedule)
    {
        Pair p;
        while (true)
        {
            cls();
            println(schedule.getDate() + " - " + schedule.getWeekday() + "\n");
            
            schedule.showSlots();
            println("0. Return\n");

            p = customInput.choice("Action: ", 7);
            int choice = p.getValue();

            if (choice == -1)
            {
                println(p.showLog()); pause("");
            }
            else if (choice == 0)
            {
                return;
            }
            else if (choice <= 7)
            {
                SlotMenu(schedule, schedule.getSlot(choice-1));
            }
            else
            {
                print(p.showLog()); 
                pause("");
            }
        }
    }

    public void SlotMenu(Schedule schedule, Slot slot)
    {
        String id = "";
        String details = "";

        Pair checker;
        Pair p;

        while (true) 
        {
            cls();
            println("Appointment Schedule");
            println(schedule.getDate() + " - " + schedule.getWeekday() + " " + slot.getTime() + "\n");

            if (slot.isComplete())
            {
                println("This appointment has been completed.");
                println("The appointment was for " + slot.getResidentName());
                println("Reason: " + slot.getDetails() + "\n");
                pause("");
                return;
            }

            if (slot.getAvailability())
            {
                checker = customInput.line("Resident ID ('YY-XXXXX'):\n", id);
                if (checker.getState() == 0) {
                    continue;
                } else if (checker.getState() == -1) {
                    return;
                } else 
                {
                    id = checker.getString();
                    if (!residents.findResident(id))
                    {
                        println("Resident not found.");
                        pause("");
                        id="";
                        continue;
                    }
                    else
                    {
                        println(residents.getResident(id).getName(false));
                    }
                }

                checker = customInput.line("Reason:\n", details);
                if (checker.getState() == 0) {
                    continue;
                } else if (checker.getState() == -1) {
                    return;
                } else 
                {
                    details = checker.getString();
                }

                slot.Appoint(residents.getResident(id), details);
                return;
            }

            else
            {
                println("This apointment slot is taken.");

                println("Scheduled for appointment is " + slot.getResidentName());
                println("Reason: " + slot.getDetails() + "\n");

                println("[1] Mark as Completed");
                println("[0] Return");


                p = customInput.choice("Action: ", 1);
                int choice = p.getValue();
                
                switch(choice)
                {
                    case -1: println(p.showLog()); pause(""); break;
                    
                    case 0: return;

                    case 1: slot.getResident().CreateNote(new Record(schedule.getDateObj(), slot.getDetails()));
                    pause("\nThis appointment is now marked as completed. Visitation Record created.");
                    slot.close(); break;
                    
                    default: print(p.showLog()); 
                    pause("");
                }

                    
                
            }
            
        }
    }

}
