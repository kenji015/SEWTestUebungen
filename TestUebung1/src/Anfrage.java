public class Anfrage {

    private final int zahl;
    private int ergebnis;
    private boolean erledigt = false;

    public Anfrage(int zahl) {
        this.zahl = zahl;
    }

    public int getZahl() {
        return zahl;
    }

    public synchronized void setErgebnis(int ergebnis) {
        this.ergebnis = ergebnis;
        erledigt = true;
        notifyAll();
    }

    public synchronized int getErgebnis() {
        while (!erledigt) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return ergebnis;
    }
}
