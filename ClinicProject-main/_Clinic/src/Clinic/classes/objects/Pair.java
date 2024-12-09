package Clinic.classes.objects;

public class Pair
{
    private int value;
    private String string;
    private String log;
    private boolean valid;
    private int state;
    private Resident resident;
    
    
    public Pair(int v, String s)
    {
        value = v;
        log = s;
    }
    
    public Pair(String s, boolean b)
    {
        string = s;
        valid = b;
    }
    
    public Pair(String s, int i)
    {
        string = s;
        state = i;
    }

    public Pair(Resident r, boolean b)
    {
        resident = r;
        valid = b;
    }

    public int getValue()
    {
        return value;
    }

    public String getString()
    {
        return string;
    }

    public String showLog()
    {
        return log;
    }

    public boolean isValid()
    {
        return valid;
    }

    public int getState()
    {
        return state;
    }

    public Resident getResident()
    {
        return resident;
    }
}
