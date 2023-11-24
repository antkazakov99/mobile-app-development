package com.example.practical_work_11

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ConverterViewModel private constructor() {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val convertToBinaryMutableStateFlow = MutableStateFlow<String?>(null)
    val convertToBinaryStateFlow = convertToBinaryMutableStateFlow.asStateFlow()
    private val convertToOctalMutableStateFlow = MutableStateFlow<String?>(null)
    val convertToOctalStateFlow = convertToOctalMutableStateFlow.asStateFlow()
    private val convertToHexadecimalMutableStateFlow = MutableStateFlow<String?>(null)
    val convertToHexadecimalStateFlow = convertToHexadecimalMutableStateFlow.asStateFlow()

    fun fromDecimalToBinary(decimal: Int) {
        val result = ConverterModel().fromDecimalToBinary(decimal)
        scope.launch {
            convertToBinaryMutableStateFlow.emit(result)
        }
    }

    fun fromDecimalToOctal(decimal: Int) {
        val result = ConverterModel().fromDecimalToOctal(decimal)
        scope.launch {
            convertToOctalMutableStateFlow.emit(result)
        }
    }

    fun fromDecimalToHexadecimal(decimal: Int) {
        val result = ConverterModel().fromDecimalToHexadecimal(decimal)
        scope.launch {
            convertToHexadecimalMutableStateFlow.emit(result)
        }
    }

    companion object {
        private var instance: ConverterViewModel? = null

        fun getInstance(): ConverterViewModel {
            if (instance == null) {
                instance = ConverterViewModel()
            }
            return instance!!
        }
    }
}