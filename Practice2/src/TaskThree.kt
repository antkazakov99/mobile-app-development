// Практическая работа 2 Задание 3
//

fun taskThree()
{
    print("Введите число:\n> ")
    val num: String? = readLine()

    if (num != null)
    {
        try
        {
            println(taskTwoSingleExp(taskThreeFun(num.toInt())))
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

// Функция, возвращающая цифру в соответствии с условием которое передается в функцию как аргумент,
// реализовано как хвостовая рекурсия
fun taskThreeFun
    (
        num: Int,
        // Условие отбора, по умолчанию кратное 3

        selectCondition: (num1: Int?, num2: Int?) -> Int? =
            {
                num1: Int?, num2: Int? ->
                if (num2 != null && (num1 != null && num2 < num1 || num1 == null)) num2
                else num1
            },
        result: Int? = null
    ): Int?
{
    val currentNum = selectCondition(
        if ((num % 10) % 3 == 0) num % 10 else null,
        result
    )
    return if(num / 10 != 0) taskOnePartTwoFun(num / 10, currentNum)
        else currentNum
}
