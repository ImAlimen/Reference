package ppa1;

/**
 * Třída {@code ppa1.Stopa} uchovává informace o stopě
 *
 * @author Jonáš Merxbauer
 * @version 191219
 */
public class Stopa {

    /**
     * Název stopy
     */
    private String nazev;

    /**
     * Délka stopy
     */
    private int delka;

    /**
     * Hodnocení stopy
     */
    private double hodnoceni;

    /**
     * Konstruktor třídy
     * @param nazev Název stopy
     * @param delka Délka stopy
     * @param hodnoceni Hodnocení
     */
    public Stopa(String nazev, int delka, double hodnoceni) {
        this.nazev = nazev;
        this.delka = delka;
        this.hodnoceni = hodnoceni;
    }

    /**
     * Vrátí délku skladby
     * @return int s délkou
     */
    public int getDelka() {
        return delka;
    }

    /**
     * Vrátí hodnocení skladby
     * @return double s hodnocením
     */
    public double getHodnoceni() {
        return hodnoceni;
    }

    /**
     * Vypíše údaje o skladbě
     * @return String s údajema
     */
    @Override
    public String toString() {
        int sekundy = delka;
        int minuty = sekundy / 60;
        sekundy = sekundy - minuty * 60;

        String hvezdicky = Double.toString(Math.floor(hodnoceni));
        String tecky = Double.toString(hodnoceni - Math.floor(hodnoceni));

        switch (Double.valueOf(hvezdicky).intValue()) {
            case 1: hvezdicky = "*"; break;
            case 2: hvezdicky = "**"; break;
            case 3: hvezdicky = "***"; break;
            case 4: hvezdicky = "****"; break;
            case 5: hvezdicky = "*****"; break;
        }

        if (Double.valueOf(tecky) >= 0.25 && Double.valueOf(tecky) < 0.75) {
            hvezdicky += ".";
        } else if (Double.valueOf(tecky) >= 0.75) {
            hvezdicky += "*";
        }

        return String.format("%s [%d:%02d] (%s)", nazev, minuty, sekundy, hvezdicky);
    }
}
