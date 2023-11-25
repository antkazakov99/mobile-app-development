package com.example.practical_work_12

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import model.entites.Tariff

class TariffViewModel: ViewModel() {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val tariffModel = TariffModel()

    private val mutableFlow = MutableStateFlow(tariffModel.getAllTariffs())
    val flow = mutableFlow.asStateFlow()

    private fun notifyFlow() {
        scope.launch {
            mutableFlow.emit(tariffModel.getAllTariffs())
        }
    }

    fun add(tariff: Tariff) {
        tariffModel.addTariff(tariff)
        notifyFlow()
    }
    fun delete(id: Int) {
        tariffModel.deleteTariff(id)
        notifyFlow()
    }
    fun edit(tariff: Tariff) {
        tariffModel.editTariff(tariff)
        notifyFlow()
    }
}
