package controller.inputs

class Select(
    private var menuItems: List<String>,
    private var printSelectItems: (List<String>) -> Unit = {},
    private var invalidInput: () -> Unit = {},
    private var input: AbstractInput
) {

    public fun run(): Int {
        while (true) {
            printSelectItems(menuItems)
            val result: Int? = input.run().toIntOrNull()
            if (result != null && result > 0 && result <= menuItems.count()) {
                return result - 1
            } else {
                invalidInput()
            }
        }
    }
}