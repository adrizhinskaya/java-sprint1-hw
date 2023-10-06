import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    Scanner scanner;
    int goalByStepsPerDay = 10000;
    StepTracker(Scanner scan) {
        scanner = scan;
        for(int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца от 1 до 12 (включительно)");
        int month = scanner.nextInt();
        if(month < 1 || month > 12) {
            System.out.println("Неверное значение месяца\n");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if(day < 1 || day > 30) {
            System.out.println("Неверное значение дня\n");
            return;
        }

        System.out.println("Введите количество шагов");
        int stepsCount = scanner.nextInt();
        if(stepsCount < 0) {
            System.out.println("Количество шагов не может быть отрицательным\n");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = stepsCount;
    }

    void changeStepGoal() {
        System.out.println("Введите цель по количеству шагов в день");
        int newGoalByStepsPerDay = scanner.nextInt();
        if(newGoalByStepsPerDay <= 0) {
            System.out.println("Количество шагов не может быть меньше либо равно нулю\n");
            return;
        }
        goalByStepsPerDay = newGoalByStepsPerDay;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца от 1 до 12 (включительно)");
        int month = scanner.nextInt();
        if(month < 1 || month > 12) {
            System.out.println("Неверное значение месяца\n");
            return;
        }
        MonthData monthData = monthToData[month - 1];

        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц - " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце - " + monthData.maxSteps());
        System.out.println("Среднее количество шагов за месяц - " + monthData.averageSteps(sumSteps));
        System.out.println("Пройденная дистанция (в км) - " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий - " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия - " + monthData.bestSeries(goalByStepsPerDay) + " подряд");
    }
}
