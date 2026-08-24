public class TestObjektZugriff {
    private Kommunikation kommunikation;

    public TestObjektZugriff(Kommunikation kommunikation) {
        this.kommunikation = kommunikation;
    }

    public int add(int zahl) throws InterruptedException {
        Anfrage anfrage = new Anfrage(zahl);
        kommunikation.addAnfrage(anfrage);
        return anfrage.getErgebnis();
    }
}
