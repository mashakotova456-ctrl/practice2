package company.app;

import company.core.Employee;

/**
 * Задание 1.2 — Модификаторы доступа (тестовый класс)
 *
 * Задача: запустите этот файл. Он НЕ скомпилируется полностью — это нормально.
 *
 * Для каждой строки (A–H) определите:
 *   1. Скомпилируется ли она?
 *   2. Если нет — какой модификатор доступа и почему он не виден из company.app?
 *
 * Заполните таблицу в answers/task1_2_access_table.md.
 * Подсказка: закомментируйте строки, которые не компилируются,
 * чтобы запустить остальные.
 */
public class HRSystem {
    public static void main(String[] args) {
        Employee emp = new Employee("Иван", 30, 80000, "secret");

        System.out.println(emp.name);            // Строка A
        //System.out.println(emp.age);             // Строка B
        //System.out.println(emp.salary);          // Строка C
       // System.out.println(emp.password);        // Строка D
        System.out.println(emp.getRole());       // Строка E
       // emp.promote(5000);                       // Строка F
       // emp.printSummary();                      // Строка G
       // emp.validatePassword("secret");          // Строка H
   /*
Для каждой строки (A–H) определите: скомпилируется ли она? Если нет — укажите причину (модификатор + пакет).
Заполните таблицу:
Строка	Компилируется?	Почему?
| Строка | Обращаемый член | Модификатор (в Employee) | Компилируется? | Причина |
|--------|----------------|-------------------------|:--------------:|---------|
| **A** | `emp.name` | *(пакетный)* | ❌ Нет | Доступ только внутри пакета `company.core`; `HRSystem` находится в другом пакете |
| **B** | `emp.age` | `private` | ❌ Нет | `private` виден только внутри класса `Employee` |
| **C** | `emp.salary` | `protected` | ❌ Нет | `protected` в другом пакете доступен только наследникам, а `HRSystem` не наследует `Employee` |
| **D** | `emp.password` | `private` | ❌ Нет | `private` виден только внутри класса `Employee` |
| **E** | `emp.getRole()` | `public` | ✅ Да | `public` доступен из любого пакета и класса |
| **F** | `emp.promote(5000)` | `protected` | ❌ Нет | `protected` в другом пакете работает только для наследников |
| **G** | `emp.printSummary()` | `public` | ✅ Да | `public` доступен отовсюду |
| **H** | `emp.validatePassword("secret")` | `private` | ❌ Нет | `private` виден только внутри класса `Employee` |


    */

    }
}
