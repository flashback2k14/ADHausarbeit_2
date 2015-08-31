import funktionen.IFunktion;
/**
 * Klasse zum numerischen Differenzieren
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class Differentiation {
    /**
     * Methode zum numerischen Differenzieren mir Fehlerordnung h^2
     * @param f Funktion
     * @param x x - Koordinate
     * @param h Abstandswert
     * @return numerisch berechnete erste Ableitung
     */
    public double differenzieren_h_2(IFunktion f, double x, double h) {
        return (f.von(x + h) - f.von(x - h)) / (2 * h);
    }

    /**
     * Methode zum numerischen Differenzieren mir Fehlerordnung h^4
     * @param f Funktion
     * @param x x - Koordinate
     * @param h Abstandswert
     * @return numerisch berechnete erste Ableitung
     */
    public double differenzieren_h_4(IFunktion f, double x, double h) {
        return (f.von(x - 2 * h) - 8 * f.von(x - h) + 8 * f.von(x + h) - f.von(x + 2 * h)) / (12 * h);
    }

    /**
     * Hilfemethode zum Ausgeben des berechneten Ergebnisses
     * @param abstandswert Abstandsert
     * @param differenzierterWert numerisch berechnete erste Ableitung
     * @param fehlerWert Fehlerwert (exakte - numerisch berechnet)
     * @param mantisse Mantissenlaenge zum Runden
     */
    public void ergebnisAusgeben(double abstandswert, double differenzierterWert, double fehlerWert, int mantisse) {
        System.out.printf("h: \t %s \t|\t numerische Ableitung: \t\t %s \t|\t abs. Fehler: \t %s \n",
                abstandswert, Util.runden(differenzierterWert, mantisse), Util.runden(fehlerWert, mantisse));
    }
}
