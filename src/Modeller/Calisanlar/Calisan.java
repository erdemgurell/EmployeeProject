package Modeller.Calisanlar;

import Modeller.Departmanlar.Departman;
import Veritabani.Calisanlar;
import Veritabani.Departmanlar;

public class Calisan {

    private String calisanId;
    private String adSoyad;
    private int maas;
    private Departman Departman;
    private String isimKodu = "";
    private final int id;
    private static int idC = 1;

    public Calisan(String adSoyad, int maas, String departmanKodu) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        setDepartman(departmanKodu);
        this.id = idC++;
        this.setCalisanId();    // constructor çalıştığında, aşağıda tanımlayacağınız bu metod vasıtasıyla tekil bi ID alacak...
        // Örn: Şirkette 257 calisan var, Bilişim teklonojileri departmaninda Mehmet Ali Bulut kaydedilecek olsun,
        // Mehmet Ali icin ID 'BTD258MAB' olmalıdır.
        Calisanlar.addACalisan(this);

    }

    private void setDepartman(String departmanKodu) {
        // TODO setDepartman() methodunu doldurunuz
        //  Terminalden girilen calisanin departman koduna göre, gerekli departman set edilmelidir.
        //  Çalışan sınıfının Constructor 'ı main'de tanımlı. Program çalıştığında, terminalden gireceğimiz
        //  departman kodu, buradaki metod (setDepartman) vasıtasıyla departman listesinin tümünü dolaşıp (foreach)
        //  getDepartmanKodu() ile bulunan sonuçlardan biriyle aynı mı? Diye bakıyoruz...
        //  Aynıysa, "terminalden girilen çalışanı bu departmana set et" demektir...
        //  İpucu: Departman listesinin (Veritabani.Departmanlar.DepartmanList) içerisindeki departmanların kodları var,
        //  bu kodlari donguye tutmak ise yarayabilir.
        for (Departman d : Departmanlar.getDepartmanList()) {
            if (d.getDepartmanKodu().equals(departmanKodu)) {
                this.Departman = d;
                break;
            }
        }

    }


    private void setCalisanId() {
        // TODO setCalisanId() methodunu doldurunuz
        // Calisanin ID sinin kendisine özel olduğundan bahsetmistik,
        // ID nin nasil kaydedileceği Readme Dosyasi içerisinde yer aliyor.
        this.calisanId = Departman.getDepartmanKodu() + this.id + getCalisanIsimKodu();

    }

    private String getCalisanIsimKodu() {
        // TODO getCalisanIsimKOdu() methodunu doldurunuz
        // Calisanin ID sinin sonuna isim kodu eklenmesi için, ismi parçalayan bir method
        // Basit string metodlari ise isinize cok yarayacaktir fakat dinamik olmasina dikkat edelim...
        // Mesela 2 isim bir soyisim girildiğinde hata vermesin.

        String[] nameKodList = this.adSoyad.split(" ");

        for (String s : nameKodList) {
            this.isimKodu += s.substring(0, 1).toUpperCase();
        }
        return this.isimKodu;// TODO burayi unutmayin
    }



    // Calisanin id sini almak icin basit getter method
    public String getCalisanId() {
        return this.calisanId;
    }

    // Calisanin departmanini almak icin basit getter method
    public Departman getDepartman() {
        return this.Departman;
    }


    // Departman adini verebilmek için bir method
    public String getDepartmanAdi() {
        // TODO getDepartmanAdi() methodunu doldurunuz
        // İpucu: Departman Kodu YD ise departman adi Yonetim Departmani olarak kaydedilmelidir.
        if (Departman.getDepartmanKodu().equals("YD")) {
            return "Yönetim Departmanı";
        } else if (Departman.getDepartmanKodu().equals("BTD")) {
            return "Bilişim Teknolojileri Departmanı";
        } else {
            return "İnsan Kaynakları Departmanı";
        }
       /// TODO burayi unutmayin

    }

    // Calisana zam yapilmasi için gerekli bir method
    public static void zamYap(String calisanId) {
        // TODO zamYap() methodunu doldurunuz
        // İpucu:Calisan ID si kullanilarak yapilmalidir, diğer attributelarin aynilarindan 1 er tane daha olabilirdi.
        for (Calisan c : Calisanlar.getCalisanList()){
            if (calisanId.equals(c.calisanId)){
                c.maas += (c.maas / 100) * c.Departman.getZamOrani();
            }
        }
    }



    // Calisanlari yazdırmak için gerekli bir override

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanId='" + calisanId + '\'' +
                ", adSoyad='" + adSoyad + '\'' +
                ", maas=" + maas +
                ", Departman=" + getDepartmanAdi() +
                '}';
    }
}
