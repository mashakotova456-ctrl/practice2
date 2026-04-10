package part2.part2_2;

/**
 * Задание 2.2 — Криптокошелёк (реализация PaymentMethod)
 *
 * Формат process: "Криптоплатёж (BTC): 10000.0 руб."
 * Комиссия: 1.5% от суммы.
 */
public record CryptoWallet(String address, String currency) implements PaymentMethod {

    @Override
    public String process(double amount) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return "Криптоплатёж (" + currency + "): " + amount + " руб.";
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    public double fee(double amount) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return amount * 0.015;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}