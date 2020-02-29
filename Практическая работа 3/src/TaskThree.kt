// В строке, найдите последний символ в первом самом коротким слове с четным числом символов (в строке указываются
// только слова разделенные одним или несколькими пробелами).
// Вариант с проверкой количества символов в слове

fun taskThree()
{
    print("Введите строку:\n> ")
    var str: String? = readLine()

    if(str != null)
    {
        print(str.split(' ').filter { it.length > 0 && it.length % 2 == 0}.minBy { it.length }?.last())
    }
    else
    {
        println("Error: value is null")
    }
}