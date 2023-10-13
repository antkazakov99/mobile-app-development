// Практическая работа 3. Задание 1. Вариант 14. Побитовое исключающее ИЛИ первой цифры всех чисел
// С клавиатуры вводится несколько целых значений через пробел. Найдите (без учета тех чисел, где соответствующей цифры нет)

fun main(args: Array<String>) {
    println(readlnOrNull()?.split(' ')?.filter { it.isNotEmpty() }?.takeIf { it.all { it.toIntOrNull() != null } }?.fold(0) { total, next -> total xor next[0].toString().toInt()})
}
