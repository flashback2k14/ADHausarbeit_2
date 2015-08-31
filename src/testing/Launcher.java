package testing;


import testing.funktionen.FunktionFactory;
import testing.funktionen.FunktionsArt;
import testing.funktionen.IFunktion;

public class Launcher {

    public static void main(String[] args) {
        // Deklaration und Initialisierung der Funktionsart
        FunktionsArt fa = Util.getFunktionsArt(args);
        // Deklaration und Initialisierung der benötigten Klassen
        IFunktion f = FunktionFactory.erstellen(fa);
        Differentiation d = new Differentiation();
        Extrapolation ep = new Extrapolation();
        // Deklaration und Initialisierung der Mantissenlänge zum Runden
        int mantisse = Util.getMantissenLaenge(args);
        // Deklaration und Initialisierung der x - Koordinate
        double x = Util.getXkoordinate(args);
        // Deklaration und Initialisierung der diskreten Abstandswerte h
        double[] diskAbstandswerte = {1e-1, 1e-2, 1e-3, 1e-4, 1e-5, 1e-6, 1e-7, 1e-8, 1e-9, 1e-10, 1e-11, 1e-12, 1e-13};

        System.out.println("#=======================================================================================#");
        System.out.println("#                                Numerische Differentiation                             #");
        System.out.println("#=======================================================================================#");

        Util.getBerechnungswerte(fa, x, mantisse);

        System.out.println("#=======================================================================================#");
        System.out.println("#                                     Fehlerordung h^2                                  #");
        System.out.println("#=======================================================================================#");

        // wird für die Extrapolation benötigt
        double vorgaengerH2 = 0d;
        // wird für die Bestimmung der Genauigkeit benötigt
        double besteGenauigkeitH2 = 1d;
        double besterAbstandswertH2 = 0d;

        // numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^2
        for (double h : diskAbstandswerte) {
            double h2 = d.differenzieren_h_2(f, x, h);
            double fehlerH2 = h2 - f.getExaktFstrichVonX();

            d.ergebnisAusgeben(h, h2, fehlerH2, mantisse);

            if (vorgaengerH2 != 0d) {
                double extrapolationH2 = ep.extrapolation(h2, vorgaengerH2);
                double fehlerExtrapolationH2 = extrapolationH2 - f.getExaktFstrichVonX();

                ep.ergebnisAusgeben(h, extrapolationH2, fehlerExtrapolationH2, mantisse);

                if (Math.abs(fehlerExtrapolationH2) < Math.abs(besteGenauigkeitH2)) {
                    besteGenauigkeitH2 = fehlerExtrapolationH2;
                    besterAbstandswertH2 = h;
                }
            } else {
                System.out.printf("Vorgaengerwert fuer h: %s ist nicht vorhanden! Extrapolationsberechnung wird uebersprungen!\n\n", h);
            }

            vorgaengerH2 = h2;
        }
        // Ausgabe der maximal erreichbaren Genauigkeit bei der Extrapolation
        System.out.printf("Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n\n" , besterAbstandswertH2, Util.runden(besteGenauigkeitH2, mantisse));


        System.out.println("#-----------------------------------------------------------#");
        System.out.println("#                       Fehlerordung h^4                    #");
        System.out.println("#-----------------------------------------------------------#");

        // wird für die Extrapolation benötigt
        double vorgaengerH4 = 0d;
        // wird für die Bestimmung der Genauigkeit benötigt
        double besteGenauigkeitH4 = 21d;
        double besterAbstandswertH4 = 0d;

        // numerische Berechnung der ersten Ableitung mittels Fehlerordnung h^4
        for (double h : diskAbstandswerte) {
            double h4 = d.differenzieren_h_4(f, x, h);
            double fehlerH4 = h4 - f.getExaktFstrichVonX();

            d.ergebnisAusgeben(h, h4, fehlerH4, mantisse);

            if (vorgaengerH4 != 0d) {
                double extrapolationH4 = ep.extrapolation(h4, vorgaengerH2);
                double fehlerExtrapolationH4 = extrapolationH4 - f.getExaktFstrichVonX();

                ep.ergebnisAusgeben(h, extrapolationH4, fehlerExtrapolationH4, mantisse);

                if (Math.abs(fehlerExtrapolationH4) < Math.abs(besteGenauigkeitH4)) {
                    besteGenauigkeitH4 = fehlerExtrapolationH4;
                    besterAbstandswertH4 = h;
                }
            } else {
                System.out.printf("Vorgaengerwert fuer h: %s ist nicht vorhanden! Extrapolationsberechnung wird uebersprungen!\n\n", h);
            }

            vorgaengerH4 = h4;
        }

        // Ausgabe der maximal erreichbaren Genauigkeit bei der Extrapolation
        System.out.printf("Bei h: %s ist die beste Genauigkeit von %s vorhanden!\n\n" , besterAbstandswertH4, Util.runden(besteGenauigkeitH4, mantisse));
    }
}
