package funktionen;

/**
 * Funktionsklasse
 * Created by Sebastian Kloppe on 23.08.2015.
 */
public class FunktionThema12B implements funktionen.IFunktion {
    /**
     * berechnete Funktionswerte
     */
    private static final double exakt_f_strich_von_x = 3079.28161744;

    /**
     * 1. Ableitung
     * @return f'(4)
     */
    public double getExaktFstrichVonX() {
        return exakt_f_strich_von_x;
    }

    /**
     * Anwendung der FunktionThema12B
     * @param x x Koordinate
     * @return Funktionswert an der x Koordinate
     */
    public double von(double x) {
        double a = Math.pow(x, 2) + 3;
        double b = Math.pow(x, 2) + 2;
        double c = Math.log(b) + 4;
        double d = Math.sqrt(c);
        return Math.pow(a, d);
    }
}
