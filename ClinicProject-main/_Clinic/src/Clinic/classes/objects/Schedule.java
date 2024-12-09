package Clinic.classes.objects;

import java.time.LocalDate;
import static Clinic.base.Display.*;

public class Schedule {
    LocalDate date;

    //8AM-12PM, 1PM - 4PM: 1 hour per slot
    private Slot[] slots = new Slot[7];

    String weekday; String dateStr;

    public Schedule(LocalDate date)
    {
        this.date = date;
        dateStr = date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear();
        weekday = date.getDayOfWeek().name();

        for (int i = 0; i < 7; i++)
        {
            if (i < 4)
            {
                int t = 8+i;
                slots[i] = new Slot(t + " AM", dateStr);
            }
            else
            {
                int t = i - 3;
                slots[i] = new Slot(t + " PM", dateStr);
            }
        }
    }


    public String getDate()
    {
        return dateStr;
    }

    public LocalDate getDateObj()
    {
        return date;
    }

    public int getOpenSlots()
    {
        int i = 0;
        for (Slot slot : slots)
        {
            if (slot.getAvailability())
            {
                i++;
            }
        }
        return i;
    }

    public String getWeekday()
    {
        return weekday;
    }

    public void showSlots()
    {
        int i = 1;
        for (Slot slot : slots)
        {
            print(i + ". " + String.format("%-5s", slot.getTime()));
            if (slot.getAvailability())
            {
                print(" - OPEN  ");
            }
            else
            {
                print(" - TAKEN ");
            }
            println("");
            i++;
        }
    }

    public void showSchedule()
    {
        for (Slot slot : slots)
        {
            println(String.format("%-5s", slot.getTime()) + "--------------");
            if (slot.getAvailability())
            {
                print("OPEN");
            }
            else
            {
                print(slot.getResident().getName(false) + " - " + slot.getDetails());
            }
            println("\n");
            
        }
    }

    public Slot getSlot(int index)
    {
        return slots[index];
    }

}
