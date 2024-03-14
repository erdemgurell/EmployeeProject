import Modeller.Calisanlar.Employee;
import Veritabani.Workers;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        // Two scanners were used because a scanner used for String can give an error when used for another type.
        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);


        // A simple program start, if Process 4 is selected, the loop will stop.
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Şirket Paneline Hoşgeldiniz. Lütfen bir islem seciniz.");
            System.out.println("---------------------------------------------");
            System.out.println("1-Calisan İslemleri\n2-Tüm Calisanlari Görüntüle\n3-Departmandaki Tüm Calisanlari Görüntüle\n4-Çıkış");
            System.out.println("---------------------------------------------");
            System.out.print("Islem : ");
            int secim1 = input.nextInt();
            System.out.println("İşleminiz gerçekleştiriliyor lütfen bekleyiniz...");
            Thread.sleep(1500);

            // If selection is 1, it will go to the employee operations tab.
            if (secim1 == 1) {
                while (true) {
                    System.out.println("---------------------------------------------");
                    System.out.println("Calisan İslemleri Paneline Hosgeldiniz, Lütfen bir islem seciniz.");
                    System.out.println("1-Calisan Ekle\n2-Calisan Sil\n3-Zam Yap\n4-Onceki Menu\n");
                    System.out.print("İslem : ");
                    int choice = input.nextInt();
                    System.out.println("İşleminiz gerçekleştiriliyor lütfen bekleyiniz...\n");
                    Thread.sleep(1000);

                    // A worker will be added for selection 1,
                    // it will ask you for the arguments for the constructor's parameter
                    if (choice == 1) {
                        // Argument 1
                        System.out.print("Lutfen isim ve soyisim giriniz : ");
                        String calisanAdSoyad = stringInput.nextLine();

                        // Argument 2
                        System.out.print("Lütfen maas giriniz : ");
                        int calisanMaas = input.nextInt();

                        // Argument 3
                        System.out.print("Lütfen departman kodunu giriniz : ");
                        String calisanDepartmanKod = stringInput.nextLine();

                        // The Constructor of the worker and the arguments are used here.
                        new Employee(calisanAdSoyad, calisanMaas, calisanDepartmanKod);
                        System.out.println("Calisan basari ile eklendi. Onceki menüye aktariliyorsunuz...");
                        Thread.sleep(1000);
                        break;
                    } else if (choice == 2) {

                        // An ID will be given and necessary operations will be done on the ID,
                        // this operation here is to delete an employee.
                        System.out.print("Lütfen silmek istediğiniz çalışanın ID sini giriniz : ");
                        String calisanId = stringInput.nextLine();
                        Workers.deleteWorkerWithId(calisanId);
                        System.out.println(calisanId + " Başarı ile silindi. Onceki Menuye aktariliyorsunuz....");
                        Thread.sleep(1000);
                        break;
                    } else if (choice == 3) {

                        // An ID will be given and necessary operations will be performed on the ID,
                        // this operation here is to give a raise to an employee.
                        System.out.print("Lütfen zam yapmak istediğiniz çalışanın ID sini giriniz : ");
                        String calisanId = stringInput.nextLine();
                        Employee.zamYap(calisanId);
                        System.out.println("Islem basari ile gerçekleşti, Onceki menuye aktariliyorsunuz");
                        Thread.sleep(1000);
                        break;
                    } else if (choice == 4) {
                        System.out.println("İşleminiz gerçekleştiriliyor lütfen bekleyiniz...\n");
                        Thread.sleep(1000);
                        break;
                    } else {
                        System.out.println("Hatali secim yaptiniz lütfen tekrar deneyiniz.");
                    }
                }

                // If selection 2 is made, employees will be listed
            } else if (secim1 == 2) {
                System.out.print("Tüm calisanlar listeleniyor...");
                Thread.sleep(1000);
                for (int i = 0; i < 20; i++) {
                    System.out.print('>');
                    Thread.sleep(100);
                }
                System.out.println(' ');
                System.out.println("---------------------------------------------");
                Workers.printWorkers();
                System.out.println("---------------------------------------------");

                // If selection 3 is made, a department code will be requested and
                // all people working in that department will be printed to the console.
            } else if (secim1 == 3) {
                System.out.print("Lütfen departman kodunu giriniz : ");
                String departmanKodu = stringInput.nextLine();
                System.out.print("Tüm calisanlar listeleniyor...");
                Thread.sleep(1000);
                for (int i = 0; i < 20; i++) {
                    System.out.print('>');
                    Thread.sleep(100);
                }
                System.out.println(' ');
                System.out.println("---------------------------------------------");
                Workers.printEmployeesInDepartment(departmanKodu);
                System.out.println("---------------------------------------------");
            } else {
                System.out.print("Başarıyla çıkış yaptınız, iyi günler dileriz.");
                break;
            }

        }

    }

}
