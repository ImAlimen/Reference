import java.util.Scanner;

/**
 * Třída {@code Main} spouští celý program, načte data ze Scanner, vytvoří čtenáře a album a vypíše data o albu
 *
 * @author Jonáš Merxbauer
 * @version 20191215
 */
public class Main {

    /**
     * Hlavní metoda, která řídí celý program
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ctenar ctenar = new Ctenar(sc);
        Album album = new Album(ctenar);
        System.out.print(album.toString());
    }
}
