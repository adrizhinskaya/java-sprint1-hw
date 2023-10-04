public class Converter {
    int convertToKm(int steps) {
        return (int) (0.75 * steps / 1000);
    }

    int convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000;
    }
}
