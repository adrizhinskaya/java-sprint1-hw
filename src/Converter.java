public class Converter {
    static final double STEP_LENGTH_KM = 0.00075;
    static final double STEP_WASTE_KKAL = 0.05;
    int convertToKm(int steps) {
        return (int) (STEP_LENGTH_KM * steps);
    }

    int convertStepsToKilocalories(int steps) {
        return (int) (steps * STEP_WASTE_KKAL);
    }
}
