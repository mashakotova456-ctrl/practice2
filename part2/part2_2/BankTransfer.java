package part2.part2_2;

/**
 * Задание 2.2 — Банковский перевод (реализация PaymentMethod)
 *
 * Формат process: "Перевод через БАНК: Z руб."
 * Комиссия: фиксированные 50 руб.
 */
public record BankTransfer(String bankName, String iban) implements PaymentMethod {

    @Override
    public String process(double amount) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return "Перевод через " + bankName + ": " + amount + " руб.";
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    public double fee(double amount) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return 50.0;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}