package Veritabani;

import Modeller.Calisanlar.Employee;
import java.util.ArrayList;

public class Workers {


    // We can see this as a database. All of our employees will be in this list.
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    // To get all employees
    public static ArrayList<Employee> getWorkerList() {
        return employeeList;
    }


    public static void addEmployee(Employee employee) {

        if (!employeeList.contains(employee)){
            employeeList.add(employee);
        }
        else {
            System.out.println("Çalışan zaten kayıtlı.");
        }

    }


    public static void deleteWorkerWithId(String calisanId) {

        for (Employee c : employeeList){
            if (c.getWorkerID().equals(calisanId)){
                employeeList.remove(c);
            }
        }
    }


    public static void printEmployeesInDepartment(String departmanKodu) {
        for (Employee c : employeeList){
           if (departmanKodu.equals(c.getDepartman())){
               System.out.println(c);
           }
        }
    }


    public static void printWorkers() {
        for (Employee c : employeeList){
            System.out.println(c);
        }

    }
}
