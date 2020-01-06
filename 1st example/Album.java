package ppa1;

/**
 * Třída {@code ppa1.Album} načte Čtenáře a zjistí název, počet skladeb a jednotlivé skladby
 *
 * @author Jonáš Merxbauer
 * @version 20191215
 */
public class Album {
    /**
     * Název alba
     */
    private String nazev;

    /**
     * Pole se skladbama v albu
     */
    Stopa[] stopy;

    /**
     * Konstruktor třídy {@code ppa1.Album}, který náčítá název, počet skladeb a jednotlivé skladby
     * @param ctenar Čtenář zadaný v albu
     */
    public Album(Ctenar ctenar) {
        int i = 0;
        ctenar.nactiDalsiRadku();
        while (!ctenar.getElement().equals("/release")) {
            if (ctenar.getElement().equals("title")) {
                nazev = ctenar.getHodnota();
            }
            if (ctenar.getElement().equals("track-list")) {
                if (ctenar.getAtribut("count") != null)
                    stopy = new Stopa[Integer.parseInt(ctenar.getAtribut("count"))];
            }
            if (ctenar.getElement().equals("track")) {
                stopy[i] = new Stopa(ctenar);
                i++;
            }

            ctenar.nactiDalsiRadku();
        }
    }

    /**
     * Vrátí název, počet skladeb a jednotlivé skladby
     * @return String s názevem, počtem skladeb a jednotlivýma skladbama
     */
    @Override
    public String toString() {
        String vypis = nazev + "\n";
        if (stopy != null) {
            for (int i = 0; i < stopy.length; i++) {
                vypis += "\n" + stopy[i].toString();
            }
        }

        return vypis;
    }
}
