import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Kommunikation {

    private final BlockingQueue<Anfrage> queue = new LinkedBlockingQueue<>();

    public void addAnfrage(Anfrage anfrage) {
        try {
            queue.put(anfrage);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Anfrage getNextAnfrage() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
