package funktionen;
/**
 * Funktionsklasse fuer Uebungsaufgabe 6
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class FunktionUebung6 implements IFunktion {
    /**
     * Deklaration und Initialisierung des exakten Ergebnisses von f(x)
     */
    private static final double exakt_f_strich_von_x = 11.189073;

    /**
     * Methode gibt exakten Funktionswert der ersten Ableitung zurueck
     * @return exakten Funktionswert fuer f'(4)
     */
    public double getExaktFstrichVonX() {
        return exakt_f_strich_von_x;
    }

    /**
     * Anwendung der Funktion an der Stelle X
     * @param x x - Koordinate
     * @return Funktionswert
     */
    public double von(double x) {
        return 4 + 3 * Math.cos(x) + (-2) * Math.sin(2 * x) + Math.sin(5 * x);
    }
}
