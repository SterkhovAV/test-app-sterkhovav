Написать консольное приложение, которое выполняет следующие задачи:
1. Открывает консоль и ожидает ввода от пользователя
2. Принимает арифметическое выражение с переменными, например,
   “(12 + х) * 23 + y”
   Арифметическое выражение с переменными может быть сформировано из
   следующих компонентов:
   1. Положительное число, размерности не более 16 бит.
   2. Четыре арифметических бинарных операции:
      a. +
      b. –
      c. / (целочисленное деление)
      d. *
   3. Скобки: ( и ).
   4. Идентификаторы переменных, состоящие из латинских букв и цифр,
      начинающиеся с буквы.

3. По заданному выражению формирует АSТ дерево
   (https://en.wikipedia.org/wiki/Abstract_syntax_tree).
4. Инициализирует переменные случайными значениями, вычисляет и показывает значение
   выражения, а также значения переменных
5. Позволяет изменить значения переменных, например в виде “x = 20”
6. По команде calc заново вычисляет и показывает значение выражения
7. По команде print распечатывает сформированное AST дерево.

8. Дополнительные требования:
1. Сопроводить решение инструкциями по сборке и запуску приложения.
2. Решение должно корректно обрабатывать ввод ошибочных данных.
3. Не допускается использование генераторов кода по грамматике.
4. Решение должно строиться с помощью стандартных средств Java (версия 8) или .NET и
   не должно требовать сторонних библиоте2к.