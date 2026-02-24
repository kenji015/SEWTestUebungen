public class TestObjektRunner implements Runnable {

    private final TestObjekt testObjekt;
    private final Kommunikation kommunikation;
    private  boolean running = true;

    public TestObjektRunner(TestObjekt testObjekt, Kommunikation kommunikation) {
        this.testObjekt = testObjekt;
        this.kommunikation = kommunikation;
    }

    public void shutdown() {
        running = false;
        kommunikation.addAnfrage(new Anfrage(0));
    }

    @Override
    public void run() {
        while (running) {

            Anfrage anfrage = kommunikation.getNextAnfrage();

            if (!running) {
                break;
            }

            int ergebnis = testObjekt.add(anfrage.getZahl());
            anfrage.setErgebnis(ergebnis);
        }
    }
}
