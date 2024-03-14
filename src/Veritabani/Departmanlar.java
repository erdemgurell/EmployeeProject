package Veritabani;

import Modeller.Departmanlar.BilisimTeklonojileriDepartmani;
import Modeller.Departmanlar.Department;
import Modeller.Departmanlar.HumanResourceDepartment;
import Modeller.Departmanlar.ManagementDepartment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Departmanlar {

    // TODO Bu class'da bir sey degistirmenize gerek yok
    // Bunu bir veritabani gibi düsünmeliyiz bu yüzden proje calistiği zaman, ilk once veritabani olusmali ki
    // ekleme cikarma islemlerini rahatca yapabilelim bu yüzden tüm değerleri static verip, departmanList i ise
    // new leyip, bu departmanlari içerisine bulunduralim.
    static private final Department BILISIM_TEKLONOJILERI_DEPARTMANI = new BilisimTeklonojileriDepartmani();
    static private final Department YONETIM_DEPARTMANI = new ManagementDepartment();
    static private final Department INSAN_KAYNAKLARI_DEPARTMANI = new HumanResourceDepartment();
    static private List<Department> departmentList = new ArrayList<>(Arrays.asList(BILISIM_TEKLONOJILERI_DEPARTMANI, YONETIM_DEPARTMANI, INSAN_KAYNAKLARI_DEPARTMANI));

    // getter method
    public static List<Department> getDepartmanList() {
        return departmentList;
    }


}


























