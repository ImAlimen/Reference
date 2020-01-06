import java.util.Scanner;

/**
 * Třída {@code Main} slouží jako hlavní třída programu
 *
 * @author Jonáš Merxbauer
 * @version 191219
 */
public class Main {

    /**
     * Scanner
     */
    private static Scanner in = new Scanner(System.in);

    /**
     * Vstupní metoda programu
     * @param args Minimální hodnocení a délka
     */
    public static void main(String[] args) {
        double minHodnoceni = Double.parseDouble(args[0]);
        int minDelka = Integer.parseInt(args[1]);
        Playlist playlist = vytvorPlaylist(in);
        playlist = vyberStopy(minHodnoceni, minDelka, playlist);
    }

    /**
     * Vytvoří playlist
     * @param sc Informace ze Scanneru o playlistu
     * @return Playlist
     */
    public static Playlist vytvorPlaylist(Scanner sc) {
        int pocetStop = Integer.parseInt(sc.nextLine());

        Stopa[] stopy = new Stopa[pocetStop];

        for (int i = 0; i < stopy.length; i++) {
            String nazev = sc.nextLine();
            int delka = Integer.parseInt(sc.nextLine());
            double hodnoceni = Double.parseDouble(sc.nextLine());
            stopy[i] = new Stopa(nazev, delka, hodnoceni);
        }

        return new Playlist(stopy);
    }

    /**
     * Vybere z playlistu skladby podle hodnoceni a delky a prohazi je
     * @param minHodnoceni Minimální hodnocení
     * @param minDelka Minimální délka
     * @param playlist Playlist
     * @return Playlist nový
     */
    public static Playlist vyberStopy(double minHodnoceni, int minDelka, Playlist playlist) {
        Playlist p = playlist.filtrujHodnoceni(minHodnoceni);
        p = p.zamichej();
        Playlist q = p.vyberCelkovouDelku(minDelka);
        q.toString();

        if (p.getCelkovaDelka() == q.getCelkovaDelka()) {
            System.out.print("\nPOZOR! Playlist je kratky");
        }

        return q;
    }
}
