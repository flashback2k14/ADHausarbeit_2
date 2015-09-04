package funktionen;
/**
 * Fabrikklasse
 *
 * Die Klasse dient zum Erzeugen des Funktionsobjektes,
 * welches im Programm verwendet werden soll
 *
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public class FunktionFactory {
    /**
     * Methode zum Erstellen des Funktionsobjektes, anhand der
     * uebergebenen Funktionsart
     * @param funktionsArt Funktion (UEBUNG6 oder THEMA12B)
     * @return Funktion
     */
    public static IFunktion erstellen(FunktionsArt funktionsArt) {
        switch (funktionsArt) {
            case UEBUNG6:
                return new FunktionUebung6();
            case THEMA12B:
                return new FunktionThema12B();
            case THEMA12A:
                return new FunktionThema12A();
            default:
                return new FunktionThema12B();
        }
    }
}
