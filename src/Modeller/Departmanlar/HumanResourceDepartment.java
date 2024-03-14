package Modeller.Departmanlar;

public class HumanResourceDepartment implements Department {

    final String departmentCode = "IKD";

    // TODO Bu class'da sadece zam oranini belirtmelisiniz
    //      Başka bişeyi değiştirmeye gerek yok.
    final int raiseRate = 20;

    @Override
    public int getRaiseRate() {
        return raiseRate;
    }

    @Override
    public String getDepartmentCode() {
        return departmentCode;
    }
}
