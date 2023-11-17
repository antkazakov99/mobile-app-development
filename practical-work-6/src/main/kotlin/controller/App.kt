package controller

import controller.inputs.BooleanSelect
import controller.inputs.Input
import controller.inputs.Menu
import controller.inputs.Select
import model.entites.Tariff
import model.entites.TariffModel
import view.TariffView
import javax.inject.Inject

class App @Inject constructor(
    private var tariffView: TariffView,
    private val tariffModel: TariffModel
) {

    private val utils = Utils()

    private var filter: String = ""
    private var sorting: SortDirection = SortDirection.DISABLED

    public fun run() {
        mainMenu()
    }

    private fun mainMenu() {
        val mainMenuItems = listOf(
            "Добавить тариф" to { addTariff() },
            "Удалить тариф" to { deleteTariff() },
            "Изменить тариф" to { editTariff() },
            "Просмотр тарифов" to { showTariffsMenu() },
            "Выход" to null
        )

        Menu(
            mainMenuItems,
            { menuItems: List<String> -> tariffView.printSelect(menuItems) },
            { tariffView.printInvalidInput() },
            Input { tariffView.printFailedInput() }
        ).run()
    }

    private fun addTariff() {
        tariffView.printInputTariffName()
        val name = Input { tariffView.printInvalidInput() }.run()

        tariffView.printSelectTariffBroadcastType()
        val broadcastTypes = utils.broadcastTypes.toList()
        val selectedType = Select (
            broadcastTypes.map { it.second },
            { menuItems -> tariffView.printSelect(menuItems) },
            { tariffView.printInvalidInput() },
            Input { tariffView.printFailedInput() }
        ).run()
        val broadcastType = broadcastTypes[selectedType].first

        tariffView.printSelectTariffIsPublic()
        val isPublic = BooleanSelect(
            { menuItems -> tariffView.printSelect(menuItems) },
            { tariffView.printInvalidInput() },
            Input { tariffView.printInvalidInput()}
        ).run()

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
            val id = Input { tariffView.printInvalidInput() }.run().toIntOrNull()
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
            id = Input { tariffView.printInvalidInput() }.run().toIntOrNull()
            if (!tariffs.any { it.id == id }) {
                id = null
                tariffView.printInvalidInput()
            }
        }

        val tariff = tariffs[id]

        tariffView.printPreviousValue(tariff.name)
        tariffView.printInputTariffName()
        tariff.name = Input { tariffView.printInvalidInput() }.run()

        tariffView.printPreviousValue(utils.broadcastTypes[tariff.broadcastType]!!)
        tariffView.printSelectTariffBroadcastType()
        val broadcastTypes = utils.broadcastTypes.toList()
        val selectedType = Select(
            broadcastTypes.map { it.second },
            { menuItems -> tariffView.printSelect(menuItems) },
            { tariffView.printInvalidInput() },
            Input { tariffView.printFailedInput() }
        ).run()
        tariff.broadcastType = broadcastTypes[selectedType].first

        tariffView.printPreviousValue(utils.boolValues[tariff.isPublic]!!)
        tariffView.printSelectTariffIsPublic()
        tariff.isPublic = BooleanSelect(
            { menuItems -> tariffView.printSelect(menuItems) },
            { tariffView.printInvalidInput() },
            Input { tariffView.printInvalidInput()}
        ).run()
    }

    private fun showTariffsMenu() {
        val showMenuItems = listOf(
            "Поиск" to { filterTariffs() },
            "Сортировка" to { sortTariffs() },
            "Просмотр" to { showTariffs() },
            "Назад" to null
        )

        Menu(
            showMenuItems,
            { menuItems -> tariffView.printSelect(menuItems) },
            { tariffView.printInvalidInput() },
            Input { tariffView.printFailedInput() }
        ).run()
    }

    private fun filterTariffs() {
        tariffView.printInputSearchString()
        filter = Input { tariffView.printInvalidInput() }.run()
    }

    private fun sortTariffs() {
        val sortingTypes = listOf(
            SortDirection.ASC to "По возрастанию",
            SortDirection.DESC to "По убыванию",
            SortDirection.DISABLED to "По умолчанию"
        )

        tariffView.printChooseSortingType()
        val selectedType = Select(
            sortingTypes.map { it.second },
            { menuItems -> tariffView.printSelect(menuItems) },
            { tariffView.printInvalidInput() },
            Input { tariffView.printFailedInput() }
        ).run()
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