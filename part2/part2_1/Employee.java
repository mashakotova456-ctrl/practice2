package part2.part2_1;

/**
 * Задание 2.1 — Иерархия сотрудников (абстрактный класс)
 *
 * Тема: абстрактные классы и полиморфизм.
 *
 * Ключевая теория:
 *   - Абстрактный класс — класс с модификатором abstract. Нельзя создать
 *     его экземпляр напрямую (new Employee() — ошибка компиляции).
 *   - Абстрактный метод — метод без тела. Каждый подкласс обязан его реализовать.
 *   - Обычные (не абстрактные) методы абстрактного класса наследуются как есть.
 *   - Паттерн «шаблонный метод»: totalCompensation() вызывает
 *     calculateBonus(), но реализация бонуса зависит от подкласса.
 *
 * Примечание: запускать нужно EmployeeBonus.java, а не этот файл.
 */

    /**
     * Имя сотрудника. protected — доступно в подклассах.
     */

    /**
     * Базовый оклад. protected — доступно в подклассах.
     */
    /**
     * Конструктор абстрактного класса.
     * <p>
     * Подсказка: сохраните параметры в поля:
     * this.name = name; this.baseSalary = baseSalary;
     * <p>
     * Важно: конструктор абстрактного класса вызывается из подклассов
     * через super(name, baseSalary).
     */

    public abstract class Employee {

        protected String name;
        protected double baseSalary;

        public Employee(String name, double baseSalary) {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            this.name = name;
            this.baseSalary = baseSalary;
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        public String getName() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return name;
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        public double getBaseSalary() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return baseSalary;
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        public abstract double calculateBonus();

        public double totalCompensation() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return baseSalary + calculateBonus();
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        @Override
        public String toString() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return name + " | Оклад: " + baseSalary + " | Бонус: " + calculateBonus() + " | Итого: " + totalCompensation();
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }
    }
