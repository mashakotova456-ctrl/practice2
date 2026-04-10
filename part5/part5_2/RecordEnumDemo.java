package part5.part5_2;

/**
 * Задание 5.2 — Record с бизнес-логикой и Enum с абстрактным методом
 *
 * Тема: record с методами, enum с индивидуальной реализацией.
 *
 * Ключевая теория:
 *   - Record может содержать произвольные методы (не только геттеры).
 *   - Enum может объявить абстрактный метод — каждая константа обязана его реализовать.
 *   - Формулы конверсии температуры:
 *     C→F: C × 9/5 + 32;
 *     C→K: C + 273.15;
 *     F→C: (F − 32) × 5/9;
 *     K→C: K − 273.15.
 *   - Абсолютный ноль = 0 K = −273.15 °C = −459.67 °F.
 *
 * Как запустить: нажмите ▶ рядом с main.
 */

public class RecordEnumDemo {

    // Record Temperature
    public record Temperature(double value, Unit unit) {

        public enum Unit {
            CELSIUS, FAHRENHEIT, KELVIN
        }

        public Temperature {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            // Проверяем абсолютный ноль (0 K = -273.15 °C = -459.67 °F)
            double kelvin = switch (unit) {
                case CELSIUS -> value + 273.15;
                case FAHRENHEIT -> (value - 32) * 5.0/9.0 + 273.15;
                case KELVIN -> value;
            };

            if (kelvin < 0) {
                throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля");
            }
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        public Temperature convertTo(Unit targetUnit) {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            // Сначала переводим в Кельвины
            double kelvin = switch (unit) {
                case CELSIUS -> value + 273.15;
                case FAHRENHEIT -> (value - 32) * 5.0/9.0 + 273.15;
                case KELVIN -> value;
            };

            // Затем переводим из Кельвинов в целевую единицу
            return switch (targetUnit) {
                case CELSIUS -> new Temperature(kelvin - 273.15, Unit.CELSIUS);
                case FAHRENHEIT -> new Temperature(kelvin * 9.0/5.0 - 459.67, Unit.FAHRENHEIT);
                case KELVIN -> new Temperature(kelvin, Unit.KELVIN);
            };
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        @Override
        public String toString() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return switch (unit) {
                case CELSIUS -> String.format("%.2f °C", value);
                case FAHRENHEIT -> String.format("%.2f °F", value);
                case KELVIN -> String.format("%.2f K", value);
            };
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }
    }

    // Enum MathOperation
    public enum MathOperation {
        ADD {
            @Override
            public double apply(double a, double b) {
                // ▼ ВАШ КОД ЗДЕСЬ ▼
                return a + b;
                // ▲ КОНЕЦ ВАШЕГО КОДА ▲
            }
        },
        SUBTRACT {
            @Override
            public double apply(double a, double b) {
                // ▼ ВАШ КОД ЗДЕСЬ ▼
                return a - b;
                // ▲ КОНЕЦ ВАШЕГО КОДА ▲
            }
        },
        MULTIPLY {
            @Override
            public double apply(double a, double b) {
                // ▼ ВАШ КОД ЗДЕСЬ ▼
                return a * b;
                // ▲ КОНЕЦ ВАШЕГО КОДА ▲
            }
        },
        DIVIDE {
            @Override
            public double apply(double a, double b) {
                // ▼ ВАШ КОД ЗДЕСЬ ▼
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return a / b;
                // ▲ КОНЕЦ ВАШЕГО КОДА ▲
            }
        };

        public abstract double apply(double a, double b);
    }

    public static void main(String[] args) {
        Temperature body = new Temperature(36.6, Temperature.Unit.CELSIUS);
        System.out.println(body);
        System.out.println(body.convertTo(Temperature.Unit.FAHRENHEIT));
        System.out.println(body.convertTo(Temperature.Unit.KELVIN));

        System.out.println();

        double a = 10, b = 3;
        for (MathOperation op : MathOperation.values()) {
            System.out.printf("%s(%g, %g) = %g%n", op.name(), a, b, op.apply(a, b));
        }
    }
}