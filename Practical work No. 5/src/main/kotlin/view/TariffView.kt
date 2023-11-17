package view

import controller.Utils
import model.entites.BroadcastType
import model.entites.Tariff

class TariffView {
    fun printSelect(menuItems: List<String>) {
        menuItems.forEachIndexed { index, s -> println("${index + 1}. $s") }
    }

    fun printTariffs(tariffs: List<Tariff>, broadcastTypes: Map<BroadcastType, String> = Utils().broadcastTypes, booleanTypes: Map<Boolean, String> = Utils().boolValues) {
        tariffs.forEach {
            println("ID: ${it.id} / Название: ${it.name} / Тип вещания: ${broadcastTypes[it.broadcastType]} / Публичный: ${booleanTypes[it.isPublic]}")
        }
    }

    fun printInvalidInput() {
        println("Некорректный ввод. Попробуйте снова.")
    }

    fun printFailedInput() {
        println("Ввод завершен некорректно. Попробуйте повторно.")
    }

    fun printInputTariffName() {
        println("Введите название тарифа:")
    }

    fun printSelectTariffBroadcastType() {
        println("Выберите тип вещания:")
    }

    fun printSelectTariffIsPublic() {
        println("Является ли тариф общедоступным:")
    }

    fun pressEnterToContinue() {
        println("Нажмите Enter чтобы продолжить.")
    }

    fun inputDeletedTariffId() {
        println("Введите ID удаляемого тарифа:")
    }

    fun inputEditedTariffId() {
        println("Введите ID тарифа который необходимо изменить:")
    }

    fun printPreviousValue(value: String) {
        println("Предыдущее значение: $value")
    }

    fun printTariffsBaseEmpty() {
        println("В базе отсутствуют тарифы.")
    }

    fun printInputSearchString() {
        println("Введите строку:")
    }

    fun printTariffsNotFounded() {
        println("Тарифы не найдены")
    }

    fun printChooseSortingType() {
        println("Выберите тип сортировки")
    }
}