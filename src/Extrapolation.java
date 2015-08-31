/**
 * Klasse zum Extrapolieren
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class Extrapolation {
    /**
     * Methode zum extrapolieren mittels Richardson Verfahren
     * @param y1 numerisch berechneter erste Ableitungswert
     * @param y2 numerisch berechneter erste Ableitungswert (Vorgaengerwert von y1)
     * @return numerisch berechnet extrapolierte erste Ableitung
     */
    public double extrapolation(double y1, double y2) {
        return y2 + ((y2 - y1) / 3);
    }

    /**
     * Hilfemethode zum Ausgeben des berechneten Ergebnisses
     * @param abstandswert Abstandsert
     * @param differenzierterWert numerisch berechnete erste Ableitung
     * @param fehlerWert Fehlerwert (exakte - numerisch berechnet)
     * @param mantisse Mantissenlaenge zum Runden
     */
    public void ergebnisAusgeben(double abstandswert, double differenzierterWert, double fehlerWert, int mantisse) {
        System.out.printf("h: \t %s \t|\t Extrapolierte Ableitung: \t %s \t|\t abs. Fehler: \t %s \n\n",
                abstandswert, Util.runden(differenzierterWert, mantisse), Util.runden(fehlerWert, mantisse));
    }
}
