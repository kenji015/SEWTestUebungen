public class TestObjektZugriff{
    private final Kommunikation kommunikation;

    public TestObjektZugriff(Kommunikation kommunikation) {
        this.kommunikation = kommunikation;
    }
    public int add(int zahl) {
        Anfrage anfrage = new Anfrage(zahl);
        kommunikation.addAnfrage(anfrage);
        return anfrage.getErgebnis();
    }
}
