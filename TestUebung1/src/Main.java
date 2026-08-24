public class Main {

    public static void main(String[] args) throws InterruptedException {

        TestObjekt testObjekt = new TestObjekt();
        Kommunikation kommunikation = new Kommunikation();
        TestObjektRunner runner = new TestObjektRunner(testObjekt, kommunikation);
        TestObjektZugriff zugriff = new TestObjektZugriff(kommunikation);

        Thread runnerThread = new Thread(runner);
        runnerThread.start();

        int erg1 = zugriff.add(3);
        System.out.println("Ergebnis 1: " + erg1);

        int erg2 = zugriff.add(67);
        System.out.println("Ergebnis 2: " + erg2);

        runner.shutdown();
        runnerThread.interrupt(); // Beendet


        try {
            runnerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Runner-Thread beendet.");

    }
}
