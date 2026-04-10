package part2.part2_3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Задание 2.3 — Интерфейс Loggable с default, static и private методами
 *
 * Тема: эволюция интерфейсов в Java (8, 9+).
 *
 * Ключевая теория:
 *   - abstract метод — без тела, обязателен к реализации.
 *   - default метод — с реализацией по умолчанию, можно переопределить.
 *   - static метод — принадлежит интерфейсу, вызывается через Loggable.getLogLevel().
 *   - private метод (Java 9+) — вспомогательный, используется внутри default-методов.
 */

public interface Loggable {

    String getComponentName();

    default void log(String message) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        System.out.println("[" + formatTimestamp() + "] [" + getComponentName() + "] " + message);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    default void logError(String message) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        log("ОШИБКА: " + message);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    private String formatTimestamp() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    static String getLogLevel() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return "INFO";
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}