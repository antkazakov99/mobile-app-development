// Практическая работа 3. Задание 1. Вариант 14. Поиск минимальной цифры, кратной трем
// Реализация с использованием функционального подхода в одно выражение каждое (без учета ввода-вывода)

fun main(args: Array<String>) {
    // println(readlnOrNull()?. filter {  it.digitToIntOrNull() != null && it.digitToIntOrNull() != 0 && it.digitToInt() % 3 == 0 }?.minByOrNull { it.digitToInt() }?.digitToInt())

    readlnOrNull().runCatching { this!!.filter { it.digitToInt() % 3 == 0 && it.digitToInt() != 0 }.minBy { it.digitToInt() } }
        .onSuccess { println("Success ${it}") }
        .onFailure { println("Failed") }
}
