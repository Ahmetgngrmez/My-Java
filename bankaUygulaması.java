import java.util.Scanner;
public class bankaUygulaması{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int bakiye = 1000; 
        String islemler = "1.işlem = bakiye sorma\n"
                        +"2.işlem = para çekme\n"
                        +"3.işlem = para yatırma\n"
                        +"çıkış için q'a basın";
        System.out.println("************************");
        System.out.println(islemler);
        System.out.println("************************");
        
        while(true){
            System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
            String islem = input.nextLine();
            
            //Döngünün ilk adımında kullanıcı q basarsa döngü sonlanır
            if(islem.equals("q")){
                System.out.println("Sistemden çıkılıyor...");
                break;
            }

            else if (islem.equals("1")){
                System.out.println("Hesap bakiyeniz = " + bakiye );
            }

            else if (islem.equals("2")){
                System.out.println("Mevcut bakiyeniz = " +bakiye );
                System.out.println("Lütfen çekmek istediğiniz tutarı seçiniz");
                int cekme = input.nextInt();
                
                //Altakki komutun girilmediği durumlarda scanner objesi hata verir
                input.nextLine();
                
                //Çekilecek miktarın bakiyeden fazla olmaması gerek
                if(cekme>bakiye){
                    System.out.println("Yetersiz bakiye");
                }
                else{
                    bakiye = bakiye - cekme;
                    System.out.println("Kalan bakiyeniz : "+bakiye);
                }
                
            }
            else if (islem.equals("3")){
                System.out.println("Lütfen yatırmak istediğinz miktarı yazın");
                
                int yatırma = input.nextInt();
                input.nextLine();
                bakiye += yatırma;
                System.out.println("Yeni bakiyeniz: "+ bakiye);

            }
            else {
                System.out.println("Geçersiz");
            }

        }
        input.close();

    }
}
 