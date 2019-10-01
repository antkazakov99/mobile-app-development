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
//        // Проверка является ли num числом
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
fun TaskOne()
{

}

fun TaskOneFun(): Int?
{

}

tailrec fun TaskOneTailrec(): Int?
{

}