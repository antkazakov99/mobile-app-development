import java.lang.NumberFormatException

//// Практическая работа №1 Задание 1
//// Минимальная цифра, кратная трем
//fun taskOne()
//{
//    // Минимальная цифра кратная трем
//    var lowestNum : Int? = null
//
//    // Ввод целого неотрицательного числа
//    print("Введите число: ")
//    val num: String? = readLine()
//
//    //  Проверка на null
//    if (num != null)
//    {
//        // Проверка является ли тип числом
//        try
//        {
//            for(i in num)
//            {
//                val intNum = i.toString().toInt()
//                if (intNum % 3 == 0)
//                {
//                    if(lowestNum == null)
//                    {
//                        lowestNum = intNum
//                    }
//                    else
//                    {
//                        if (lowestNum > intNum)
//                        {
//                            lowestNum = intNum
//                        }
//                    }
//                }
//            }
//
//            // Вывод результата
//            if (lowestNum == null)
//            {
//                println("Отсутствуют числа кратные трем")
//            }
//            else
//            {
//                println("Наименьшее число кратное трем: $lowestNum")
//            }
//
//        }
//        catch (e: NumberFormatException)
//        {
//            println("Error: value is not a Number")
//        }
//    }
//    else
//    {
//        println("Error: value is Null")
//    }
//}


// Минимальная цифра, кратная трем
// Основной алгоритм вынесен в отдельную функцию
fun taskOne()
{
    print("Введите число: ")
    val num: String? = readLine()
    if(num != null)
    {
        try
        {
            val lowestNum: Int? = taskOneFunc(number = num.toInt())
            if(lowestNum != null)
            {
                println("Минимальное число кратное трем: $lowestNum")
            }
            else
            {
                println("Отсутствуют числа кратные трем")
            }
        }
        catch (ex: NumberFormatException)
        {
            println("Error: NumberFormatException")
        }
    }
    else
    {
        println("Error: value is null")
    }
}


// Основной алгоритм вынесенный в отдельную функцию
fun taskOneFunc(number: Int): Int?
{
    val strNumber: String = number.toString()
    // Переменная в которую будет записываться минимальное число кратное трем
    var lowestNum: Int? = null
    for(i in strNumber)
    {
        val intNum = i.toString().toInt()
        if (intNum % 3 == 0)
        {
            if(lowestNum == null)
            {
                lowestNum = intNum
            }
            else
            {
                if (lowestNum > intNum)
                {
                    lowestNum = intNum
                }
            }
        }
    }
    return lowestNum
}


//// Вариант функции с использованием хвостовой рекурсии
//fun taskOneTR(number: Int): Int?
//{
//    if(number / 10 == 0)
//    {
//        return if(number % 3 == 0) number % 3 else null
//    }
//    else
//    {
//        // Сравниние и возврат наименьшего
//        val lowestNum = number % 3
//        val lowestNum2 = taskOneTR(number / 10)
//        if (lowestNum2 == null)
//        {
//            if(lowestNum == 0)
//            {
//                return lowestNum
//            }
//            else
//            {
//                return null
//            }
//        }
//        else
//        {
//            if(lowestNum == 0)
//            {
//                return if(lowestNum > lowestNum2) lowestNum2 else lowestNum
//            }
//            else
//            {
//                return null
//            }
//        }
//    }
//}