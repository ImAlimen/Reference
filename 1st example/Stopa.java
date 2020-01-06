package ppa1;

/**
 * Třída {@code ppa1.Stopa} načte Čtenáře a zjistí číslo, název a délku skladby
 *
 * @author Jonáš Merxbauer
 * @version 20191215
 */
public class Stopa {
    /**
     * Číslo, délka skladby
     */
    private int cislo, delka;

    /**
     * Název skladby
     */
    private String nazev;

    /**
     * Konstruktor třídy {@code ppa1.Stopa}, který náčítá číslo, název a délku skladby
     * @param ctenar Čtenář zadaný v albu
     */
    public Stopa(Ctenar ctenar) {

        ctenar.nactiDalsiRadku();
        while (!ctenar.getElement().equals("/track")) {
            if (ctenar.getElement().equals("number")) {
                cislo = Integer.parseInt(ctenar.getHodnota());
            }
            if (ctenar.getElement().equals("title")) {
                nazev = ctenar.getHodnota();
            }
            if (ctenar.getElement().equals("length")) {
                delka = Integer.parseInt(ctenar.getHodnota());
            }
            ctenar.nactiDalsiRadku();

        }
    }

    /**
     * Vrátí číslo, název a délku skladby ve formátu
     * @return String s číslem, názevem a délkou skladby
     */
    @Override
    public String toString() {
        int sekundy = (int) Math.round((double)delka/1000);
        int minuty = sekundy / 60;
        sekundy = sekundy - minuty * 60;
        String stopa = String.format("%02d - %s [%d:%02d]", cislo, nazev, minuty, sekundy);
        return stopa;
    }
}