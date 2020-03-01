fun taskFive()
{
    // Проверка является ли num числом
    try
    {
        var students = mutableListOf<String>()
        println("Введите данные о ученике в формате: [Имя] [Фамилия] - [Оценка1] ... [ОценкаN]")

        var isRead = true
        while (isRead)
        {
            print("> ")
            val str = readLine()
            if (str != null && str != "")
            {
                students.add(str)
            }
            else
            {
                isRead = false
            }
        }
        var num = 0
        var top = Double.MIN_VALUE
        students.sortBy { if (it.split('-').size > 1) it.split('-')[0] else "" }
        students.sortBy { if (it.split('-').size > 1) it.split('-')[1].split(' ').filter { it != "" }.sumByDouble { it.toDouble() } / it.split('-')[1].split(' ').filter { it != "" }.count() else Double.MAX_VALUE}
        students.forEach {
            if (num < 3)
            {
                if (it.split("-").size > 1)
                {
                    if ( it.split('-')[1].split(' ').filter { it != "" }.sumByDouble { it.toDouble() } / it.split('-')[1].split(' ').filter { it != "" }.count() > top)
                    {
                        num++
                        top = it.split('-')[1].split(' ').filter { it != "" }.sumByDouble { it.toDouble() } / it.split('-')[1].split(' ').filter { it != "" }.count()
                    }
                    println("$num. ${it}")
                }
            }
        }
    }
    catch (e: NumberFormatException)
    {
        println("Error: value is not a Number")
    }
}