/**
 * Klasse zum numerischen Differentiation
 * Created by Sebastian Kloppe on 23.08.2015.
 */
public class Differenzieren {
    /**
     * Initialisieren der Instanzvariable Mantisse, welche zum Runden benötigt wird.
     */
    private int mantisse;
    /**
     * Initialisierung und Deklaration der Abstandswerte
     */
    private double[] abstandswerte = {1e-1, 1e-2, 1e-3, 1e-4, 1e-5, 1e-6, 1e-7, 1e-8, 1e-9, 1e-10, 1e-11, 1e-12, 1e-13};

    /**
     * Deklaration der Mantissenlänge mittels Konstruktorparameter.
     * @param mantisse Mantissenlänge
     */
    public Differenzieren(int mantisse) {
        this.mantisse = mantisse;
    }

    /**
     * Numerische Berechnung der ersten Ableitung
     * @param f FunktionThema12B
     * @param x x - Koordinate
     * @return erste Ableitung
     */
    public double numerisch(Funktion f, double x) {
        double d = 0;

        for (double h : this.abstandswerte) {
            d = differenzenQuotient(f, x, h);
            System.out.println("h: " + h + ", \td: " + Utilities.runden(d, this.mantisse));
        }

        return d;
    }

    public double numerischMitExtrapolation(Funktion f, double x) {
        // Startwert der Zählvariable für Abstandswert Array
        int count = 0;
        // Startwert der numerischen Differentiation + ausgeben
        double d = differenzenQuotient(f, x, this.abstandswerte[count]);
        System.out.println("h: " + this.abstandswerte[count] + ", \td: " + Utilities.runden(d, this.mantisse));
        // Hilfsvariable für aktuellen Differenzenquotientens
        double neuD = d;
        // Hilfsvariable für vorherigen Differenzenquotientens
        double altD;
        // Initialisierung und Deklaration der Extrapolation mit dem ersten Abstandwert und des ersten Differenzenquotientens
        Extrapolation extrapolation = new Extrapolation(this.abstandswerte[count], d);
        System.out.println("h: " + this.abstandswerte[count] + ", \td: " + Utilities.runden(d, this.mantisse) + " (extrapol.)");

        do {
            // Erhöhung der Zählvariable
            count++;
            // aktuelle wird zum vorherigen Differenzenquotientens
            altD = neuD;
            // nächsten Differenzenquotientens berechnen + ausgeben
            d = differenzenQuotient(f, x, this.abstandswerte[count]);
            System.out.println("h: " + this.abstandswerte[count] + ", \td: " + Utilities.runden(d, this.mantisse));
            // Ermittlung der nächsten Stützstelle + ausgeben
            neuD = extrapolation.naechsteStuetzstelle(this.abstandswerte[count], d);
            System.out.println("h: " + this.abstandswerte[count] + ", \td: " + Utilities.runden(neuD, this.mantisse) + " (extrapol.)");
        // Prüfung der Genauigkeit der Berechnung + Durchläufe
        } while (checkGenauigkeit(neuD, altD) && count < 12);

        // Rückgabe der Approximation
        return neuD;
    }

    /**
     * Berechnung des Differenzenquotienten (zentrale Differenzenformel)
     * Näherung an die Ableitung
     * [genauer als einseitige Differenzenformel]
     * @param f FunktionThema12B
     * @param x x - Koordinate
     * @param h Abstandswert
     * @return Differenzenquotienten
     */
    private double differenzenQuotient(Funktion f, double x, double h) {
        // return (f.von(x + h) - f.von(x - h)) / (2 * h);

        double a = f.von(x + h);
        double b = f.von(x - h);
        double c = a - b;
        double d = 2 * h;
        double e = c / d;

        return e;
    }

    /**
     * Prüfung der Genauigkeit
     * @param x Startwert
     * @param y Endwert
     * @return Ergebnis ist genau genug
     */
    private boolean checkGenauigkeit(double x, double y) {
        return Math.abs(x - y) > 1e-13;
    }

    /**
     * einseitige (rechtsseitige) Differenzenformel bei h > 0
     * [ungenauer als zentrale Differenzenformel]
     * @param f FunktionThema12B
     * @param x x - Koordinate
     * @param h Abstandswert
     * @return einseitige Differenz
     */
    private double einseitigeDifferenzenformel(Funktion f, double x, double h) {
        // return (f.von(x + h) - f.von(x)) / h;

        double a = f.von(x + h);
        double b = f.von(x);
        double c = a - b;
        double d = c / h;

        return Utilities.runden(d, this.mantisse);
    }

    /**
     * Berechnung der Fehler für die einseitige Formel aus
     * berechneten und numerisch berechneten Wert entlang der Abstandswerte.
     * @param f FunktionThema12B
     * @param x x - Koordinate
     * @return Resultat Gesamtfehler
     */
    public double getEinseitigeDiffformelFehler(Funktion f, double x) {
        double result = 0;

        for (double h : this.abstandswerte) {
            double tempResult = f.get_F_STRICH_VON_4() - einseitigeDifferenzenformel(f, x, h);
            System.out.println("h: " + h + ", \tFehler: " + tempResult);
            result += tempResult;
        }

        return result;
    }

    /**
     * Berechnung der Fehler für die zentrale Formel aus
     * berechneten und numerisch berechneten Wert entlang der Abstandswerte.
     * @param f FunktionThema12B
     * @param x x - Koordinate
     */
    public double getZentraleDiffformelFehler(Funktion f, double x) {
        double result = 0;

        for (double h : this.abstandswerte) {
            double tempResult = f.get_F_STRICH_VON_4() - differenzenQuotient(f, x, h);
            System.out.println("h: " + h + ", \tFehler: " + tempResult);
            result += tempResult;
        }

        return result;
    }
}
