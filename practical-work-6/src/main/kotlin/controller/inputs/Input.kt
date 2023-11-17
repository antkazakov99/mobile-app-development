package controller.inputs

class Input(
    private var invalidInput: () -> Unit = {}
): AbstractInput(invalidInput) {
    public override fun run(): String {
        while (true) {
            val name = readlnOrNull()
            if (name != null) {
                return name
            } else {
                invalidInput()
            }
        }
    }
}