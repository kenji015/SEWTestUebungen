public class TestObjekt {
    private int summe;

    public TestObjekt() {
        this.summe = 0;
    }

    public int getSumme() {
        return summe;
    }
    public void setSumme(int summe) {
        this.summe = summe;
    }

    public int add(int zahl) {
        return summe += zahl;
    }
}
