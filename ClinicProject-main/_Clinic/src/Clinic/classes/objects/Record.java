package Clinic.classes.objects;

import static Clinic.base.Display.println;

import java.time.LocalDate;

public class Record extends Note{

    private LocalDate dateVisited;
    private String reason;

    public Record(LocalDate dateObj, String reason)
    {
        super("Visitation Record");

        dateVisited = dateObj;
        this.reason = reason;
    }

    public String getDateVisited()
    {
        return dateVisited.toString();
    }

    public String getReason()
    {
        return reason;
    }

    public void display()
    {
        println("------------------------------");
        println(super.getType() + " - " + super.getDateCreated() + "\n");
        println("Reason for visit: " + reason + "\n");
    }
}
