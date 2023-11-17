package model.entites

class TariffModel {
    private val tariffs: MutableList<Tariff> = mutableListOf()

    fun addTariff(tariff: Tariff) {
        tariffs.add(tariff)
        tariff.id = tariffs.indexOf(tariff)
    }

    fun editTariff(tariff: Tariff) {
        tariffs[tariff.id!!] = tariff
    }

    fun deleteTariff(id: Int) {
        tariffs.removeAt(id)
    }

    fun getTariffById(id: Int): Tariff {
        return tariffs[id]
    }

    fun getAllTariffs(): List<Tariff> {
        return tariffs.toList()
    }
}
