package lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trilece","havucDilim","guvec","kokorec","kusleme","arabasi","waffle","kunefe","guvec"));
        alfBykTekrarsiz(menu);
        System.out.println();
        chSayTersTekrarsiz(menu);
        System.out.println();
        harfSayisiYedidenAzKontrol(menu);
        System.out.println();
        charEnBykElPrint(menu);
    }

    //Task: List elemanlarini alfabetik buyuk harf ve tekrarsiz print ediniz
    public static void alfBykTekrarsiz(List<String> yemek){
        yemek.
                stream(). //akış başladı
                map(String::toUpperCase).  //büyük harfe cevirdi
                sorted(). //doğal sıralandı(alfabetik)
                distinct(). //elemanların tekrarsız olmasını sağladı
                forEach(Lambda01::yazdir); //print
    }

    //Task: List elemanlarının character sayisini ters sirali olarak tekrarsiz print ediniz
    public static void chSayTersTekrarsiz(List<String> yemek){
        yemek.
                stream().
                map(String::length). //Character sayilarini aldı
                sorted(Comparator.reverseOrder()).
                distinct().//Ters siralama yaptı
                forEach(Lambda01::yazdir);
    }

    //Task: List elemanlarının hepsinin character sayisinin 7 ve 7'den az olma durumunu kontrol ediniz
    public static void harfSayisiYedidenAzKontrol(List<String> yemek){
        System.out.print(yemek.
                stream().
                allMatch(w -> w.length() <= 7) ? "Listin tüm elemanlarinin character sayisi 7 veya 7'den kücüktür"  //allMatch->Tüm elemanlar şartı sağlarsa true verir
                : "Listin elemanlarinin character sayisinda 7'den fazla olan en az bir eleman vardır");
    }

    //Task: Listeki karakter sayisi en buyuk elemani yazdiriniz
    public static void charEnBykElPrint(List<String> yemek){
        Stream<String> enBuyuk=yemek.
                stream().
                sorted(Comparator.comparing(w->w.toString().length()). //toString() methodunu, comparing stringleri butun akış halinde aldigi icin tek bir string hale getirmek icin kullanildi
                        reversed()). //ters siralama yapti
                limit(1); //siralamada sadece ilk eleman lazim oldugu icin bunu kullandi
        System.out.println(Arrays.toString(enBuyuk.toArray()));
                           // enBuyuk.toArray() --> Stream olan akışı Array e cevirdi
                           // Arrays.toString --> Array i String yapiya cevirir. Array i direk yazdirabilmek icin kullanilir
    }

    //Task: List elemanlarini son harfine gore siralayip ilk eleman haric kalan elemnlarini print ediniz
    public static void ilkElHaricSonHrfPrint(List<String> yemek){
        yemek.
                stream().
                sorted(Comparator.comparing(w->w.charAt(w.length()-1))).
                skip(1). //haric tutulacak elemani secmek icin kullanilir
                forEach(Lambda01::yazdir);
    }

}
