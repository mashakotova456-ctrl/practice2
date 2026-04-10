package part2.part2_3;

/**
 * Задание 2.3 — Сервис базы данных (реализация Loggable)
 *
 * Реализует единственный обязательный метод getComponentName().
 * Все default-методы (log, logError) доступны автоматически.
 */

public class DatabaseService implements Loggable {

    @Override
    public String getComponentName() {
        return "DatabaseService";
    }

    // Добавьте этот метод:
    public void connect(String connectionString) {
        log("Подключение к базе данных: " + connectionString);
    }
}