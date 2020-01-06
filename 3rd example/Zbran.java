package ppa1;

/**
 * Třída {@code ppa1.Zbran} uchovává informace o zbrani
 *
 * @author Jonáš Merxbauer
 * @version 191218
 */
public class Zbran {
    /**
     * Název zbraně
     */
    private String nazev;

    /**
     * Útok a obrana zbraně
     */
    private int utok, obrana;

    /**
     * Konstruktor přiřadí zbrani jméno, útok a obranu
     * @param nazev Název zbraně
     * @param utok Útok zbraně
     * @param obrana Obrana zbraně
     */
    public Zbran(String nazev, int utok, int obrana) {
        this.nazev = nazev;
        this.utok = utok;
        this.obrana = obrana;
    }

    /**
     * Metoda vrátí hodnotu útoku zbraně
     * @return int s hodnotu útoku
     */
    public int getUtok() {
        return utok;
    }

    /**
     * Metoda vrátí hodnotu obrany zbraně
     * @return int s hodnotu obrany
     */
    public int getObrana() {
        return obrana;
    }

    /**
     * Metoda vrátí popis o zbrani
     * @return String s popisem o zbrani
     */
    @Override
    public String toString() {
        return  nazev + " (" + utok + "/" + obrana + ")";
    }
}
