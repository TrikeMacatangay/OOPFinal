package Clinic.classes.objects;

import static Clinic.base.Display.println;

public class Vaccine extends Note {
    
    private String vaccine;
    private String doctorName;

    public Vaccine(String vaccine, String doctorName)
    {
        super("Vaccination");
        this.vaccine = vaccine;
        this.doctorName = doctorName;
    }

    public String getRemark()
    {
        return vaccine;
    }

    public String getDocName()
    {
        return doctorName;
    }

    public void display()
    {
        println("------------------------------");
        println(super.getType() + " - " + super.getDateCreated() + "\n");
        println("Vaccine: " +  vaccine);
        println("Vaccinated by " + doctorName + " on " + super.getDateCreated() + "\n");
    }
}