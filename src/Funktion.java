/**
 * Funktionsklasse
 * Created by Sebastian Kloppe on 23.08.2015.
 */
public class Funktion {
    /**
     * berechnete Funktionswerte
     */
    private static final double F_STRICH_VON_4 = 3079.28161744;

    /**
     * 1. Ableitung
     * @return f'(4)
     */
    public double get_F_STRICH_VON_4() {
        return F_STRICH_VON_4;
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
        double e = Math.pow(a, d);

        return e;
    }
}
