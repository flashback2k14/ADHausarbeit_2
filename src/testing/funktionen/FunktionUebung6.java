package testing.funktionen;

public class FunktionUebung6 implements IFunktion {
    /**
     *
     */
    private static final double exakt_f_strich_von_x = 11.189073;

    /**
     *
     * @return
     */
    public double getExaktFstrichVonX() {
        return exakt_f_strich_von_x;
    }

    /**
     *
     * @param x
     * @return
     */
    public double von(double x) {
        return 4 + 3 * Math.cos(x) + (-2) * Math.sin(2 * x) + Math.sin(5 * x);
    }
}
