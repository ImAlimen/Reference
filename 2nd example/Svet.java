package ppa1;

/**
 * Třída {@code ppa1.Svet} vytváří bludiště
 *
 * @author Jonáš Merxbauer
 * @version 191218
 */
public class Svet {

    /**
     * Pole s bludištěm
     */
    private char[][] bludiste;

    /**
     * Kontruktor třídy Svet
     * @param sirka Šířka světa
     * @param vyska Výška světa
     * @param data Pole se znaky do světa
     */
    public Svet(int sirka, int vyska, char[] data) {
        bludiste = new char[vyska][sirka];
        int k = 0;
        for (int i = 0; i < vyska; i++) {
            for (int j = 0; j < sirka; j++) {
                bludiste[i][j] = data[k];
                k++;
            }
        }
    }

    /**
     * Vrátí typ území na XY
     * @param x Pozice na ose x
     * @param y Pozice na ose y
     * @return char s typem území
     */
    public char uzemi(int x, int y) {
        try {
            return bludiste[y][x];
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Vykreslí svět na plátno
     * @param gui Plátno
     */
    public void  vykresli(GUI gui) {
        for (int i = 0; i < bludiste.length; i++) {
            for (int j = 0; j < bludiste[i].length; j++) {
                gui.zapis(j, i, bludiste[i][j]);
            }
        }
    }
}
