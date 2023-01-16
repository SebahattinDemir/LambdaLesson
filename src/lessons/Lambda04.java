package lessons;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
    Task :
        fields --> Universite (String)
                    Bolum (String)
                    ogrcSayisi (int)
                    notOrt (int)
                    olan Pojo class create edip main method icinde 5 farkli obj'den List create ediniz
     */
    public static void main(String[] args) {
        Universite universite01 = new Universite("bogazici", "matematik", 571, 93);
        Universite universite02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite universite03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite universite04 = new Universite("marmara", "bilgisayar muh.", 1080, 77);
        Universite universite05 = new Universite("odtu", "gemi muh.", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(universite01, universite02, universite03, universite04, universite05));
        System.out.println(notOrt74denByk(unv));
        System.out.println(matVarMi(unv));
        System.out.println(ogrSayisiBykKcgeSirala(unv));
        System.out.println(matBolSayisi(unv));
        System.out.println(ogrSayisi550FazlaEnBykUnvNotOrt(unv));
    }

    //Task 1: notOrt'larinin 74'den buyuk oldugunu kontrol eden method
    public static boolean notOrt74denByk(List<Universite> unv) {
        return unv.
                stream().
                allMatch(w -> w.getNotOrt() > 74);
    }

    //Task 2: Unv lerin herhangi birisinde "matematik" olup olmadgını kontrol eden method
    public static boolean matVarMi(List<Universite> unv) {
        return unv.
                stream().
                anyMatch(w -> w.getBolum().
                        toLowerCase().
                        contains("matematik"));
    }

    //Task 3: unv leri ogr sayilarina gore b->k siralayan method
    public static List<Universite> ogrSayisiBykKcgeSirala(List<Universite> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()). //Univesriler ogr sayisina gore tersten siralandi
                        collect(Collectors.toList()); //Stream yapi List yapisina donusturuldu
    }

    //Task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolSayisi(List<Universite> unv) {
        return (int) unv.stream().filter(w -> w.getBolum().contains("matematik")).count();
    }

    //Task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayisi550FazlaEnBykUnvNotOrt(List<Universite> unv) {
        return unv.
                stream().
                filter(w -> w.getOgrSayisi() > 550). //Unv ler filtrelendi
                        mapToInt(w -> w.getNotOrt()). //akış int data tipinde olacagını bildigimiz icin map claasına ait methodları kullanabilmek için "mapToInt" methodunu kullandık
                        max(); //akıştaki en yüksek değeri verir
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1050AzMinNotOrt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getOgrSayisi() < 1050).
                mapToInt(t -> t.getNotOrt()).
                min();
    }
}
