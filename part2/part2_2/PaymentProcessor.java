package part2.part2_2;

/**
 * Задание 2.2 — Обработчик платежей с паттерн-матчингом
 *
 * Тема: switch с паттерн-матчингом (Java 21+).
 *
 * Ключевая теория:
 *   - В Java 21 switch может проверять тип объекта: case CreditCard cc -> ...
 *   - При работе с sealed-интерфейсом компилятор проверяет,
 *     что switch покрывает ВСЕ допустимые типы — default не нужен.
 *
 * Пример синтаксиса:
 *
 *   switch (pm) {
 *       case CreditCard cc   -> System.out.println("Карта: " + cc.holder());
 *       case BankTransfer bt -> System.out.println("Банк: " + bt.bankName());
 *       case CryptoWallet cw -> System.out.println("Крипто: " + cw.currency());
 *   }
 */
public class PaymentProcessor {

    public static void describe(PaymentMethod pm) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        switch (pm) {
            case CreditCard cc -> System.out.println("Карта: " + cc.holder() + " ****" + cc.cardNumber().substring(cc.cardNumber().length() - 4));
            case BankTransfer bt -> System.out.println("Банк: " + bt.bankName() + ", IBAN: " + bt.iban());
            case CryptoWallet cw -> System.out.println("Крипто: " + cw.currency() + ", Адрес: " + cw.address());
        }
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}