package part2.part2_1;

/**
 * Задание 2.1 — Разработчик (подкласс Employee)
 *
 * Формула бонуса: baseSalary * 0.12
 *
 * Подсказка для конструктора: вызовите super(name, baseSalary),
 * затем сохраните language.
 */
public class Developer extends Employee {

    private String language;

    public Developer(String name, double baseSalary, String language) {
        super(name, baseSalary);
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        this.language = language;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    public double calculateBonus() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return baseSalary * 0.12;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}