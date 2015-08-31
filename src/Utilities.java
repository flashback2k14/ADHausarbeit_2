/**
 * Hilfsklasse zum Runden
 * Created by Sebastian Kloppe on 24.08.2015.
 */
public class Utilities {

    /**
     * Runden FunktionThema12B mit gegebener Mantissenlänge
     * @param zahl zu rundende Zahl
     * @param mantisse Mantissenlänge
     * @return gerundete Zahl
     */
    public static double runden(double zahl, int mantisse) {
        if (zahl == 0) {
            return zahl;
        } else {
            boolean isNegativ = false;
            /*Workaround for negative numbers*/
            if (Math.signum(zahl) < 0) {
                zahl = zahl * -1;
                mantisse++;
                isNegativ = true;
            }
            double exp = Math.abs(Math.ceil(Math.log10(zahl)));
            double d = Math.pow(10, mantisse - exp);
            double dd = Math.round(zahl * d) / d;
            if (isNegativ) {
                /*Workaround for negative numbers*/
                dd = dd * -1;
            }
            return dd;
        }
    }
}
