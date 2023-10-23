// Практическая работа 3. Задание 3. Вариант 14.
// Найдите последний символ в первом самом коротком слове в строке с четным числом символов (в строке указываются
// только слова, разделенные одним или несколькими пробелами).
// Реализация с использованием функционального подхода в одно выражение каждое (без учета ввода-вывода)

fun main(args: Array<String>) {
    println(readlnOrNull()?.split(' ')?.filter { it.isNotEmpty() && it.length % 2 == 0}?.minByOrNull { it.length }?.last())
}