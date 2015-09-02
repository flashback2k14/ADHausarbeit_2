import funktionen.FunktionsArt;
import funktionen.IFunktion;

/**
 * Hilfsklasse
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class Util {
    /**
     * Ermittlung der zu berechnenden Funktion anhand des übergebenen Kommandozeilen - Parameters.
     * Sollte kein Parameter übergeben wurden sein, wird die Funktion der Aufgabe 12B gesetzt.
     * @param konsolenParameter Konsolenparameter
     * @return FunktionsArt
     */
    public static FunktionsArt getFunktionsArt(String[] konsolenParameter) {
        if (konsolenParameter != null && konsolenParameter.length > 0) {
            switch (konsolenParameter[0].toUpperCase()) {
                case "UEBUNG6":
                    return FunktionsArt.UEBUNG6;
                case "THEMA12B":
                    return FunktionsArt.THEMA12B;
                default:
                    return FunktionsArt.THEMA12B;
            }
        } else {
            return FunktionsArt.THEMA12B;
        }
    }

    /**
     * Ermittlung der Mantissenlänge anhand des übergebenen Kommandozeilen - Parameters.
     * Sollte kein Parameter übergeben wurden sein, wird die Mantissenlänge auf 12 gesetzt.
     * @param konsolenParameter Konsolenparameter
     * @return Mantissenlänge
     */
    public static int getMantissenLaenge(String[] konsolenParameter) {
        if (konsolenParameter != null && konsolenParameter.length > 0) {
            try {
                return Integer.parseInt(konsolenParameter[1]);
            } catch (NumberFormatException nfe) {
                System.out.println("Bei der Ermittlung der Mantissenlaenge ist ein Fehler ausgetreten! "
                        + nfe.getMessage());
                return -1;
            }
        } else {
            return 12;
        }
    }

    /**
     * Ermittlung der X - Koordinate anhand des übergebenen Kommandozeilen - Parameters.
     * Sollte kein Parameter übergeben wurden sein, wird die X - Koordinate auf 5.0 gesetzt.
     * @param konsolenParameter Konsolenparameter
     * @return X - Koordinate
     */
    public static double getXkoordinate(String[] konsolenParameter) {
        if (konsolenParameter != null && konsolenParameter.length > 0) {
            try {
                return Double.parseDouble(konsolenParameter[2]);
            } catch (NumberFormatException nfe) {
                System.out.println("Bei der Ermittlung der X - Koordinate ist ein Fehler ausgetreten! "
                        + nfe.getMessage());
                return -1.0;
            }
        } else {
            return 5.0;
        }
    }

    /**
     * Methode zum runden mit gegebener Mantissenlänge
     * @param zahl zu rundende Zahl
     * @param mantisse Mantissenlänge
     * @return gerundete Zahl
     */
    public static double runden(double zahl, int mantisse) {
        int i = (int)Math.ceil((Math.log((Math.abs(zahl)))/Math.log(10)));
        double d = Math.pow(10d, mantisse - i);
        return Math.round(zahl * d) / d;
    }

    /**
     * Methode zum ausgeben der Startwerte des Programms
     * @param funktionsArt Funktion (UEBUNG6 oder THEMA12B)
     * @param x x - Koordinate
     * @param mantisse Mantissenlaenge
     */
    public static void getStartwerte(FunktionsArt funktionsArt, IFunktion f, double x, int mantisse) {
        StringBuilder sb = new StringBuilder();
        switch (funktionsArt) {
            case UEBUNG6:
                sb.append("Funktion:\t\t\t\t\tUebung 6").append("\n");
                break;
            case THEMA12B:
                sb.append("Funktion:\t\t\t\t\tThema 12B").append("\n");
                break;
            default:
                break;
        }
        sb.append("X - Koordinate:\t\t\t\t").append(x).append("\n");
        sb.append("Mantisse:\t\t\t\t\t").append(mantisse).append("\n");
        sb.append("exaktes Ergebnis f'(").append(x).append("):\t").append(f.getExaktFstrichVonX());

        System.out.println(sb.toString());
    }
}
