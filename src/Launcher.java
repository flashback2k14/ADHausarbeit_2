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
        double besterAbstandswertH2 = 0d;

        // numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^2
        for (double h : diskAbstandswerte) {
            // Ermittlung der numerisch berechneten ersten Ableitung fuer die uebergebene Funktion
            // an der Stelle x fuer den jeweiligen Abstandswert
            double h2 = d.differenzieren_h_2(f, x, h);
            // Ermittlung des absoluten Fehlers, anhand des numerisch berechneten Wertes
            // und des exakt berechneten Wertes fuer die Funktion
            double fehlerH2 = h2 - f.getExaktFstrichVonX();
            // Ausgeben des Ergebnisses
            d.ergebnisAusgeben(h, h2, fehlerH2, mantisse);

            // numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^2 und Extrapolation
            if (vorgaengerH2 != 0d) {
                // Ermittlung der numerisch berechneten ersten Ableitung mittels Extrapolation
                // des numerischen Wertes und dessen Vorgaengerwert
                double extrapolationH2 = ep.extrapolation(h2, vorgaengerH2);
                // Ermittlung des absoluten Fehlers, anhand des extrapolierten Wertes
                // und des exakt berechneten Wertes fuer die Funktion
                double fehlerExtrapolationH2 = extrapolationH2 - f.getExaktFstrichVonX();
                // Ausgeben des Ergebnisses
                ep.ergebnisAusgeben(h, extrapolationH2, fehlerExtrapolationH2, mantisse);
                // Ermittlung der maximal erreichbaren Genauigkeit und des Abstandswert der Extrapolation
                if (Math.abs(fehlerExtrapolationH2) < Math.abs(besteGenauigkeitH2)) {
                    besteGenauigkeitH2 = fehlerExtrapolationH2;
                    besterAbstandswertH2 = h;
                }
            } else {
                System.out.printf("Vorgaengerwert fuer h: %s ist nicht vorhanden! Extrapolationsberechnung wird uebersprungen!\n\n", h);
            }
            // Uebergabe der aktuell numerisch berechneten ersten Ableitung an die Vorgaengervariable
            // fuer Nutzung im Extrapolationsverfahren
            vorgaengerH2 = h2;
        }
        // Ausgabe der maximal erreichbaren Genauigkeit bei der Extrapolation sowie des Abstandswertes
        System.out.printf("Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n\n" , besterAbstandswertH2, Util.runden(besteGenauigkeitH2, mantisse));

        System.out.println("#-----------------------------------------------------------#");
        System.out.println("#                       Fehlerordung h^4                    #");
        System.out.println("#-----------------------------------------------------------#");

        // Deklaration und Initialisierung des Vorgaengerwerts, welcher fuer die Extrapolationsberechnung benoetigt wird
        double vorgaengerH4 = 0d;
        // Deklaration und Initialisierung von Variablen, welche fuer die Bestimmung der Genauigkeit benoetigt werden
        double besteGenauigkeitH4;
        if (fa.equals(FunktionsArt.UEBUNG6)) {
            besteGenauigkeitH4 = 1d;
        } else {
            besteGenauigkeitH4 = 21d;
        }
        double besterAbstandswertH4 = 0d;

        // numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^4
        for (double h : diskAbstandswerte) {
            // Ermittlung der numerisch berechneten ersten Ableitung fuer die uebergebene Funktion
            // an der Stelle x fuer den jeweiligen Abstandswert
            double h4 = d.differenzieren_h_4(f, x, h);
            // Ermittlung des absoluten Fehlers, anhand des numerisch berechneten Wertes
            // und des exakt berechneten Wertes fuer die Funktion
            double fehlerH4 = h4 - f.getExaktFstrichVonX();
            // Ausgeben des Ergebnisses
            d.ergebnisAusgeben(h, h4, fehlerH4, mantisse);

            // numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^4 und Extrapolation
            if (vorgaengerH4 != 0d) {
                // Ermittlung der numerisch berechneten ersten Ableitung mittels Extrapolation
                // des numerischen Wertes und dessen Vorgaengerwert
                double extrapolationH4 = ep.extrapolation(h4, vorgaengerH4);
                // Ermittlung des absoluten Fehlers, anhand des extrapolierten Wertes
                // und des exakt berechneten Wertes fuer die Funktion
                double fehlerExtrapolationH4 = extrapolationH4 - f.getExaktFstrichVonX();
                // Ausgeben des Ergebnisses
                ep.ergebnisAusgeben(h, extrapolationH4, fehlerExtrapolationH4, mantisse);
                // Ermittlung der maximal erreichbaren Genauigkeit und des Abstandswert der Extrapolation
                if (Math.abs(fehlerExtrapolationH4) < Math.abs(besteGenauigkeitH4)) {
                    besteGenauigkeitH4 = fehlerExtrapolationH4;
                    besterAbstandswertH4 = h;
                }
            } else {
                System.out.printf("Vorgaengerwert fuer h: %s ist nicht vorhanden! Extrapolationsberechnung wird uebersprungen!\n\n", h);
            }
            // Uebergabe der aktuell numerisch berechneten ersten Ableitung an die Vorgaengervariable
            // fuer Nutzung im Extrapolationsverfahren
            vorgaengerH4 = h4;
        }
        // Ausgabe der maximal erreichbaren Genauigkeit bei der Extrapolation
        System.out.printf("Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n\n" , besterAbstandswertH4, Util.runden(besteGenauigkeitH4, mantisse));
    }
}
