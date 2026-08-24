public class Anfrage {
    private final int zahl;
    private int ergebnis;
    private boolean fertig = false;

    public Anfrage(int zahl) {
        this.zahl = zahl;
    }

    public int getZahl() {
        return zahl;
    }

    public synchronized void setErgebnis(int ergebnis) {
        this.ergebnis = ergebnis;
        this.fertig = true;
        notifyAll();
    }

    public synchronized int getErgebnis() throws InterruptedException {
        while(!this.fertig) {
            wait();
        }
        return ergebnis;
    }
}
