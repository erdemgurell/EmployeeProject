package Modeller.Departmanlar;

public interface Department {

    /*
       These methods will be used over the department,
       but the properties of the employee's department will be valid.
       This gives us a more dynamic structure.
     */

    int getRaiseRate();

    // Used in Worker class
    String getDepartmentCode();

}
