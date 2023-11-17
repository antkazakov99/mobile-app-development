// Практическая работа 2 Задание 3
// Необходимо модифицировать функции сделанные в задании 1, таким образом чтобы условие, по которому происходит отбор,
// можно было передать как аргумент (Один из аргументов функции должен быть лямбда со значением по умолчанию - условием,
// что было указано в нашем варианте)

// Реализация без использования

fun taskThreePartOne() {
    print("Введите число:\n> ")
    val num: String? = readlnOrNull()

    if (num != null) {
        try {
            val result: Int? = taskOnePartOneFun(num.toInt())
            if (result != null) {
                println("Наименьшая цифра кратная трем: $result")
            } else {
                println("Отсутствуют цифры кратные трем")
            }
        } catch (ex: NumberFormatException) {
            println("Error: Значение не является числом")
        }
    } else {
        println("Error: Значение равно null")
    }
}

// Функция, вовращающая наименьшую цифру, кратную трем в указанной последовательности цифр
fun taskThreePartOneFun(num: Int, selectCondition: (num: Int) -> Boolean = { num % 3 == 0 }): Int?
{
    var lowestNum: Int? = null
    var num1 = num
    while(num1 > 0)
    {
        val number = num1 % 10
        num1 /= 10
        if (selectCondition(number))
        {
            if (((lowestNum != null) && (number < lowestNum)) || (lowestNum == null))
            {
                lowestNum = number
            }
        }
    }
    return lowestNum
}

// Реализация с использованием хвостовой рекурсии
fun taskThree() {
    print("Введите число:\n> ")
    val num: String? = readlnOrNull()

    if (num != null) {
        try {
            println(taskTwoSingleExp(taskThreeFun(num.toInt(), { num: Int -> num % 2 == 0 })))
        } catch (ex: NumberFormatException) {
            println("Error: Значение не является числом")
        }
    } else {
        println("Error: Значение равно null")
    }
}

// Функция, возвращающая цифру в соответствии с условием которое передается в функцию как аргумент,
// реализовано как хвостовая рекурсия
// Реализация с изменением полного условия
tailrec fun taskThreeFun1(
    num: Int,
    selectCondition: (currNum: Int, resultNum: Int?) -> Int? =
        { currNum: Int, resultNum: Int? ->
            if (resultNum != null && (currNum % 3 == 0 && resultNum < currNum || currNum % 3 != 0)) resultNum
            else currNum
        },
    result: Int? = null
): Int? {
    val currentNum = selectCondition(num % 10, result)
    return return if (num / 10 != 0) taskThreeFun1(num / 10, selectCondition, currentNum) else currentNum
}

// Функция, возвращающая цифру в соответствии с условием которое передается в функцию как аргумент,
// реализовано как хвостовая рекурсия
// Реализация с изменением только условия кратности
tailrec fun taskThreeFun(
    num: Int,
    selectCondition: (num: Int) -> Boolean = { num % 3 == 0 },
    result: Int? = null
): Int? {
    var currentNum: Int? =
        if (selectCondition(num % 10)) num % 10 else null
    if (result != null) {
        if (currentNum != null && result < currentNum || currentNum == null) {
            currentNum = result
        }
    }
    return return if (num / 10 != 0) taskThreeFun(num / 10, selectCondition, currentNum) else currentNum
}

fun taskThreeSingleExp(result: Int?): String =
    if (result != null)
        "Наименьшая цифра кратная двум: $result"
    else
        "Отсутствуют цифры кратные двум"
