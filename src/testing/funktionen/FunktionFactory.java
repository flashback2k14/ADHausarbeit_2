package testing.funktionen;

/**
 *
 */
public class FunktionFactory {

    /**
     *
     * @param funktionsArt
     * @return
     */
    public static IFunktion erstellen(FunktionsArt funktionsArt) {
        switch (funktionsArt) {
            case UEBUNG6:
                return new FunktionUebung6();
            case THEMA12B:
                return new FunktionThema12B();
            default:
                return new FunktionThema12B();
        }
    }
}
