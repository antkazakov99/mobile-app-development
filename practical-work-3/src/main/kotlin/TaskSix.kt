// Практическая работа 3. Задание 6. Вариант 14.
// По данному натуральному числу n найдите наименьшее простое число, большее n

fun main(args: Array<String>) {
    println(readlnOrNull()?.toIntOrNull()?.takeIf { it > 0 }?.run { (this + 1.. Int.MAX_VALUE).first { (2 ..< it).all { it2 -> it % it2 != 0 } } })
}
