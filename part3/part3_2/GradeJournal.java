package part3.part3_2;

/**
 * Задание 3.2 — Зубчатый массив: журнал оценок
 *
 * Тема: зубчатые массивы (jagged arrays).
 *
 * Ключевая теория:
 *   - Зубчатый массив — двумерный массив, в котором каждая строка
 *     может иметь разную длину.
 *   - grades[i].length — количество оценок i-го студента.
 *
 * Ожидаемый вывод:
 *
 * === Журнал оценок ===
 * Алиса   | Оценок: 5 | Средний: 4.40 | Мин: 3 | Макс: 5
 * Борис   | Оценок: 3 | Средний: 3.33 | Мин: 3 | Макс: 4
 * Вера    | Оценок: 6 | Средний: 4.83 | Мин: 4 | Макс: 5
 * Глеб    | Оценок: 4 | Средний: 4.00 | Мин: 3 | Макс: 5
 *
 * Лучший студент: Вера (средний балл: 4.83)
 */


public class GradeJournal {

    public static double average(int[] grades) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static int max(int[] grades) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int max = grades[0];
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static int min(int[] grades) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int min = grades[0];
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static void main(String[] args) {
        String[] names = {"Алиса", "Борис", "Вера", "Глеб"};

        int[][] grades = {
                {5, 4, 5, 5, 3},           // Алиса
                {3, 3, 4},                  // Борис
                {5, 5, 5, 5, 5, 4},        // Вера
                {4, 3, 4, 5}                // Глеб
        };

        System.out.println("=== Журнал оценок ===");

        double maxAverage = 0;
        String bestStudent = "";

        for (int i = 0; i < names.length; i++) {
            double avg = average(grades[i]);
            int min = min(grades[i]);
            int max = max(grades[i]);

            System.out.printf("%-7s | Оценок: %d | Средний: %.2f | Мин: %d | Макс: %d%n",
                    names[i], grades[i].length, avg, min, max);

            if (avg > maxAverage) {
                maxAverage = avg;
                bestStudent = names[i];
            }
        }

        System.out.printf("%nЛучший студент: %s (средний балл: %.2f)%n", bestStudent, maxAverage);
    }
}