package Veritabani;

import Modeller.Calisanlar.Calisan;
import java.util.ArrayList;

public class Calisanlar {


    // Buradaki calisanList static cünkü proje calismaya basladiği anda oluşması lazım.
    // Bunu bir veritabani gibi görebiliriz. Calisanlarimizin hepsi bu liste icerisinde yer alacak.
    private static ArrayList<Calisan> calisanList = new ArrayList<>();

    // // Tüm çalışanları almak için
    public static ArrayList<Calisan> getCalisanList() {
        return calisanList;
    }


    public static void addACalisan(Calisan calisan) {
        // TODO Bir çalışan eklemek için gerekli method. addACalisan() methodunu doldurunuz
        if (!calisanList.contains(calisan)){
            calisanList.add(calisan);
        }
        else {
            System.out.println("Çalışan zaten kayıtlı.");
        }

    }


    public static void deleteACalisanWithId(String calisanId) {
        // TODO Bir çalışan silmek için gerekli method. deleteACalisanWithId() methodunu doldurunuz
        for (Calisan c : calisanList){
            if (c.getCalisanId().equals(calisanId)){
                calisanList.remove(c);
                break;
            }
        }
    }


    public static void printDepartmandakiCalisanlar(String departmanKodu) {
        // TODO  Departman kodu verilerek, konsola sadece o departmanda calisanlari yazdirmak için
        //       printDepartmandakiCalisanlar() methodunu doldurunuz
        for (Calisan c : calisanList){
           if (departmanKodu.equals(c.getDepartman().getDepartmanKodu())){
               System.out.println(c);
           }
        }
    }


    public static void printCalisanlar() {
        // TODO  Calisanlari konsola yazdirmak için printCalisanlar() methodunu doldurun
        for (Calisan c : calisanList){
            System.out.println(c);
        }

    }
}
