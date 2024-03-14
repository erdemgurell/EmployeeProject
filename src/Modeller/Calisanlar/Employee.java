package Modeller.Calisanlar;

import Modeller.Departmanlar.Department;
import Veritabani.Workers;
import Veritabani.Departmanlar;

public class Employee {

    private String workerID;
    private String nameSurname;
    private int salary;
    private Department Department;
    private String nameCode = "";
    private final int id;
    private static int idC = 1;

    public Employee(String nameSurname, int salary, String departmanKodu) {
        this.nameSurname = nameSurname;
        this.salary = salary;
        setDepartman(departmanKodu);
        this.id = idC++;
        this.setCalisanId();

        // Ex: There are 257 employees in the company, Michael Ali Bulut will be registered in the IT department,
        // ID for Michael Ali Bulut should be 'ITD258MAB'.
        Workers.addEmployee(this);

    }

    // Set department
    private void setDepartman(String departmanKodu) {

        for (Department d : Departmanlar.getDepartmanList()) {
            if (d.getDepartmentCode().equals(departmanKodu)) {
                this.Department = d;
                break;
            }
        }

    }


    private void setCalisanId() {
        // The Employee's ID is private
        this.workerID = Department.getDepartmentCode() + this.id + getCalisanIsimKodu();

    }

    private String getCalisanIsimKodu() {
        // A method that fragments the name to add a name code at the end of the employee's ID
        // It won't give any error when entering 2 first names and one last name.

        String[] nameKodList = this.nameSurname.split(" ");

        for (String s : nameKodList) {
            this.nameCode += s.substring(0, 1).toUpperCase();
        }
        return this.nameCode;// TODO burayi unutmayin
    }



    // Getter's for ID
    public String getWorkerID() {
        return this.workerID;
    }

    // Getter's for Department
    public Department getDepartman() {
        return this.Department;
    }


    // A method to name the department
    public String getDepartmanAdi() {
        if (Department.getDepartmentCode().equals("YD")) {
            return "Yönetim Departmanı";
        } else if (Department.getDepartmentCode().equals("BTD")) {
            return "Bilişim Teknolojileri Departmanı";
        } else {
            return "İnsan Kaynakları Departmanı";
        }
    }

    // A required method to give a raise to the employee
    public static void zamYap(String calisanId) {
        for (Employee c : Workers.getWorkerList()){
            if (calisanId.equals(c.workerID)){
                c.salary += (c.salary / 100) * c.Department.getRaiseRate();
            }
        }
    }



    // A necessary override to print employees

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanId='" + workerID + '\'' +
                ", adSoyad='" + nameSurname + '\'' +
                ", maas=" + salary +
                ", Departman=" + getDepartmanAdi() +
                '}';
    }
}
