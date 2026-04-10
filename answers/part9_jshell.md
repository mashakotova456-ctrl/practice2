# Часть 9 — Эксперименты в jshell

## Как запустить jshell

Откройте терминал IntelliJ (View → Tool Windows → Terminal) и введите:
```
jshell
```
Для выхода: `/exit`

---

## Задание 9.1: Sealed-классы

### Команды (скопируйте и вставьте в jshell)

```
sealed interface Shape permits Circle, Square {}
record Circle(double r) implements Shape {}
record Square(double side) implements Shape {}
Shape s = new Circle(5)
s instanceof Circle c ? "Круг r=" + c.r() : "Не круг"
```

### Фактический вывод:

```
jshell> sealed interface Shape permits Circle, Square {}
|  interface Shape

jshell> record Circle(double r) implements Shape {}
|  record Circle

jshell> record Square(double side) implements Shape {}
|  record Square

jshell> Shape s = new Circle(5)
s ==> Circle[r=5.0]

jshell> s instanceof Circle c ? "Круг r=" + c.r() : "Не круг"
$6 ==> "Круг r=5.0"
```

### Вопрос: Что произойдёт при попытке создать `record Triangle(double a) implements Shape {}`?

**Ваш ответ:Произойдёт ошибка компиляции. Интерфейс Shape объявлен как sealed с явным списком разрешённых реализаций (permits Circle, Square). Компилятор Java запретит любому другому классу или записи (включая Triangle) реализовывать этот интерфейс, если они не указаны в списке permits и не находятся в том же файле/модуле с явным разрешением.**



---

## Задание 9.2: Цепочка лямбд

### Команды

```
import java.util.function.*
Function<String, String> trim = String::trim
Function<String, String> upper = String::toUpperCase
Function<String, String> exclaim = s -> s + "!"
var pipeline1 = trim.andThen(upper).andThen(exclaim)
var pipeline2 = exclaim.compose(upper).compose(trim)
pipeline1.apply("  hello world  ")
pipeline2.apply("  hello world  ")
```

### Фактический вывод:

```
jshell> import java.util.function.*

jshell> Function<String, String> trim = String::trim
trim ==> $Lambda$...

jshell> Function<String, String> upper = String::toUpperCase
upper ==> $Lambda$...

jshell> Function<String, String> exclaim = s -> s + "!"
exclaim ==> $Lambda$...

jshell> var pipeline1 = trim.andThen(upper).andThen(exclaim)
pipeline1 ==> $Lambda$...

jshell> var pipeline2 = exclaim.compose(upper).compose(trim)
pipeline2 ==> $Lambda$...

jshell> pipeline1.apply("  hello world  ")
$7 ==> "HELLO WORLD!"

jshell> pipeline2.apply("  hello world  ")
$8 ==> "HELLO WORLD!"
```

### Вопрос: Дают ли `andThen()` и `compose()` одинаковый результат? В каком случае результаты будут различаться?

**Ваш ответ:В данном конкретном случае результат одинаковый ("HELLO WORLD!"), потому что операции trim, upper, exclaim коммутативны по эффекту для этой входной строки: неважно, в каком порядке применять обрезку пробелов, приведение к верхнему регистру и добавление восклицательного знака — итоговая строка будет той же.
Однако в общем случае результаты РАЗЛИЧАЮТСЯ, потому что:
f.andThen(g) выполняет f первым, затем g: g(f(x))
f.compose(g) выполняет g первым, затем f: f(g(x))**

**Пример различия**

```
Function<String, String> addA = s -> s + "A";
Function<String, String> addB = s -> s + "B";

addA.andThen(addB).apply("X");  // "XAB" (сначала A, потом B)
addA.compose(addB).apply("X");  // "XBA" (сначала B, потом A)
```


---

## Задание 9.3: Сравнение EnumSet и HashSet

### Команды

```
enum Color { RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE, BLACK }
var enumSet = java.util.EnumSet.of(Color.RED, Color.GREEN, Color.BLUE)
var hashSet = new java.util.HashSet<>(java.util.Set.of(Color.RED, Color.GREEN, Color.BLUE))
enumSet.contains(Color.RED)
hashSet.contains(Color.RED)
enumSet.getClass().getSimpleName()
hashSet.getClass().getSimpleName()
```

### Фактический вывод:

```
jshell> enum Color { RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE, BLACK }
|  enum Color

jshell> var enumSet = java.util.EnumSet.of(Color.RED, Color.GREEN, Color.BLUE)
enumSet ==> [RED, GREEN, BLUE]

jshell> var hashSet = new java.util.HashSet<>(java.util.Set.of(Color.RED, Color.GREEN, Color.BLUE))
hashSet ==> [RED, GREEN, BLUE]

jshell> enumSet.contains(Color.RED)
$9 ==> true

jshell> hashSet.contains(Color.RED)
$10 ==> true

jshell> enumSet.getClass().getSimpleName()
$11 ==> "RegularEnumSet"

jshell> hashSet.getClass().getSimpleName()
$12 ==> "HashSet"
```

### Вопрос: Почему внутренний класс EnumSet называется `RegularEnumSet`? Что произойдёт, если enum будет иметь больше 64 констант?

**Ваш ответ:**

**Почему RegularEnumSet:
Внутренняя реализация EnumSet использует битовый вектор (long — 64 бита) для хранения принадлежности элементов множеству. Каждый бит соответствует порядковому номеру (ordinal()) константы enum. Это обеспечивает:
O(1) время операций (add, remove, contains)
Минимальное потребление памяти (всего 8 байт для до 64 элементов)
Быстрые битовые операции для union, intersection и т.д.
Класс RegularEnumSet — это оптимизированная реализация для случаев, когда в enum не более 64 констант.
Если в enum больше 64 констант:
Java автоматически переключается на другую внутреннюю реализацию — JumboEnumSet, которая использует массив long[] вместо одного long. Это позволяет поддерживать любое количество констант, но с немного большими накладными расходами на память и операции.**

