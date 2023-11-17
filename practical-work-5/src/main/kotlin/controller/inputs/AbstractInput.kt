package controller.inputs

abstract class AbstractInput(
    private var invalidInput: () -> Unit = {}
) {
    abstract fun run(): String
}