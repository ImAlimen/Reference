package ppa1;

/**
 * Třída {@code ppa1.Postava} uchovává informace o postavě
 *
 * @author Jonáš Merxbauer
 * @version 20191218
 */
public class Postava {
    /**
     * Jméno postavy
     */
    private String jmeno;

    /**
     * Zdraví, síla, hbitosta vitalita postavy
     */
    private int zdravi, sila, hbitost, vitalita;

    /**
     * Zbraňe v lévé a pravé ruce
     */
    private Zbran leva, prava;

    /**
     * Kostrunktor přiřadí postavě jméno, sílu, hbitost a vitalitu
     * @param jmeno Jméno postavy
     * @param sila Síla postavy
     * @param hbitost Hbitost postavy
     * @param vitalita Vytalita postavy
     */
    public Postava(String jmeno, int sila, int hbitost, int vitalita) {
        this.jmeno = jmeno;
        this.sila = sila;
        this.hbitost = hbitost;
        this.vitalita = vitalita;
        zdravi = vitalita;
    }

    /**
     * Vezme zbraň do ruky, pokud jí v ruce již má, vrátí false
     * @param ruka Ruka, do který vezme zbraň
     * @param zbran Zbraň, kterou vezme do ruky
     * @return boolean zda vzal do ruky zbraň
     */
    public boolean vezmiZbran(Ruka ruka, Zbran zbran) {
        if (ruka == ruka.LEVA) {
            if (leva != null) {
                return false;
            } else {
                leva = zbran;
                return true;
            }
        } else {
            if (prava != null) {
                return false;
            } else {
                prava = zbran;
                return true;
            }
        }
    }

    /**
     * Postava se brání proti útoku
     * @param utok Útok nepřítele
     * @return int počet zranění
     */
    public int branSe(int utok) {
        int obrana = hbitost;
        if (leva != null) {
            obrana += leva.getObrana();
        }
        if (prava != null) {
            obrana += prava.getObrana();
        }
        if ((utok - obrana) <= 0) {
            return 0;
        }

        zdravi -= utok - obrana;
        return utok - obrana;
    }

    /**
     * Vrátí obranou sílu postavy
     * @return int s obranou sílou
     */
    private int getObranaSila() {
        int obrana = hbitost;
        if (leva != null) {
            obrana += leva.getObrana();
        }
        if (prava != null) {
            obrana += prava.getObrana();
        }

        return obrana;
    }

    /**
     * Metoda vrátí útočnou sílu postavy
     * @return int s útočnou sílou
     */
    public int zautoc() {
        int utok = 0;
        if (leva != null) {
            utok += leva.getUtok();
        }
        if (prava != null) {
            utok += prava.getUtok();
        }
        utok += sila;

        return utok;
    }

    /**
     * Metoda vrátí, zda je postava živá
     * @return boolean zda je živá
     */
    public boolean jeZiva() {
        if (zdravi > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metoda vrátí popis postavy
     * @return String s popisem
     */
    @Override
    public String toString() {
        return  jmeno + " [" + zdravi + "/" + vitalita + "] (" + zautoc() + "/" + getObranaSila() + ")";
    }
}
