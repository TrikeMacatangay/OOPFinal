package Clinic.classes.objects;

import java.time.LocalDate;


public class Note {
    
    private LocalDate dateCreated;
    private String type;

    public Note(String type)
    {
        dateCreated = LocalDate.now();
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public String getDateCreated()
    {
        return dateCreated.toString();
    }

    public void display()
    {
        
    }
}
