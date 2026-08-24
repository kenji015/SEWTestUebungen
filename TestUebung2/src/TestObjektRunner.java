public class TestObjektRunner implements Runnable {
    private final Kommunikation kommunikation;
    private final TestObjekt testObjekt;
    private volatile boolean running = true;
    public TestObjektRunner(TestObjekt testObjekt, Kommunikation kommunikation) {
        this.testObjekt = testObjekt;
        this.kommunikation = kommunikation;
    }

    public void shutdown() {
        this.running = false;
    }

    @Override
    public void run() {
        while(running) {
                Anfrage anfrage = kommunikation.getNextAnfrage();

                if (!running) {
                    break;
                }

                int ergebnis = testObjekt.add(anfrage.getZahl());
                anfrage.setErgebnis(ergebnis);
        }

    }
}
