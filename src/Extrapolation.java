/**
 * Klasse zum Extrapolieren
 * Created by Sebastian Kloppe on 25.08.2015.
 */
public class Extrapolation {
    // Stützstellen (x - Komponente)
    private double[] x;
    // Spaltenvektor (y - Komponente)
    private double[] a;
    // Partialsumme
    private double sum = 0;
    // Faktor (0 - x_0) ... (0 - x_j-1)
    private double factor = 1;
    // aktuelle Spalte
    private int j = 0;
    // Initalgröße und Inkrement
    private final int N = 13;

    public Extrapolation(double x, double y) {
        // Initialisierung leeres Array
        this.x = new double[N];
        // Festlegung der ersten Stützstelle
        this.x[0] = x;
        // Initialisierung leere Spalte
        this.a = new double[N];
        // Festlegung des ersten Stützpunktes (Y)
        this.a[0] = y;
        // Partialsumme = a'_0
        this.sum = y;
    }

    /**
     * Ermittlung der nächsten Stützstelle
     * @param x Stützstelle
     * @param y Spaltenvektorstelle
     * @return Rückgabe Stützstelle
     */
    public double naechsteStuetzstelle(double x, double y) {
        // aktuelle Spalte
        this.j++;
        // ggf. Arrays vergrößern
        if (this.j >= this.a.length) {
            this.resizeArrays(++this.j);
        }
        // nächste Stützstelle
        this.x[this.j] = x;
        // Faktor * (0 - x_j-1)
        this.factor = this.factor * (-this.x[j-1]);
        // neue Stützstelle
        this.a[this.j] = y;
        // neue Spalte berechnen
        this.newton();
        // Partialsumme = sum + a'_j(x - x_0)...(x - x_j-1)
        this.sum = this.sum + this.a[0] * this.factor;
        // Rückgabe neue Approximation
        return this.sum;
    }

    /**
     * Vergrößerung der Arrays für Stützstellen und Spaltenvektor
     * @param neueGroesze neue Größe der Arrays
     */
    private void resizeArrays(int neueGroesze) {
        // Vergtößerung Stützstellen Array
        double[] tempX = this.x;
        this.x = new double[neueGroesze];
        this.x = tempX;
        // Vergrößerung des Spaltenvektors
        double[] tempA = this.a;
        this.a = new double[neueGroesze];
        this.a = tempA;
    }

    /**
     * Newton Verfahren - Vertauschung der unteren Zeile mit der oberen Zeile
     */
    private void newton() {
        // Zeile unten --> oben
        for (int i = this.j - 1; i >= 0; i--) {
            this.a[i] = (this.a[i + 1] - this.a[i]) / (this.x[this.j] - this.x[i]);
        }
    }
}
