package funktionen;
/**
 * Interface Klasse fuer Funktion
 *
 * Funktionsklassen, welche dieses Interface implementieren
 * muessen die folgenden Methoden besitzen
 *
 * erstellt von Sebastian Kloppe am 31.08.2015
 */
public interface IFunktion {
    /**
     * Mehode, welche das exakte Ergebnis der Funktion
     * an der Stelle X zurueck gibt
     * @return extakte Ergebnis f(x)
     */
    double getExaktFstrichVonX();

    /**
     * Methode, welches das exakte Ergebnis der Funktion f(x)
     * an der Stelle X berechnet mittels Maschinengenauigkeit
     * @param x x - Koordinate
     * @return Funktionswert f(x)
     */
    double von(double x);
}
