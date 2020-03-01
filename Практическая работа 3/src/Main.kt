fun main()
{

    print("Введите номер задания: ")
    val num: String? = readLine()
    // Выбор номера задания
    if (num != null)
    {
        when (num.toIntOrNull())
        {
            1 -> taskOne()
            2 -> taskTwo()
            3 -> taskThree()
            4 -> taskFour()
            5 -> taskFive()
            null -> print("Неправильный номер задания.")
        }
    }
}