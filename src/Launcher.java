import funktionen.FunktionFactory;
import funktionen.FunktionsArt;
import funktionen.IFunktion;
/**
 * Startklasse des Programms
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class Launcher {
    /**
     * Startmethode
     * @param args Kommandozeilenparameter
     */
    public static void main(String[] args) {
        // Deklaration und Initialisierung der Funktionsart
        FunktionsArt fa = Util.getFunktionsArt(args);
        // Deklaration und Initialisierung der benoetigten Klassen
        IFunktion f = FunktionFactory.erstellen(fa);
        Differentiation d = new Differentiation();
        Extrapolation ep = new Extrapolation();
        // Deklaration und Initialisierung der Mantissenlaenge zum Runden
        int mantisse = Util.getMantissenLaenge(args);
        // Deklaration und Initialisierung der x - Koordinate
        double x = Util.getXkoordinate(args);
        // Deklaration und Initialisierung der diskreten Abstandswerte h
        double[] diskAbstandswerte = {1e-1, 1e-2, 1e-3, 1e-4, 1e-5, 1e-6, 1e-7, 1e-8, 1e-9, 1e-10, 1e-11, 1e-12, 1e-13};

        System.out.println("#=======================================================================================#");
        System.out.println("#                                Numerische Differentiation                             #");
        System.out.println("#=======================================================================================#");

        // Ausgabe der Startwerte
        Util.getStartwerte(fa, f, x, mantisse);

        System.out.println("#=======================================================================================#");
        System.out.println("#                                     Fehlerordung h^2                                  #");
        System.out.println("#=======================================================================================#");

        // Deklaration und Initialisierung des Vorgaengerwerts, welcher fuer die Extrapolationsberechnung benoetigt wird
        double vorgaengerH2 = 0d;
        // Deklaration und Initialisierung von Variablen, welche fuer die Bestimmung der Genauigkeit benoetigt werden
        double besteGenauigkeitH2 = 1d;
        double besteGenauigkeitEpH2 = 1d;
        double besterAbstandswertH2 = 0d;
        double besterAbstandswertEpH2 = 0d;
        /**
         * numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^2
         */
        for (double h : diskAbstandswerte) {
            // Ermittlung der numerisch berechneten ersten Ableitung fuer die uebergebene Funktion
            // an der Stelle x fuer den jeweiligen Abstandswert
            double h2 = d.differenzieren_h_2(f, x, h);
            // Ermittlung des absoluten Fehlers, anhand des numerisch berechneten Wertes
            // und des exakt berechneten Wertes fuer die Funktion
            double fehlerH2 = h2 - f.getExaktFstrichVonX();
            // Ausgeben des Ergebnisses
            d.ergebnisAusgeben(h, h2, fehlerH2, mantisse);
            // Ermittlung der maximal erreichbaren Genauigkeit und des Abstandswert der numerischen Differenziation
            if (Math.abs(fehlerH2) < Math.abs(besteGenauigkeitH2)) {
                besteGenauigkeitH2 = fehlerH2;
                besterAbstandswertH2 = h;
            }
            /**
             * numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^2 und Extrapolation
             */
            // Ermittlung der numerisch berechneten ersten Ableitung mittels Extrapolation
            // des numerischen Wertes und dessen Vorgaengerwert
            double extrapolationH2 = ep.extrapolation(vorgaengerH2, h2, 2.0, 0.1);
            // Ermittlung des absoluten Fehlers, anhand des extrapolierten Wertes
            // und des exakt berechneten Wertes fuer die Funktion
            double fehlerExtrapolationH2 = extrapolationH2 - f.getExaktFstrichVonX();
            // Ausgeben des Ergebnisses
            ep.ergebnisAusgeben(h, extrapolationH2, fehlerExtrapolationH2, mantisse);
            // Ermittlung der maximal erreichbaren Genauigkeit und des Abstandswert der Extrapolation
            if (Math.abs(fehlerExtrapolationH2) < Math.abs(besteGenauigkeitEpH2)) {
                besteGenauigkeitEpH2 = fehlerExtrapolationH2;
                besterAbstandswertEpH2 = h;
            }
            // Uebergabe der aktuell numerisch berechneten ersten Ableitung an die Vorgaengervariable
            // fuer Nutzung im Extrapolationsverfahren
            vorgaengerH2 = h2;
        }
        // Ausgabe der maximal erreichbaren Genauigkeit bei der numerischen Differentiation sowie des Abstandswertes
        System.out.printf("Num. Diff: Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n" , besterAbstandswertH2, Util.runden(besteGenauigkeitH2, mantisse));
        // Ausgabe der maximal erreichbaren Genauigkeit bei der Extrapolation sowie des Abstandswertes
        System.out.printf("Extrapolation: Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n\n" , besterAbstandswertEpH2, Util.runden(besteGenauigkeitEpH2, mantisse));

        System.out.println("#=======================================================================================#");
        System.out.println("#                                     Fehlerordung h^4                                  #");
        System.out.println("#=======================================================================================#");

        // Deklaration und Initialisierung des Vorgaengerwerts, welcher fuer die Extrapolationsberechnung benoetigt wird
        double vorgaengerH4 = 0d;
        // Deklaration und Initialisierung von Variablen, welche fuer die Bestimmung der Genauigkeit benoetigt werden
        double besteGenauigkeitH4 = 1d;
        double besteGenauigkeitEpH4 = 1d;
        double besterAbstandswertH4 = 0d;
        double besterAbstandswertEpH4 = 0d;
        /**
         * numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^4
         */
        for (double h : diskAbstandswerte) {
            // Ermittlung der numerisch berechneten ersten Ableitung fuer die uebergebene Funktion
            // an der Stelle x fuer den jeweiligen Abstandswert
            double h4 = d.differenzieren_h_4(f, x, h);
            // Ermittlung des absoluten Fehlers, anhand des numerisch berechneten Wertes
            // und des exakt berechneten Wertes fuer die Funktion
            double fehlerH4 = h4 - f.getExaktFstrichVonX();
            // Ausgeben des Ergebnisses
            d.ergebnisAusgeben(h, h4, fehlerH4, mantisse);
            // Ermittlung der maximal erreichbaren Genauigkeit und des Abstandswert der numerische Differentiation
            if (Math.abs(fehlerH4) < Math.abs(besteGenauigkeitH4)) {
                besteGenauigkeitH4 = fehlerH4;
                besterAbstandswertH4 = h;
            }
            /**
             * numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^4 und Extrapolation
             */
            // Ermittlung der numerisch berechneten ersten Ableitung mittels Extrapolation
            // des numerischen Wertes und dessen Vorgaengerwert
            double extrapolationH4 = ep.extrapolation(vorgaengerH4, h4, 4.0, 0.1);
            // Ermittlung des absoluten Fehlers, anhand des extrapolierten Wertes
            // und des exakt berechneten Wertes fuer die Funktion
            double fehlerExtrapolationH4 = extrapolationH4 - f.getExaktFstrichVonX();
            // Ausgeben des Ergebnisses
            ep.ergebnisAusgeben(h, extrapolationH4, fehlerExtrapolationH4, mantisse);
            // Ermittlung der maximal erreichbaren Genauigkeit und des Abstandswert der Extrapolation
            if (Math.abs(fehlerExtrapolationH4) < Math.abs(besteGenauigkeitEpH4)) {
                besteGenauigkeitEpH4 = fehlerExtrapolationH4;
                besterAbstandswertEpH4 = h;
            }
            // Uebergabe der aktuell numerisch berechneten ersten Ableitung an die Vorgaengervariable
            // fuer Nutzung im Extrapolationsverfahren
            vorgaengerH4 = h4;
        }
        // Ausgabe der maximal erreichbaren Genauigkeit bei der numerischen Differentiation sowie des Abstandswertes
        System.out.printf("Num. Diff: Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n" , besterAbstandswertH4, Util.runden(besteGenauigkeitH4, mantisse));
        // Ausgabe der maximal erreichbaren Genauigkeit bei der Extrapolation
        System.out.printf("Extrapolation: Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n\n", besterAbstandswertEpH4, Util.runden(besteGenauigkeitEpH4, mantisse));
    }
}
