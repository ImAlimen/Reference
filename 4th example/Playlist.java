package ppa1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Třída {@code ppa1.Playlist} slouží k uchování informací o playlistu
 *
 * @author Jonáš Merxbauer
 * @version 191219
 */
public class Playlist {

    /**
     * Pole se stopama v playlistu
     */
    private Stopa[] stopy;

    /**
     * Konstruktor třídy
     * @param stopy Stopy v playlistu
     */
    public Playlist(Stopa[] stopy) {
        this.stopy = stopy;
    }

    /**
     * Vrátí celkovou délku všech stop
     * @return int s délkou
     */
    public int getCelkovaDelka() {
        int celkovaDelka = 0;
        for (Stopa stopa : stopy) {
            celkovaDelka += stopa.getDelka();
        }

        return celkovaDelka;
    }

    /**
     * Metoda vygeneruje z originálního playlistu nový, který obsahuje pouze stopy s hodnocením větším či rovno zadanému parametru
     * @param minHodnoceni Hodnocení
     * @return Playlist s písničkama
     */
    public Playlist filtrujHodnoceni(double minHodnoceni) {
        List<Stopa> noveStopy = new ArrayList<>();
        for (Stopa stopa : stopy) {
            if (stopa.getHodnoceni() >= minHodnoceni) {
                noveStopy.add(stopa);
            }
        }

        Stopa[] noveStopyPole = new Stopa[noveStopy.size()];
        noveStopyPole = noveStopy.toArray(noveStopyPole);

        return new Playlist(noveStopyPole);
    }

    /**
     * Metoda vygeneruje z originálního playlistu nový podle délky
     * @param minDelka Celková délka nových stop
     * @return Playlist
     */
    public Playlist vyberCelkovouDelku(int minDelka) {
        List<Stopa> noveStopy = new ArrayList<>();
        int celkovaDelka = 0;
        for (Stopa stopa : stopy) {
            celkovaDelka += stopa.getDelka();
            noveStopy.add(stopa);

            if (celkovaDelka >= minDelka) {
                break;
            }
        }

        Stopa[] noveStopyPole = new Stopa[noveStopy.size()];
        noveStopyPole = noveStopy.toArray(noveStopyPole);

        return new Playlist(noveStopyPole);
    }

    /**
     * Vytvoří nový playlist s náhodně přeházenýma písničkama
     * @return Playlist zamíchaný
     */
    public Playlist zamichej() {
        Random r = new Random();
        Stopa[] noveStopy = new Stopa[stopy.length];

        for (int i = 0; i < stopy.length; i++) {
            int novyIndex = r.nextInt(stopy.length);
            while (noveStopy[novyIndex] != null || novyIndex == i) {
                novyIndex = r.nextInt(stopy.length);
            }
            noveStopy[novyIndex] = stopy[i];
        }

        return new Playlist(noveStopy);
    }

    /**
     * Vypíše informace o playlistu
     * @return String s informacema
     */
    @Override
    public String toString() {
        String vypis = "";

        for (Stopa stopa : stopy) {
            vypis += stopa.toString() + "\n";
        }

        int sekundy = getCelkovaDelka();
        int minuty = sekundy / 60;
        sekundy = sekundy - minuty * 60;
        vypis += String.format("[%d:%02d]", minuty, sekundy);

        return vypis;
    }
}
