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


    }


    public static void deleteACalisanWithId(String calisanId) {

        // TODO Bir çalışan silmek için gerekli method. deleteACalisanWithId() methodunu doldurunuz



    }


    public static void printDepartmandakiCalisanlar(String departmanKodu) {

        // TODO  Departman kodu verilerek, konsola sadece o departmanda calisanlari yazdirmak için
        //       printDepartmandakiCalisanlar() methodunu doldurunuz





    }


    public static void printCalisanlar() {

        // TODO  Calisanlari konsola yazdirmak için printCalisanlar() methodunu doldurun




    }
}
