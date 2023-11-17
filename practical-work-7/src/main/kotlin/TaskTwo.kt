
class List<T>
{
    private val list = mutableListOf<T>()

    fun insert (el: T, n: Int): Boolean
    {
        return if (n >= 0 && n <= list.size)
        {
            list.add(n, el)
            true
        }
        else
        {
            false
        }
    }

    fun delete (n: Int): Boolean
    {
        return if (n >= 0 && n <= list.size - 1)
        {
            list.removeAt(n)
            true
        }
        else
        {
            false
        }
    }

    // Печатает последний элемент списка
    fun print()
    {
        println(list)
    }

    // Очищает весь список
    fun eraseAll()
    {
        list.clear()
    }

}