package part2.part2_2;

/**
 * Задание 2.2 — Sealed-интерфейс системы оплаты
 *
 * Тема: sealed-интерфейсы (Java 17+) и паттерн-матчинг (Java 21+).
 *
 * Ключевая теория:
 *   - sealed interface ограничивает набор допустимых реализаций
 *     через permits.
 *   - Компилятор знает ВСЕ возможные реализации — это позволяет
 *     использовать исчерпывающий switch без default.
 *   - Каждый допустимый тип должен быть final, sealed
 *     или non-sealed. Record автоматически final.
 */
public sealed interface PaymentMethod permits CreditCard, BankTransfer, CryptoWallet {
    String process(double amount);
    double fee(double amount);
}