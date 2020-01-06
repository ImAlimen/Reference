import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Třída {@code Main} slouží ke spouštění programu
 *
 * @author Jonáš Merxbauer
 * @version 191218
 */
public class Main {

    /**
     * Scanner
     */
    public static Scanner sc = new Scanner(System.in);
    private static final ByteArrayOutputStream redir_out = new ByteArrayOutputStream();

    /**
     * Hlavní metoda programu
     * @param args
     */
    public static void main(String[] args) {
        GUI gui = new GUI(7, 5, sc);
        Svet svet = new Svet(7, 5, new char[] {
                '#','#','#','#','#','#','#',
                '#',' ','#',' ',' ',' ','#',
                '#',' ','#',' ',' ',' ','#',
                '#',' ',' ',' ','#',' ','#',
                '#','#','#','#','#','#','#',
        });
        Postava postava = new Postava(svet, 1,1, 4, 1);
        if (spust(gui, svet, postava)) {
            System.out.print("\nKonecne doma...");
        } else {
            System.out.print("\nAsi jsem se ztratil...");
        }

    }

    /**
     * Spustí hru v nekonečné smyčce, dokuď postava nenarazí do zdi nebo nedojde domu
     * @param gui Plátno
     * @param svet Svět
     * @param postava Postava
     * @return boolean zda je doma nebo narazil
     */
    public static boolean spust(GUI gui, Svet svet, Postava postava) {
        svet.vykresli(gui);
        postava.vykresli(gui);
        gui.vykresli();
        System.out.print("\nkam dal?");
        while (postava.jdi(gui.nactiAkci()) && !postava.jeDoma()) {
            gui.smaz();
            svet.vykresli(gui);
            postava.vykresli(gui);
            gui.vykresli();
            System.out.print("\nkam dal?");
        }

        if (postava.jeDoma()) {
            return true;
        } else {
            return false;
        }
    }
}
