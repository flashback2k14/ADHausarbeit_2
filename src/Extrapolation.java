/**
 * Klasse zum Extrapolieren
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class Extrapolation {
    /**
     * Methode zum extrapolieren
     * @param x1 numerisch berechneter erste Ableitungswert
     * @param x2 numerisch berechneter erste Ableitungswert (Nachfolgerwert von x1)
     * @param alpha Fehlerordnung
     * @param beta Unterschiedswert der beiden Abstandswert
     * @return numerisch berechnet, extrapolierte erste Ableitung
     */
    public double extrapolation(double x1, double x2, double alpha, double beta) {
        return (x2 - Math.pow(beta, alpha) * x1) / (1 - Math.pow(beta, alpha));
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
