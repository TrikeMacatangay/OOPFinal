package Clinic.classes.objects;

import java.time.LocalDate;
import static Clinic.base.Display.*;
import Clinic.base.Input;
import java.util.ArrayList;;


public class Resident {
    private ArrayList<Note> notes = new ArrayList<>();

    private String[] Sex = {"MALE", "FEMALE", "OTHER"};
    
    private String firstName, middleName = "", lastName;
    private String sex;
    private LocalDate birthDate;

    private Input customInput= new Input();

    public Resident()
    {

    }
    
    public Resident(String firstName, String middleName, String lastName, int value, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    
        
        this.sex = Sex[value];
        
        this.birthDate = birthDate;
    }
    
    public Resident(String firstName, String lastName, int value, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        
        this.sex = Sex[value];
        
        this.birthDate = birthDate;
    }
    
    public String getFullName(boolean surnameFirst)
    {
        if (middleName.length() == 0)
        {
            if (surnameFirst)
            {
                return lastName + ", " + firstName; 
            }
            else
            {
                return firstName + " " + lastName; 
            }
        }

        if (surnameFirst)
        {
            return lastName + ", " + firstName + " " + middleName; 
        }
        else
        {
            return firstName + " " + middleName + " " + lastName; 
        }
    }
    
    public String getName(boolean surnameFirst)
    {
        if (middleName.length() == 0)
        {
            if (surnameFirst)
            {
                return lastName + ", " + firstName; 
            }
            else
            {
                return firstName + " " + lastName; 
            }
        }

        if (surnameFirst)
        {
            return lastName + ", " + firstName + " " + middleName.charAt(0) + "."; 
        }
        else
        {
            return firstName + " " + middleName.charAt(0) + ". " + lastName; 
        }
    }
    
    
    public String getSex()
    {
        return this.sex;
    }
    
    public String getBirthDate()
    {
        return birthDate.toString();
    }

    public void showRecords()
    {
        cls();
        println("Resident Details\n");
        println(getFullName(false) + "\n");

        printRecords();
    }

    public void CreateNote(Note note)
    {
        notes.add(note);
    }

    
    public void CreatePrescription()
    {
        Pair checker;
        String dosage = "";
        String medication = "";
        String doctorName = "";

        while (true)
        {
            cls();
            println("Prescription\n");

            checker = customInput.line("Medication: ", medication);
            if (checker.getState() == 0) {
                continue;
            } else if (checker.getState() == -1) {
                return;
            } else {medication = checker.getString();}

            checker = customInput.line("Dosage: ", dosage);
            if (checker.getState() == 0) {
                continue;
            }else if (checker.getState() == -1) {
                return;
            } else {dosage = checker.getString();}

            checker = customInput.line("Doctor: ", doctorName);
            if (checker.getState() == 0) {
                continue;
            }else if (checker.getState() == -1) {
                return;
            } else {doctorName = checker.getString();}

            CreateNote(new Prescription(medication, dosage, doctorName));
            return;
        }
    }

    public void CreateRecord()
    {
        Pair checker;
        String remark = "";
        String doctorName = "";

        while (true)
        {
            cls();
            println("Vaccination Record\n");

            checker = customInput.line("Vaccine: ", remark);
            if (checker.getState() == 0) {
                continue;
            }else if (checker.getState() == -1) {
                return;
            } else {remark = checker.getString();}

            checker = customInput.line("Doctor/Nurse: ", doctorName);
            if (checker.getState() == 0) {
                continue;
            }else if (checker.getState() == -1) {
                return;
            } else {doctorName = checker.getString();}

            CreateNote(new Vaccine(remark, doctorName));
            return;
        }
    }

    public void printRecords()
    {
        if (notes.size() == 0)
        {
            println("This resident has no records yet.");
            return;
        }

        for (Note note : notes)
        {
            note.display();
        }
    }

    public void showInfo()
    {
        Pair p;
        while (true) 
        {
            cls();
            println("Resident Details\n");
            println(getFullName(false) + "\n");
            println("Sex: " + sex);
            println("Birthdate: " + getBirthDate()); println("");   

           println("[1] View Records");
           println("[2] Log Prescription");
           println("[3] Log Vaccination");

           println("[0] Return"); 

           p = customInput.choice("Action: ", 1);
            int choice = p.getValue();
            
            switch(choice)
            {
                case -1: println(p.showLog()); pause(""); break;
                
                case 1: showRecords(); pause(""); break;

                case 2: CreatePrescription(); break;

                case 3: CreateRecord(); break;
                

                case 0: return;

                
                default: print(p.showLog()); 
                pause("");
            }
        }  
    }
}