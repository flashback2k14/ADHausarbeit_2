import funktionen.IFunktion;
/**
 *
 */
public class Differentiation {
    /**
     *
     * @param f
     * @param x
     * @param h
     * @return
     */
    public double differenzieren_h_2(funktionen.IFunktion f, double x, double h) {
        return (f.von(x + h) - f.von(x - h)) / (2 * h);
    }

    /**
     *
     * @param f
     * @param x
     * @param h
     * @return
     */
    public double differenzieren_h_4(IFunktion f, double x, double h) {
        return (f.von(x - 2 * h) - 8 * f.von(x - h) + 8 * f.von(x + h) - f.von(x + 2 * h)) / (12 * h);
    }

    /**
     *
     * @param abstandswert
     * @param differenzierterWert
     * @param fehlerWert
     * @param mantisse
     */
    public void ergebnisAusgeben(double abstandswert, double differenzierterWert, double fehlerWert, int mantisse) {
        System.out.printf("h: \t %s \t|\t numerische Ableitung: \t\t %s \t|\t abs. Fehler: \t %s \n",
                abstandswert, Util.runden(differenzierterWert, mantisse), Util.runden(fehlerWert, mantisse));
    }
}
