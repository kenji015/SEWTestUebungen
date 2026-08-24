package at.ac.tgm.mahrhofer;

/**
 * The system under test; uses a PID controller to control a motor's speed in RPM; that
 * is simulated by the {@link #actualRpm} Attribute.
 *
 * @author Clemens Koza
 */
public class SystemUnderTest {
    private final PidController controller = new PidController(0.08f, 0.05f, 0.001f);

    private float targetRpm;
    private float actualRpm;

    /**
     * Creates a system under test that is running at the given desired speed.
     *
     * @param initialRpm the initial value for actual and target rpm
     */
    public SystemUnderTest(float initialRpm) {
        this(initialRpm, initialRpm);
    }

    /**
     * Creates a system under test with the given initial actual and target
     * speed.
     *
     * @param initialRpm the initial value for actual rpm
     * @param targetRpm the initial value for target rpm
     */
    public SystemUnderTest(float initialRpm, float targetRpm) {
        this.actualRpm = initialRpm;
        this.targetRpm = targetRpm;
    }

    public void setTargetRpm(float targetRpm) {
        this.targetRpm = targetRpm;
    }

    public float getTargetRpm() {
        return targetRpm;
    }

    public float getActualRpm() {
        return actualRpm;
    }

    /**
     * Simulates one "step" in which the difference between actual and target
     * rpm is taken, put into the controller, and used to adjust the current
     * speed.
     */
    public void step() {
        float error = targetRpm - actualRpm;
        float correction = controller.step(error);
        actualRpm += correction;
    }
}
