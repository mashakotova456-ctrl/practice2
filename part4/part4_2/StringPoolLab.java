package part4.part4_2;

/**
 * Задание 4.2 — Исследование String Pool
 *
 * Тема: String Pool, оператор == и метод .equals().
 *
 * Ключевая теория:
 *   - String Pool — специальная область памяти JVM, где хранятся
 *     уникальные строковые литералы.
 *   - Строковый литерал "Hello" попадает в пул. Все литералы с одинаковым
 *     содержимым ссылаются на один объект.
 *   - new String("Hello") создаёт НОВЫЙ объект в куче (heap),
 *     даже если такая строка уже есть в пуле.
 *   - == сравнивает ссылки (адреса в памяти).
 *     .equals() сравнивает содержимое.
 *   - intern() — возвращает ссылку из пула (добавляет строку в пул, если её нет).
 *   - Конкатенация литералов ("Hel" + "lo") вычисляется компилятором →
 *     результат берётся из пула.
 *   - Конкатенация с переменной выполняется в рантайме → создаётся новый объект.
 *
 * Как запустить: нажмите ▶ рядом с main.
 */

public class StringPoolLab {
    public static void main(String[] args) {
        // Создание строк 6 разными способами
        String s1 = "Hello";                    // Литерал
        String s2 = "Hello";                    // Литерал
        String s3 = new String("Hello");        // new
        String s4 = new String("Hello");        // new
        String s5 = s3.intern();                // intern()
        String s6 = "Hel" + "lo";               // Конкатенация литералов
        String half = "Hel";
        String s7 = half + "lo";                // Конкатенация с переменной

        System.out.println("=== Сравнение строк ===\n");

        // s1 и s2
        // Прогноз: true, true (оба ссылаются на один объект в String Pool)
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println();

        // s1 и s3
        // Прогноз: false, true (s3 — новый объект в heap, но equals сравнивает содержимое)
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println();

        // s3 и s4
        // Прогноз: false, true (два разных объекта в heap)
        System.out.println("s3 == s4: " + (s3 == s4));
        System.out.println("s3.equals(s4): " + s3.equals(s4));
        System.out.println();

        // s1 и s5
        // Прогноз: true, true (s5.intern() вернул ссылку на объект из String Pool)
        System.out.println("s1 == s5: " + (s1 == s5));
        System.out.println("s1.equals(s5): " + s1.equals(s5));
        System.out.println();

        // s1 и s6
        // Прогноз: true, true (компилятор вычисляет "Hel" + "lo" на этапе компиляции)
        System.out.println("s1 == s6: " + (s1 == s6));
        System.out.println("s1.equals(s6): " + s1.equals(s6));
        System.out.println();

        // s1 и s7
        // Прогноз: false, true (s7 создаётся во время выполнения, новый объект)
        System.out.println("s1 == s7: " + (s1 == s7));
        System.out.println("s1.equals(s7): " + s1.equals(s7));
        System.out.println();

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append('H').append('e').append('l').append('l').append('o');
        String s8 = sb.toString();

        System.out.println("=== StringBuilder ===");
        System.out.println("s1 == s8: " + (s1 == s8));
        System.out.println("s1.equals(s8): " + s1.equals(s8));
    }
}