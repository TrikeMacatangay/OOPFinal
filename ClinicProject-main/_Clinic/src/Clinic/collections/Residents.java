package Clinic.collections;

import java.util.HashMap;
import java.util.Map;

import Clinic.classes.objects.Resident;
import Clinic.classes.objects.Pair;

import static Clinic.base.Display.*;
import Clinic.base.Input;

public class Residents {
    Map<String, Resident> collection = new HashMap<String, Resident>();
    Input customInput = new Input();

    public Residents()
    {

    }

    public void Register(Resident resident)
    {
        collection.put("23-"+String.format("%05d", collection.size()), resident);
    }

    public void ViewList()
    {
        cls();
        println("Registered Residents\n");

        if (collection.size() <= 0)
        {
            println("There are no registered residents.");
            return;
        }

        //pause("heklloooo?");
        for (String key : collection.keySet())
        {
            print(key + " - "); println(collection.get(key).getName(false));
        }
    }

    public Resident getResident(String id)
    {
        return collection.get(id);
    }

    public boolean findResident(String id)
    {
        return collection.containsKey(id);
    }

    public void ResidentMenu()
    {
        Pair checker;
        String id = "";

        while (true) 
        {
            cls();
            println("View Resident");
            checker = customInput.line("Resident ID: ", id);
            if (checker.getState() == 0) {
                continue;
            }else if (checker.getState() == -1) {
                return;
            } else {
                id = checker.getString();

                if (!findResident(id))
                {
                    pause("Resident not found.");
                    id = "";
                    continue;
                }

                getResident(id).showInfo();
                return;

            }    
        }
    }
}
