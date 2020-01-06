package ppa1;

import java.util.Scanner;

/**
 * Třída {@code ppa1.GUI} slouží k vykreslování hry na plátno
 *
 * @author Jonáš Merxbauer
 * @version 191218
 */
public class GUI {

    /**
     * Pole se znakama na plátně
     */
    private char[][] platno;

    /**
     * Scanner
     */
    private Scanner in;

    /**
     * Konstruktor třídy
     * @param sirka Šířka plátna
     * @param vyska Výška plátna
     * @param sc Scanner
     */
    public GUI(int sirka, int vyska, Scanner sc) {
        platno = new char[vyska][sirka];
        in = sc;
    }

    /**
     * Metoda smaže plátno
     */
    public void smaz() {
        /*
        for (char znaky[] : platno) {
            for (char znak : znaky) {
                znak = ' ';
            }
        }*/

        for (int i = 0; i < platno.length; i++) {
            for (int j = 0; j < platno[i].length; j++) {
                platno[i][j] = ' ';
            }
        }
    }

    /**
     * Metoda zakreslí znak na pozici na plátně
     * @param x Pozice na ose x
     * @param y Pozice na ose y
     * @param znak Znak, který se zakreslí
     */
    public void zapis(int x, int y, char znak) {
        platno[y][x] = znak;
    }

    /**
     * Metoda vykreslí znaky na plátno
     */
    public void vykresli() {
        for (int i = 0; i < platno.length; i++) {
            for (int j = 0; j < platno[i].length; j++) {
                System.out.print(platno[i][j]);
            }

            if (i < platno.length-1)
                System.out.print("\n");
        }
    }

    /**
     * Načte z klávesnice číslo na numerické klávesnici, které určí směr
     * @return Smer se směrem pohybu
     */
    public Smer nactiAkci() {
        int novySmer = in.nextInt();
        Smer smer;
        switch (novySmer) {
            case 2: smer = Smer.JIH; break;
            case 4: smer = Smer.ZAPAD; break;
            case 6: smer = Smer.VYCHOD; break;
            case 8: smer = Smer.SEVER; break;
            default: smer = null; break;
        }

        return smer;
    }
}
