package controller

import model.entites.BroadcastType
import model.entites.Tariff
import model.entites.TariffModel
import view.TariffView

class App {
    private val tariffView: TariffView = TariffView()
    private val tariffModel: TariffModel = TariffModel()
    private val utils = Utils()

    private var filter: String = ""
    private var sorting: SortDirection = SortDirection.DISABLED

    public fun run() {
        mainMenu()
    }

    private fun select(menuItems: List<String>): Int {
        while (true) {
            tariffView.printSelect(menuItems)
            val result: Int? = input().toIntOrNull()
            if (result != null && result > 0 && result <= menuItems.count()) {
                return result - 1
            } else {
                tariffView.printInvalidInput()
            }
        }
    }

    private fun booleanSelect(): Boolean {
        val menuItems = utils.boolValues.toList()
        val result = select(menuItems.map { it.second })
        return menuItems[result].first
    }

    private fun input(): String {
        while (true) {
            val name = readlnOrNull()
            if (name != null) {
                return name
            } else {
                tariffView.printFailedInput()
            }
        }
    }

    private fun mainMenu() {
        val mainMenuItems = listOf(
            "Добавить тариф" to { addTariff() },
            "Удалить тариф" to { deleteTariff() },
            "Изменить тариф" to { editTariff() },
            "Просмотр тарифов" to { showTariffsMenu() },
            "Выход" to null
        )

        while (true) {
            val result = select(mainMenuItems.map { it.first })
            if (mainMenuItems[result].second == null) {
                return
            } else {
                mainMenuItems[result].second!!.invoke()
            }
        }
    }

    private fun addTariff() {
        tariffView.printInputTariffName()
        val name = input()

        tariffView.printSelectTariffBroadcastType()
        val broadcastTypes = utils.broadcastTypes.toList()
        val selectedType = select(broadcastTypes.map { it.second })
        val broadcastType = broadcastTypes[selectedType].first

        tariffView.printSelectTariffIsPublic()
        val isPublic = booleanSelect()

        val tariff = Tariff(
            null,
            name,
            broadcastType,
            isPublic
        )
        tariffModel.addTariff(tariff)
    }

    private fun deleteTariff() {
        val tariffs = tariffModel.getAllTariffs()
        if (tariffs.isEmpty()) {
            tariffView.printTariffsBaseEmpty()
            tariffView.pressEnterToContinue()
            readln()
            return
        }
        tariffView.printTariffs(tariffs)
        tariffView.inputDeletedTariffId()
        while (true) {
            val id = input().toIntOrNull()
            if (tariffs.any { it.id == id }) {
                tariffModel.deleteTariff(id!!)
                return
            } else {
                tariffView.printInvalidInput()
            }
        }
    }

    private fun editTariff() {
        val tariffs = tariffModel.getAllTariffs()
        if (tariffs.isEmpty()) {
            tariffView.printTariffsBaseEmpty()
            tariffView.pressEnterToContinue()
            readlnOrNull()
            return
        }
        tariffView.printTariffs(tariffs)
        tariffView.inputEditedTariffId()
        var id: Int? = null
        while (id == null) {
            id = input().toIntOrNull()
            if (!tariffs.any { it.id == id }) {
                id = null
                tariffView.printInvalidInput()
            }
        }

        val tariff = tariffs[id]

        tariffView.printPreviousValue(tariff.name)
        tariffView.printInputTariffName()
        tariff.name = input()

        tariffView.printPreviousValue(utils.broadcastTypes[tariff.broadcastType]!!)
        tariffView.printSelectTariffBroadcastType()
        val broadcastTypes = utils.broadcastTypes.toList()
        val selectedType = select(broadcastTypes.map { it.second })
        tariff.broadcastType = broadcastTypes[selectedType].first

        tariffView.printPreviousValue(utils.boolValues[tariff.isPublic]!!)
        tariffView.printSelectTariffIsPublic()
        tariff.isPublic = booleanSelect()
    }

    private fun showTariffsMenu() {
        val showMenuItems = listOf(
            "Поиск" to { filterTariffs() },
            "Сортировка" to { sortTariffs() },
            "Просмотр" to { showTariffs() },
            "Назад" to null
        )

        while (true) {
            val result = select(showMenuItems.map { it.first })
            if (showMenuItems[result].second == null) {
                return
            } else {
                showMenuItems[result].second!!.invoke()
            }
        }
    }

    private fun filterTariffs() {
        tariffView.printInputSearchString()
        filter = input()
    }

    private fun sortTariffs() {
        tariffView.printChooseSortingType()
        val sortingTypes = utils.soringDirectionTypes.toList()
        val selectedType = select(sortingTypes.map { it.second })
        sorting = sortingTypes[selectedType].first
    }

    private fun showTariffs() {
        var tariffs = tariffModel.getAllTariffs()
        if (tariffs.isEmpty()) {
            tariffView.printTariffsBaseEmpty()
        } else {
            tariffs = tariffs.filter { it.name.lowercase().contains(filter.lowercase()) }
            if (sorting == SortDirection.ASC) {
                tariffs = tariffs.sortedBy { it.name }
            } else if (sorting == SortDirection.DESC) {
                tariffs = tariffs.sortedByDescending { it.name }
            }
            if (tariffs.isEmpty()) {
                tariffView.printTariffsNotFounded()
            } else {
                tariffView.printTariffs(tariffs)
            }
        }
        tariffView.pressEnterToContinue()
        readlnOrNull()
    }
}