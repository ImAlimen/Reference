import java.util.Scanner;

/**
 * Třída {@code Main} načítá postavu a její vybavení a provádí útok mezi dvěma postavami
 *
 * @author Jonáš Merxbauer
 * @version 191218
 */
public class Main {
    /**
     * Scanner
     */
    private static Scanner in = new Scanner(System.in);

    /**
     * Hlavní metoda, která řídí celý program
     * @param args
     */
    public static void main(String[] args) {
        Postava postava1 = nactiPostavu(in);
        Zbran leva = nactiZbran(in);
        Zbran prava = nactiZbran(in);
        vyzbrojPostavu(postava1, leva, prava);

        Postava postava2 = nactiPostavu(in);
        leva = nactiZbran(in);
        prava = nactiZbran(in);
        vyzbrojPostavu(postava2, leva, prava);

        Postava vitez = souboj(postava1, postava2);
        System.out.print("Vitez: " + vitez.toString());
    }

    /**
     * Načte postavu z Scanneru
     * @param sc Scanner
     * @return Postava
     */
    public static Postava nactiPostavu(Scanner sc) {
        String jmeno = sc.nextLine();
        int sila = Integer.parseInt(sc.nextLine());
        int hbitost = Integer.parseInt(sc.nextLine());
        int zdravi = Integer.parseInt(sc.nextLine());
        return new Postava(jmeno, sila, hbitost, zdravi);
    }

    /**
     * Načte zbraň ze Scanneru
     * @param sc Scanner
     * @return Zbran
     */
    public static Zbran nactiZbran(Scanner sc) {
        String nazev = sc.nextLine();
        if (nazev.isEmpty()) {
            return null;
        }
        int utok = Integer.parseInt(sc.nextLine());
        int obrana = Integer.parseInt(sc.nextLine());
        return new Zbran(nazev, utok, obrana);
    }

    /**
     * Vyzbrojí postavu
     * @param postava Postava, kterou vyzbrojí
     * @param leva Zbraň do levé ruky
     * @param prava Zbraň do pravé ruky
     */
    public static void vyzbrojPostavu(Postava postava, Zbran leva, Zbran prava) {
        postava.vezmiZbran(Ruka.LEVA, leva);
        postava.vezmiZbran(Ruka.PRAVA, prava);
    }

    /**
     * Metoda provádí souboj mezi dvěma postavami
     * @param postava1 První postava
     * @param postava2 Druhá postava
     * @return Postava vítěz v souboji
     */
    public static Postava souboj(Postava postava1, Postava postava2) {
        System.out.println("Souboj: " + postava1.toString() + " vs " + postava2.toString());

        while (postava1.jeZiva() && postava2.jeZiva()) {
            System.out.println("utoci " + postava1.toString() + "a dava " + postava2.branSe(postava1.zautoc()) + " zraneni");
            if (!postava2.jeZiva()) {
                return postava1;
            }

            System.out.println("utoci" + postava2.toString() + "a dava " + postava1.branSe(postava2.zautoc()) + " zraneni");
            if (!postava1.jeZiva()) {
                return postava2;
            }
        }

        return null;
    }
}
