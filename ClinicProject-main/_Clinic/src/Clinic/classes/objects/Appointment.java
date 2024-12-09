package Clinic.classes.objects;

public class Appointment {
    private Resident resident;
    private String dateTime;
    private String details;

    public Appointment(Resident res, String dt, String details)
    {
        resident = res;
        dateTime = dt;
        this.details = details;
    }

    public Resident getResident()
    {
        return resident;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public String getDetails()
    {
        return details;
    }
}
