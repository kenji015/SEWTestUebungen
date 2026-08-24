package at.ac.tgm.mahrhofer;

public class Main {
    public static void main(String[] args) {
        // the motor is initially standing still: 0 rpm - rotations per minute
        // the target is to reach 500 rpm
        SystemUnderTest s = new SystemUnderTest(0, 500);
        ConsoleGraph g = new ConsoleGraph(0, 1000);

        g.printLegend();
        g.printDatapoint(s.getActualRpm());
        for (int t = 0; t < 150; t++) {
            if (t == 500) {
                s.setTargetRpm(700);
            } else if (t == 2500) {
                s.setTargetRpm(300);
            }
            s.step();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }

            g.printDatapoint(s.getActualRpm());
        }

        System.out.println("Done!");
    }
}
