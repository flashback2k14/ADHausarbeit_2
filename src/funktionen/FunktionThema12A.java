package funktionen;
/**
 * Funktionsklasse fuer Thema 12A
 * erstellt von Sebastian Kloppe am 02.09.2015
 */
public class FunktionThema12A implements IFunktion {
    /**
     * Deklaration und Initialisierung des exakten Ergebnisses von f(x)
     */
    private static final double exakt_f_strich_von_x = 0.586239420457;

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
        double a = Math.pow(Math.sin(x), 2);
        double b = Math.log(2 + Math.pow(x, 2));
        double c = a + b;
        return Math.sqrt(c);
    }
}
