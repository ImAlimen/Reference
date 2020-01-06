import java.util.Scanner;

/**
 * Třída {@code Main} slouží k zjištění zda zadané přirozené číslo lze rozložit na součet prvočísel
 *
 * @author Jonáš Merxbauer
 */
public class Main {
    /**
     * Scanner
     */
    private static Scanner in = new Scanner(System.in);

    /**
     * Hlavní metoda, která řídí celý program
     *
     * @param args
     */
    public static void main(String[] args) {
        int cislo = nactiPrirozeneCislo(in);
        int soucet = jeSoucetPrvocisel(cislo);
        if (soucet == 0) {
            System.out.print("Nelze rozlozit.");
        } else {
            System.out.print("Lze rozlozit: " + soucet + " + " + (cislo - soucet));
        }
    }

    /**
     * Metoda zjistí zda je číslo prvočíselm
     * @param cislo Číslo, které chceme ověřit
     * @return boolean zda se jedná nebo nejedná o prvočíslo
     */
    public static boolean jePrvocislo(int cislo) {
        if (cislo <= 1) {
            return false;
        }
        for (int i = 2; i < cislo; i++) {
            if (cislo % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metoda zjistí, zda zadané číslo je součtem prvočísel
     * @param cislo Číslo, které chceme ověřit
     * @return int Jeden ze sčítanců nebo když zjistí, že není součtem tak vrátí 0
     */
    public static int jeSoucetPrvocisel(int cislo) {
        for (int i = 2; i < cislo; i++) {
            if (jePrvocislo(i) && jePrvocislo(cislo - i)) {
                return i;
            }
        }

        return 0;
    }

    /**
     * Metoda načítá číslo z klávesnice a kontroluje zda se jedná o přirozené číslo
     * @param sc Scanner
     * @return int s přirozeným číslem
     */
    public static int nactiPrirozeneCislo(Scanner sc) {
        System.out.print("Zadej prirozene cislo: ");
        int cislo = sc.nextInt();

        while (cislo <= 0) {
            System.out.print("Zadej prirozene cislo: ");
            cislo = sc.nextInt();
        }
        return cislo;
    }
}
