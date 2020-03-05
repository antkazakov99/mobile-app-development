
fun main()
{
    mainMenu()
}

// Список тарифов
val tariffs = mutableListOf<Tariff>()

// Класс "Тарифы
class Tariff
{
    var id: Int = 0
    // Название тарифа
    var name: String = "default"
    // Тип вещания
    var hdBroadcast: Boolean = false
    // Флаг общедоступности
    var publicAccess: Boolean = true

}

// Главное иеню
fun mainMenu()
{
    var isRunning = true
    while (isRunning)
    {
        println("Выберите пункт из списка: ")
        println("1. Добавить тариф")
        println("2. Удалить тариф")
        println("3. Изменить тариф")
        println("4. Посмотреть все тарифы")
        println("5. Сортировка тарифов")
        println("6. Поиск")
        print("> ")
        when (readLine())
        {
            "1" ->
            {
                addTariff()
            }
            "2" ->
            {
                deleteTariff()
            }
            "3" ->
            {
                updateTariff()
            }
            "4" ->
            {
                showTariffs()
            }
            "5" ->
            {
                sortTariffs()
            }
            "6" ->
            {
                searchTariff()
            }
            else ->
            {
                println("Введено некорректное значение")
            }
        }
    }
}

// Добавление нового тарифа
fun addTariff()
{
    val newTariff: Tariff = Tariff()
    if (tariffs.size > 0)
    {
        tariffs.sortBy { it.id }
        newTariff.id = tariffs.last().id + 1
    }
    else
    {
        newTariff.id = 1
    }
    var isRunning = true
    while (isRunning)
    {
        print("Введите название тарифа:\n> ")
        val result = readLine()
        if (result != null)
        {
            isRunning = false
            newTariff.name = result
        }
        else
        {
            println("Значение равно null")
        }
    }
    isRunning = true
    while (isRunning)
    {
        print("Подерживает ли тариф HD формат (Да/Нет):\n> ")
        val result = readLine()
        if (result != null)
        {
            if (result == "Да" || result == "Нет")
            {
                isRunning = false
                newTariff.hdBroadcast = (result == "Да")
            }
            else
            {
                println("Некорректное значение")
            }
        }
        else
        {
            println("Значение равно null")
        }
    }
    isRunning = true
    while (isRunning)
    {
        print("Является ли тариф общедоступным (Да/Нет):\n> ")
        val result = readLine()
        if (result != null)
        {
            if (result == "Да" || result == "Нет")
            {
                isRunning = false
                newTariff.publicAccess = (result == "Да")
            }
            else
            {
                println("Некорректное значение")
            }
        }
        else
        {
            println("Значение равно null")
        }
    }
    tariffs.add(newTariff)
    println("Тариф успещно добавлен. Общее количество тарифов: ${tariffs.size}")
}

// Удаление тарифа
fun deleteTariff()
{
    var isRunning = true
    while (isRunning)
    {
        print("Введите идентификатор удаляемого тарифа:\n> ")
        val result = readLine()
        if (result != null)
        {
            if (result.toIntOrNull() != null)
            {
                isRunning = false
                val size = tariffs.size
                tariffs.removeIf { it.id == result.toInt() }
                if (size != tariffs.size)
                {
                    println("Объект удален")
                }
                else
                {
                    println("Отсутствует тариф с указанным индексом")
                }
            }
            else
            {
                println("Введенное значение не является числом")
            }
        }
        else
        {
            println("Значение равно null")
        }
    }
}

// Изменение тарифа
fun updateTariff()
{
    println("Введите идентификатор изменяемого тарифа")
    print("> ")
    val result = readLine()
    if (result != null)
    {
        if (result.toIntOrNull() != null)
        {
            if (tariffs.any { it.id == result.toInt() })
            {
                var isRunning = true
                var name: String = "tariff_name"
                while (isRunning)
                {
                    print("Введите название тарифа:\n> ")
                    val nameResult = readLine()
                    if (nameResult != null)
                    {
                        isRunning = false
                        name = nameResult
                    }
                    else
                    {
                        println("Значение равно null")
                    }
                }
                isRunning = true
                var hdBroadcast: Boolean = false
                while (isRunning)
                {
                    print("Подерживает ли тариф HD формат (Да/Нет):\n> ")
                    val hdResult = readLine()
                    if (hdResult != null)
                    {
                        if (hdResult == "Да" || hdResult == "Нет")
                        {
                            isRunning = false
                            hdBroadcast = (hdResult == "Да")
                        }
                        else
                        {
                            println("Некорректное значение")
                        }
                    }
                    else
                    {
                        println("Значение равно null")
                    }
                }
                isRunning = true
                var publicAccess: Boolean = false
                while (isRunning)
                {
                    print("Является ли тариф общедоступным (Да/Нет):\n> ")
                    val accessResult = readLine()
                    if (accessResult != null)
                    {
                        if (accessResult == "Да" || accessResult == "Нет")
                        {
                            isRunning = false
                            publicAccess = (accessResult == "Да")
                        }
                        else
                        {
                            println("Некорректное значение")
                        }
                    }
                    else
                    {
                        println("Значение равно null")
                    }
                }

                tariffs.filter { it.id == result.toInt() }.forEach {
                    it.name = name
                    it.hdBroadcast = hdBroadcast
                    it.publicAccess = publicAccess
                }
            }
            else
            {
                println("Отсутствует тариф с идентификатором $result")
            }
        }
        else
        {
            println("Введенное значение не является числом")
        }
    }
    else
    {
        println("Значение равно null")
    }
}

// Просмотр тарифов
fun showTariffs()
{
    tariffs.forEach { println("ID: ${it.id}, Тариф: ${it.name}, HD: ${it.hdBroadcast}, Общедоступный: ${it.publicAccess}") }
}

// Сортировка тарифов
fun sortTariffs()
{
    var isRunning = true
    while (isRunning)
    {
        println("Выберите поле по которому необходимо производить сортировку:")
        println("1. ID")
        println("2. Название")
        println("3. Поддержка HD формата")
        println("4. Общедоступность тарифа")
        print("> ")
        val result = readLine()
        if (result != null)
        {
            if (result.toIntOrNull() != null)
            {
                when (result)
                {
                    "1" ->
                    {
                        tariffs.sortBy { it.id }
                        isRunning = false
                    }
                    "2" ->
                    {
                        tariffs.sortBy { it.name }
                        isRunning = false
                    }
                    "3" ->
                    {
                        tariffs.sortBy { it.hdBroadcast }
                        isRunning = false
                    }
                    "4" ->
                    {
                        tariffs.sortBy { it.publicAccess }
                        isRunning = false
                    }
                    else ->
                    {
                        println("Некорректное значение")
                    }
                }
            }
            else
            {
                println("Введенное значение не является числом")
            }
        }
        else
        {
            println("Значение равно null")
        }
    }
}

// Поиск тарифов
fun searchTariff()
{
    print("Введите название тарифа\n> ")
    val result = readLine()
    if (result != null)
    {
        tariffs.filter { it.name.contains(Regex(""".*$result.*""")) }.forEach { println("ID: ${it.id}, Тариф: ${it.name}, HD: ${it.hdBroadcast}, Общедоступный: ${it.publicAccess}") }
    }
    else
    {
        println("Значение равно null")
    }
}