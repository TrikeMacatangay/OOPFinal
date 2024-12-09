package Clinic.collections;

import java.time.LocalDate;
import Clinic.classes.objects.Schedule;
import static Clinic.base.Display.*;

public class Schedules {

    private Schedule[] schedules = new Schedule[5];

    public Schedules()
    {
        LocalDate today = LocalDate.now();
        //LocalDate tempDate;
        int count = 0; int i = 0;


        while (count < 5)
        {
            LocalDate temp = today.plusDays(i);
            String s = temp.getDayOfWeek().name();

            if (s != "SUNDAY" && s != "SATURDAY")
            {
                schedules[count] = new Schedule(temp);
                count++;
            }
            i++;
        }
    }

    public Schedule getSchedule(int index)
    {
        return schedules[index];
    }

    public void showSchedules()
    {
        int i = 1; String s;
        for (Schedule schedule : schedules)
        {
            s = i + ". " + String.format("%-18s", schedule.getDate()) + " - " + String.format("%-10s", schedule.getWeekday()) + " (" + schedule.getOpenSlots() + "/7 slots open)";
            println(s);
            i++;
        }
    }

    public void printScheduleToday()
    {
        println(schedules[0].getDate() + " - " + schedules[0].getWeekday() + "\n");
        
        schedules[0].showSchedule();
    }
}
