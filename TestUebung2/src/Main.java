public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestObjekt testObjekt = new TestObjekt();
        Kommunikation kommunikation = new Kommunikation();

        TestObjektRunner testObjektRunner = new TestObjektRunner(testObjekt,kommunikation);

        TestObjektZugriff testObjektZugriff = new TestObjektZugriff(kommunikation);

        Thread t1 = new Thread(testObjektRunner);
        t1.start();

        int erg1 = testObjektZugriff.add(3);
        System.out.println(erg1);

        int erg2 = testObjektZugriff.add(67);
        System.out.println(erg2);

        testObjektRunner.shutdown();
        t1.interrupt();

        try{
            t1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Beendet");
    }
}
