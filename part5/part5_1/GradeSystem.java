package part5.part5_1;

import java.util.*;

/**
 * Задание 5.1 — Система оценок (enum, record, EnumMap, EnumSet)
 *
 * Тема: перечисления (enum), записи (record), EnumMap и EnumSet.
 *
 * Ключевая теория:
 *   - enum — перечисление фиксированных констант. Может иметь поля,
 *     конструктор и методы.
 *   - record (Java 16+) — неизменяемый класс данных. Компилятор генерирует
 *     конструктор, геттеры, equals(), hashCode(), toString().
 *   - Компактный конструктор record: Student { if (name == null) throw ...; }
 *     — без списка параметров, с доступом к ним.
 *   - EnumMap<K, V> — Map, оптимизированный для enum-ключей.
 *     Внутри — массив по ordinal(), O(1) доступ.
 *   - EnumSet — Set для enum, реализован как битовая маска, очень быстрый.
 *
 * Как запустить: нажмите ▶ рядом с main.
 */

public class GradeSystem {

    public enum Grade {
        A("Отлично", 4.0),
        B("Хорошо", 3.0),
        C("Удовлетворительно", 2.0),
        D("Неудовлетворительно", 1.0),
        F("Провал", 0.0);

        private final String description;
        private final double gpaValue;

        Grade(String description, double gpaValue) {
            this.description = description;
            this.gpaValue = gpaValue;
        }

        public String getDescription() {
            return description;
        }

        public double getGpaValue() {
            return gpaValue;
        }

        public boolean isPassing() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return this == A || this == B || this == C;
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        public static Grade fromScore(int score) {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            if (score >= 90) return A;
            if (score >= 80) return B;
            if (score >= 70) return C;
            if (score >= 60) return D;
            return F;
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }
    }

    public record Student(String name, int id) {
        public Student {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым");
            }
            if (id <= 0) {
                throw new IllegalArgumentException("ID должен быть положительным");
            }
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }
    }

    public static void main(String[] args) {
        // Создаём студентов и их оценки
        Student[] students = {
                new Student("Алиса", 1),
                new Student("Борис", 2),
                new Student("Вера", 3),
                new Student("Глеб", 4),
                new Student("Дарья", 5),
                new Student("Егор", 6)
        };

        int[] scores = {95, 82, 76, 58, 88, 91};

        // Создаём EnumMap для группировки
        EnumMap<Grade, List<Student>> gradeMap = new EnumMap<>(Grade.class);
        for (Grade g : Grade.values()) {
            gradeMap.put(g, new ArrayList<>());
        }

        // Группируем студентов по оценкам
        double totalGPA = 0;
        for (int i = 0; i < students.length; i++) {
            Grade grade = Grade.fromScore(scores[i]);
            gradeMap.get(grade).add(students[i]);
            totalGPA += grade.getGpaValue();
        }

        // Выводим сводку
        System.out.println("=== Распределение оценок ===\n");
        for (Grade grade : Grade.values()) {
            List<Student> list = gradeMap.get(grade);
            if (!list.isEmpty()) {
                System.out.printf("%s (%s): %d студент(ов)%n",
                        grade, grade.getDescription(), list.size());
                for (Student s : list) {
                    System.out.println("  - " + s.name());
                }
                System.out.println();
            }
        }

        // Используем EnumSet для проходных оценок
        EnumSet<Grade> passingGrades = EnumSet.of(Grade.A, Grade.B, Grade.C);

        System.out.println("=== Проходные оценки ===");
        int passingCount = 0;
        for (Grade g : passingGrades) {
            passingCount += gradeMap.get(g).size();
        }
        System.out.println("Студентов с проходными оценками: " + passingCount);

        // Средний GPA
        double averageGPA = totalGPA / students.length;
        System.out.printf("%nСредний GPA: %.2f%n", averageGPA);
    }
}