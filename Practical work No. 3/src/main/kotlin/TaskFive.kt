import java.util.Random

// Практическая работа 3. Задание 5. Вариант 6 (?).
// С клавиатуры вводится информация о студентах: фамилия, имя, оценки. Выведите на экран информацию о трех худших
// студентах по минимальному баллу. В случае, если у нескольких студентов минимальный балл совпадает, то выведите
// большее число студентов (пока не будут выведены все студенты или не будут полностью исчерпаны студенты с тремя
// минимальными баллами). Вывод надо осуществлять в порядке возрастания минимального балла, а для одинаковых
// минимальных баллов – в алфавитном порядке по фамилии и имени.

fun main(args: Array<String>) {
    // Формат ввода [Фамилия] [Имя] - [Оценка1] [Оценка2] .. [ОценкаN]
//    println(generateSequence {
//        readlnOrNull()
//    }
//        .takeWhile {
//            it.isNotEmpty()
//        }
//        .toList()
//        .takeIf { it.all { it.split('-').count() == 2 } && it.all { it.split('-').last().split(' ').filter { it.isNotEmpty() }.all { it.toIntOrNull() != null } } }
//        ?.sortedBy { it.split('-').first }
//        ?.sortedBy { it.split('-').last().split(' ').filter { it.isNotEmpty() }.minBy { it.toInt() }.toInt() }
//        ?.fold(emptyList<String>()) {
//                acc: List<String>, s: String -> if (acc.count() < 3 || acc.last().split('-').last().split(' ').filter {it.isNotEmpty()}.minBy { it.toInt() }.toInt() == s.split('-').last().split(' ').filter {it.isNotEmpty()}.minBy { it.toInt() }.toInt())
//                    acc + s else acc
//        })

    // Формат ввода [Фамилия], [Имя], [Оценка1] [Оценка2] .. [ОценкаN]
    println(generateSequence {
        readlnOrNull()
    }
        .takeWhile {
            it.isNotEmpty()
        }
        .toList()
        .map { it.split(',') }
        .map { Pair(it, it.last().split(' ').filter { it.isNotEmpty() }) }
        .takeIf { it.all { it.first.count() == 3 } && it.all { it.second.all { it.toIntOrNull() != null } } }
        ?.map { Pair(it.first, it.second.minBy { it.toInt() }.toInt()) }
        ?.sortedBy { it.first[1] }
        ?.sortedBy { it.first.first }
        ?.sortedBy { it.second }
        ?.fold(emptyList()) { acc: List<Pair<List<String>, Int>>, s: Pair<List<String>, Int> ->
            if (acc.count() < 3 || acc.last().second== s.second) acc + listOf(s) else acc }?.map { it.first.toString() })
}

fun generateString(): String? {
    var firstname = ""
    var lastname = ""
    var scores = ""

    for (i in 0..5) {
        firstname = firstname.plus(('А'..'Я').random())
        lastname = lastname.plus(('А'..'Я').random())
    }

    for (i in 0..2) {
        scores = scores.plus(' '.plus((0..100).random().toString()))
    }

    return if ((0..10).random() != 10) "$firstname $lastname - $scores" else null
}

fun generateString2(): String? {
    var firstname = ""
    var lastname = ""
    var scores = ""

    for (i in 0..5) {
        firstname = firstname.plus(('А'..'Я').random())
        lastname = lastname.plus(('А'..'Я').random())
    }

    for (i in 0..10) {
        scores = scores.plus(' '.plus((0..100).random().toString()))
    }

    return if ((0..10).random() != 10) "$lastname, $firstname, $scores" else null
}