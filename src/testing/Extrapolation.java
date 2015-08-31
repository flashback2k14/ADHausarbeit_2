package testing;

/**
 *
 */
public class Extrapolation {
    /**
     *
     * @param y1
     * @param y2
     * @return
     */
    public double extrapolation(double y1, double y2) {
        return y2 + ((y2 - y1) / 3);
    }

    /**
     *
     * @param abstandswert
     * @param differenzierterWert
     * @param fehlerWert
     * @param mantisse
     */
    public void ergebnisAusgeben(double abstandswert, double differenzierterWert, double fehlerWert, int mantisse) {
        System.out.printf("h: \t %s \t|\t Extrapolierte Ableitung: \t %s \t|\t abs. Fehler: \t %s \n\n",
                abstandswert, Util.runden(differenzierterWert, mantisse), Util.runden(fehlerWert, mantisse));
    }
}
