public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int stepsPerDay : days) {
            sumSteps += stepsPerDay;
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int stepsPerDay : days) {
            maxSteps = Math.max(maxSteps, stepsPerDay);
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0, finalSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            }
            if (day < goalByStepsPerDay) {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

    int averageSteps(int sumSteps) {
        return sumSteps / days.length;
    }
}
