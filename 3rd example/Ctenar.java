package ppa1;

import java.util.Scanner;

/**
 * Třída {@code ppa1.Ctenar} načte Scanner s informacemi z xml souboru, dokáže načíst vždy jednu řádku ze který může
 * vrátit název elementu, hodnotu elementu a nebo hodnotu atributu
 *
 * @author Jonáš Merxbauer
 * @version 20191215
 */
public class Ctenar {

    /**
     * Uložený Scanner z konstruktoru
     */
    private Scanner sc;

    /**
     * Načtená řádka
     */
    public String radka;

    /**
     * Konstrukto třídy {@code ppa1.Ctenar}
     * @param sc Scanner s xml souborem
     */
    public Ctenar(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Načte další řádku
     */
    public void nactiDalsiRadku() {
        if (sc.hasNextLine()) {
            radka = sc.nextLine();
        }
    }

    /**
     * Vrátí název elementu na řádce
     * @return String s názvem elementu
     */
    public String getElement() {

            if (radka.contains("<")) {
                String element = radka.substring(radka.indexOf("<") + 1, radka.indexOf(">"));
                if (element.contains(" ")) {
                    element = element.substring(0, element.indexOf(" "));
                }
                return element;
            } else {
                return "";
            }


    }

    /**
     * Vrátí hodnotu elementu
     * @return String s hodnotou elementu
     */
    public String getHodnota() {
        String hodnota = radka.substring(radka.indexOf(">") + 1, radka.indexOf("<", radka.indexOf("<") + 1));
        return hodnota;
    }

    /**
     * Vrátí hodnotu atributu zadané parametrem
     * @param nazev Název atributu
     * @return String s hodnotou atributu
     */
    public String getAtribut(String nazev) {
        if (radka.contains(nazev + "=\"")) {
            String atribut = radka.substring(radka.indexOf(nazev + "=\"") + nazev.length() + 2);
            atribut = atribut.substring(0, atribut.indexOf("\""));
            return atribut;
        } else {
            return null;
        }
    }
}
