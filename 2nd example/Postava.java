package ppa1;

/**
 * Třída {@code ppa1.Postava} uchovává informace o postavě
 *
 * @author Jonáš Merxbauer
 * @version 191218
 */
public class Postava {

    /**
     * Svět na kterým je postava
     */
    private Svet svet;

    /**
     * Souřadnice postavy a domova
     */
    private int x, y, domovX, domovY;

    /**
     * Konstruktor postavy
     * @param svet Svět
     * @param startX Startovní pozice x
     * @param startY Startovní pozice y
     * @param domovX Pozice x domova
     * @param domovY Pozice y domova
     */
    public Postava(Svet svet, int startX, int startY, int domovX, int domovY) {
        this.svet = svet;
        x = startX;
        y = startY;
        this.domovX = domovX;
        this.domovY = domovY;
    }

    /**
     * Metoda zjistí, zda postava může jít daným směrem
     * @param smer Směr postavy
     * @return boolean zda může jít tímto směrem
     */
    public boolean jdi(Smer smer) {
        int novyX = 0, novyY = 0;
        switch (smer) {
            case JIH: novyY = 1; break;
            case SEVER: novyY = -1; break;
            case ZAPAD: novyX = -1; break;
            case VYCHOD: novyX = 1; break;
        }

        if (svet.uzemi(x + novyX, y + novyY) == ' ' || svet.uzemi(x + novyX, y + novyY) == '^') {
            x += novyX;
            y += novyY;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Zjistí, zda se postava nachází na stejné pozici jako domov
     * @return boolean zda se nachází v domové
     */
    public boolean jeDoma() {
        if (x == domovX && y == domovY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Vykreslí na plátno znak postavy a cíle
     * @param gui Plátno
     */
    public void vykresli(GUI gui) {
        gui.zapis(x, y, '@');
        gui.zapis(domovX, domovY, '^');
    }
}
