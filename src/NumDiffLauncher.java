/**
 * Startklasse
 * Created by Sebastian Kloppe on 23.08.2015.
 */
public class NumDiffLauncher {

    public static void main(String[] args) {
        // Initialisierung und Deklaration der Mantisse
        final int mantisse = 12;
        // Initialisierung und Deklaration der Funktionsklasse
        Funktion f = new Funktion();
        // Initialisierung und Deklaration der Differenzierenklasse mit Mantissenlänge 12
        Differenzieren d = new Differenzieren(mantisse);
        /**
         * Berechnung der ersten Ableitung
         */
        // Numerische Berechnung der ersten Ableitung
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Berechnung der ersten Ableitung - Zwischenschritte");
        System.out.println("-------------------------------------------------------------------------");
        // Numerisch berechnete erste Ableitung ausgeben
        double y1 = d.numerisch(f, 4);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Berechnung der ersten Ableitung mit Extrapolation - Zwischenschritte");
        System.out.println("-------------------------------------------------------------------------");
        // Numerisch berechnete erste Ableitung mit Extrapolation ausgeben
        double y11 = d.numerischMitExtrapolation(f, 4);
        // Ausgabe der Ergebnisse
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Ergebnis der Berechnungen");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("f'(4) \t\t\t\t\t= " + f.get_F_STRICH_VON_4());
        System.out.println("num. f'(4) \t\t\t\t= " + Utilities.runden(y1, mantisse));
        System.out.println("extrapol. num. f'(4) \t= " + Utilities.runden(y11, mantisse));
        System.out.println("-------------------------------------------------------------------------");
        /**
         * Berechnung der Fehler
         */
        // Direkte Fehlerberechnung
        double direkterFehler = f.get_F_STRICH_VON_4() - y1;
        System.out.println("Fehler gegenueber num. Berechnung: \t\t\t\t\t\t" + Utilities.runden(direkterFehler, mantisse));
        double direkterFehler1 = f.get_F_STRICH_VON_4() - y11;
        System.out.println("Fehler gegenueber num. Berechnung mit Extrapolation: \t" + Utilities.runden(direkterFehler1, mantisse));
        System.out.println("-------------------------------------------------------------------------");
        // Berechnung Einseitige Fehlerwerte
        System.out.println("Einseitige Fehlerwerte");
        System.out.println("-------------------------------------------------------------------------");
        // Berechnung Gesamtfehler einseitiger Differenzformel
        double gesamtfehlerEinseitigeFormel = d.getEinseitigeDiffformelFehler(f, 4);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Gesamtfehler einseitiger Differenzformel: \t" + Utilities.runden(gesamtfehlerEinseitigeFormel, mantisse));
        System.out.println("-------------------------------------------------------------------------");
        // Zentrale Fehlerwerte
        System.out.println("Zentrale Fehlerwerte");
        System.out.println("-------------------------------------------------------------------------");
        // Berechnung Gesamtfehler zentralter Differenzformel
        double gesamtfehlerZentraleFormel = d.getZentraleDiffformelFehler(f, 4);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Gesamtfehler zentraler Differenzformel: \t" + Utilities.runden(gesamtfehlerZentraleFormel, mantisse));
        System.out.println("-------------------------------------------------------------------------");
    }
}
