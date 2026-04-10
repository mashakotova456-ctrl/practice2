package part2.part2_3;

/**
 * Задание 2.3 — Сервис аутентификации (реализация Loggable)
 */
public class AuthService implements Loggable {

    @Override
    public String getComponentName() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return "AuthService";
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public void login(String username, boolean success) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        if (success) {
            log("Вход пользователя: " + username + " — успешно");
        } else {
            logError("Вход пользователя: " + username + " — отказано");
        }
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}