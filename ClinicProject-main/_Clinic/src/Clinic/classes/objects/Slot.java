package Clinic.classes.objects;

public class Slot {
    private boolean available = true;
    private boolean completed = false;
    private String time;
    private String date;
    private Appointment appointment;
    

    public Slot(String time, String date)
    {
        this.time = time;
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public boolean isComplete()
    {
        return completed;
    }

    public String getDate()
    {
        return date;
    }

    public boolean getAvailability()
    {
        return available;
    }

    public String getResidentName()
    {
        return appointment.getResident().getName(false);
    }

    public Resident getResident()
    {
        return appointment.getResident();
    }

    public String getDetails()
    {
        return appointment.getDetails();
    }

    public void Appoint(Resident resident, String details)
    {
        if (!available)
        {
            return;
        }

        appointment = new Appointment(resident, date + " - " + time, details);
        available = false;
    }

    public void close()
    {
        completed = true;
    }
}
