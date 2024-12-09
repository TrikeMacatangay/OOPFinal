bonus na tong rough README HAHAHA

------------------
inheritance: Note.java -> (Record.java, Vaccine.java, Prescription.java)
polymorphism: Pair.java constructors and the print functions in Display.java (method overloading)
abstraction: can be found all over the files, but a very good example is Input.java
encapsulation: getters and setters are standard and can be found everywhere
------------------

base folder: 
contains a class that should be statically imported for easy use of printing, pausing, and clear screens
contains a class that acts as a modified input function, which handles special cases like out of bound inputs, type error, and the option to cancel operations midway

NOTE: to cancel the operation, press Enter while empty yung input field. if you type Y, it cancels and returns to the last menu.
if you type anything else, it allows you to continue inputting from where you left off

-------------------

collections folder:
the two files allow for the instantiation of a container for their respective objects

-------------------

classes folder:
those within the objects folder has been and will be instantiated more than once
those outside is only instantiated once, only acting as menus and handlers

-------------------
Security.java
the menu where you are required to enter the username and password is declared here as Authorization()
this class is instantiated in App.java and is called right at the start of Run()

USERNAME: nurse
PASSWORD: nurse