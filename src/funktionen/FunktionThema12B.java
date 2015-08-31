package funktionen;
/**
 * Funktionsklasse fuer Thema 12B
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class FunktionThema12B implements funktionen.IFunktion {
    /**
     * Deklaration und Initialisierung des exakten Ergebnisses von f(x)
     */
    private static final double exakt_f_strich_von_x = 3079.28161744;

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
        double a = Math.pow(x, 2) + 3;
        double b = Math.pow(x, 2) + 2;
        double c = Math.log(b) + 4;
        double d = Math.sqrt(c);
        return Math.pow(a, d);
    }
}
