package lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {

        /*
	 	1)  Lambda --> method create  etme değil mevcut method'ları(library)secip kullanmaktır...
	 	    Lambda’lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
	 	2)	"Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	 	    "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	 	3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
	     	ve hatasiz code yazma acilarindan cok faydalidir.
	 	4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir
	 	ancak map'lerde kullanılmaz.
	 	*/

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        //Task:"Structured Programming" kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde yazdiriniz
        printElStructured(sayi);
        System.out.println();
        //Task:"Functional Programming" kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde yazdiriniz
        printElFunctional(sayi);
        System.out.println();
        printElFunctional1(sayi);// Aralarina bosluk koyamadigimiz icin istedigimiz cozum bu degildir.
        System.out.println();
        printElFunctional3(sayi);// Aralarina bosluk koyabilmek icin kendimiz mehod olusturduk istedigimiz cozum bu.
        System.out.println();
        //Task: "Fuctional Programming" ile list elemanlarindan cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz.
        printCiftElFunctional(sayi);
        System.out.println();
        //Task: "Fuctional Programming" ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz.
        printCiftOtzKckFunctional(sayi);
        System.out.println();
        //Task: "Fuctional Programming" ile list elemanlarinin 34 den kucuk veya cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz.
        printCiftOtzBykFunctional(sayi);
    }

    //Task:"Structured Programming" kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde yazdiriniz
    public static void printElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }

    //Task:"Functional Programming" kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde yazdiriniz
    //1. Yol:
    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach((w) -> System.out.print(w + " "));// Lambda expression (Sadece methodlarla kod olusturamadigimizda eklemeler yapilmasina denir)
    }

    //2. Yol:
    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);// Method referance (Sadece methodlari kullanarak kod olusturmak demektir)
    }

    public static void yazdir(int a) {
        System.out.print(a + " ");
    }
    public static void yazdir(String a) {
        System.out.print(a + " ");
    }


    //3. Yol:
    public static void printElFunctional3(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);// Method referance (Sadece methodlari kullanarak kod olusturmak demektir)
    }

    //Task: "Fuctional Programming" ile list elemanlarindan cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz.
    public static void printCiftElFunctional(List<Integer> sayi) {
        sayi.stream().filter(w -> w % 2 == 0).forEach(Lambda01::yazdir);
    }

    public static boolean ciftBul(int a) {
        return a % 2 == 0;
    }

    //Task: "Fuctional Programming" ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz.
    public static void printCiftOtzKckFunctional(List<Integer> sayi) {
        sayi.stream().filter(w -> w % 2 == 0 && w < 34).forEach(Lambda01::yazdir);
    }

    //Task: "Fuctional Programming" ile list elemanlarinin 34 den kucuk veya cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz.
    public static void printCiftOtzBykFunctional(List<Integer> sayi) {
        sayi.stream().filter(w -> w % 2 == 0 || w > 34).forEach(Lambda01::yazdir);
    }

}
