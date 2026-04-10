package part4.part4_1;

/**
 * Задание 4.1 — Анализатор текста
 *
 * Тема: работа со строками (String, StringBuilder).
 *
 * Ключевая теория:
 *   - String — неизменяемый (immutable). Каждая операция создаёт новый объект.
 *   - split(" ") — разбивает строку на массив слов по пробелу.
 *   - toLowerCase() — преобразует строку в нижний регистр
 *     (полезно для регистронезависимого поиска).
 *   - StringBuilder — изменяемый буфер, эффективнее для конкатенации в цикле.
 *   - Палиндром — строка, которая читается одинаково слева направо и справа налево.
 *
 * Ожидаемый вывод:
 *
 * Текст: Java Programming is Fun and Java is Powerful
 * Слов: 8
 * Самое длинное слово: Programming
 * Слова наоборот: Powerful is Java and Fun is Programming Java
 * 'Java' встречается: 2 раз(а)
 * 'is' встречается: 2 раз(а)
 * Палиндром: false
 *
 * Текст: А роза упала на лапу Азора
 * Палиндром: true
 */


public class TextAnalyzer {
    private String text;

    public TextAnalyzer(String text) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        this.text = text;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public int wordCount() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public String longestWord() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        String[] words = text.split("\\s+");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public String reverseWords() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public int countOccurrences(String target) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        String lowerText = text.toLowerCase();
        String lowerTarget = target.toLowerCase();

        int count = 0;
        int index = 0;

        while ((index = lowerText.indexOf(lowerTarget, index)) != -1) {
            count++;
            index += lowerTarget.length();
        }
        return count;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public boolean isPalindrome() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        String cleaned = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    public String toString() {
        return text;
    }

    public static void main(String[] args) {
        TextAnalyzer ta = new TextAnalyzer("Java Programming is Fun and Java is Powerful");

        System.out.println("Текст: " + ta);
        System.out.println("Слов: " + ta.wordCount());
        System.out.println("Самое длинное слово: " + ta.longestWord());
        System.out.println("Слова наоборот: " + ta.reverseWords());
        System.out.println("'Java' встречается: " + ta.countOccurrences("java") + " раз(а)");
        System.out.println("'is' встречается: " + ta.countOccurrences("is") + " раз(а)");
        System.out.println("Палиндром: " + ta.isPalindrome());

        System.out.println();

        TextAnalyzer palindrome = new TextAnalyzer("А роза упала на лапу Азора");
        System.out.println("Текст: " + palindrome);
        System.out.println("Палиндром: " + palindrome.isPalindrome());
    }
}