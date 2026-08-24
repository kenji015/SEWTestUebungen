import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Kommunikation {
    public BlockingQueue<Anfrage> queue = new LinkedBlockingQueue<>();

    public void addAnfrage (Anfrage anfrage) throws InterruptedException {
        queue.put(anfrage);
    }

    public Anfrage getNextAnfrage()  {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            return null;
        }
    }
}
