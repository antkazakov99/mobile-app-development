// Задание 1 Практическая работа 2
// Изменить программу, сделанную в задании 1 практической работы 1, вынести основной алгоритм в отдельную функцию.
// Описать функцию несколькими способами: 1. Обычная функция, 2. Функция с использованием хвостовой рекурсии

// Задание 1 Практическая работа 1 Вариант 14
// Для данного неотрицательного числа, найти наименшую цифру кратную трем. Осуществить проверку корректности ввода.


// 1. Вариант решения с использованием обычной функции
fun taskOnePartOne()
{
    print("Введите число:\n> ")
    val num: String? = readLine()

    if (num != null)
    {
        try
        {
            val result: Int? = taskOnePartOneFun(num.toInt())
            if(result != null)
            {
                println("Наименьшая цифра кратная трем: $result")
            }
            else
            {
                println("Отсутствуют цифры кратные трем")
            }
        }
        catch (ex: NumberFormatException)
        {
            println("Error: Значение не является числом")
        }
    }
    else
    {
        println("Error: Значение равно null")
    }
}

// Функция, вовращающая наименьшую цифру, кратную трем в указанной последовательности цифр
fun taskOnePartOneFun(num: Int): Int?
{
    var lowestNum: Int? = null
    var num1 = num
    while(num1 > 0)
    {
        val number = num1 % 10
        num1 /= 10
        if (number % 3 == 0)
        {
            if (((lowestNum != null) && (number < lowestNum)) || (lowestNum == null))
            {
                lowestNum = number
            }
        }
    }
    return lowestNum
}



// 2. Вариант решения с использованием хвостовой рекурсии
fun taskOnePartTwo()
{
    print("Введите число:\n> ")
    val num: String? = readLine()

    if (num != null)
    {
        try
        {
            val result: Int? = taskOnePartTwoFun(num.toInt())
            if(result != null)
            {
                println("Наименьшая цифра кратная трем: $result")
            }
            else
            {
                println("Отсутствуют цифры кратные трем")
            }
        }
        catch (ex: NumberFormatException)
        {
            println("Error: Значение не является числом")
        }
    }
    else
    {
        println("Error: Значение равно null")
    }
}


// Функция, вовращающая наименьшую цифру, кратную трем в указанной последовательности цифр
tailrec fun taskOnePartTwoFun(num: Int, result: Int? = null): Int?
{
    var currentNum: Int? = if ((num % 10) % 3 == 0) num % 10 else null
    if (result != null)
    {
        if (currentNum != null && result < currentNum || currentNum == null)
        {
            currentNum = result
        }
    }

    return if(num / 10 != 0) taskOnePartTwoFun(num / 10, currentNum) else currentNum
}
