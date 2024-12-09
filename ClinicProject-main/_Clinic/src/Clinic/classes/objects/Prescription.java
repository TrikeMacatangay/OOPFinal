package Clinic.classes.objects;

import static Clinic.base.Display.*;


public class Prescription extends Note {

    private String medication;
    private String dosage;
    private String doctorName;

    public Prescription(String medication, String dosage, String doctorName)
    {
        super("Prescription");
        this.medication = medication;
        this.dosage = dosage;
        this.doctorName = doctorName;
    }

    public String getMedication()
    {
        return medication;
    }

    public String getDosage()
    {
        return dosage;
    }

    public String getDocName()
    {
        return doctorName;
    }

    public void display()
    {
        println("------------------------------");
        println(super.getType() + " - " + super.getDateCreated() + "\n");
        println(medication + " - " + dosage);
        println("Prescribed by: " + doctorName + "\n");
    }
}
