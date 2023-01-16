package lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println();
        tekKupBirFazla(sayi);
        System.out.println();
        ciftKarakokPrint(sayi);
        System.out.println();
        maxElBul(sayi);
        System.out.println();
        ciftKareMaxPrint(sayi);
        System.out.println();
        elmToplam(sayi);
        System.out.println();
        ciftCarp(sayi);
        System.out.println();
        elEnKucuk(sayi);
        System.out.println();
        bestenBykEnKckTek(sayi);
        System.out.println();
        ciftElKareKBSort(sayi);

    }
    //Task: Functional programming ile listin cift elemanlarinin karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(w->w*w).forEach(Lambda01::yazdir);
    }
    //Task: Functional programming ile listin cift elemanlarinin karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void tekKupBirFazla(List<Integer> sayi){
        sayi.stream().filter(w->w%2!=0).map(w->(w*w*w)+1).forEach(Lambda01::yazdir);
    }
    //Task: Functional programming ile listin cift elemanlarinin kareköklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarakokPrint(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(w-> System.out.print(w+" "));
    }
    //Task: Listin en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi){
        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);
        System.out.print(maxSayi);
    }
    //Task: Listin cift elemanlarinin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer> sayi){
        System.out.print(sayi.stream().filter(Lambda01::ciftBul).map(w -> w * w).reduce(Integer::max));
    }
    //Task: Listin elemanlarinin toplamini yazdiriniz
    public static void elmToplam(List<Integer> sayi){
        System.out.print(sayi.stream().reduce(0, (a, b) -> a + b));
    }
    //Task: Listteki cift elemanlarin carpimini yazdiriniz
    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));// Method referance
        System.out.print(sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> a * b));// Lambda expression
    }
    //Task: Listteki elemanlardan en kucugunu print ediniz
    public static void elEnKucuk(List<Integer> sayi){
        System.out.print(sayi.stream().reduce(Integer::min));
    }
    //Task: Listteki 5 ten buyuk en kucuk tek sayiyi print ediniz
    public static void bestenBykEnKckTek(List<Integer> sayi){
        System.out.print(sayi.stream().filter(w -> w > 5 && w % 2 == 1).reduce(Integer::min));
    }
    //Task: Listin cift elemanlarinin karelerini kucuten buyuge ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftElKareKBSort(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(w->w*w).sorted().forEach(Lambda01::yazdir);
    }

}
