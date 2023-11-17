package controller.inputs

class Menu(
    private var menuItems: List<Pair<String, (() -> Unit)?>>,
    private var printMenuItems: (List<String>) -> Unit = {},
    private var invalidInput: () -> Unit = {},
    private var input: AbstractInput
) {

    public fun run() {
        while (true) {
            val result = Select(
                menuItems.map { it.first }.toList(),
                printMenuItems,
                invalidInput,
                input
            ).run()
            if (menuItems[result].second == null) {
                return
            } else {
                menuItems[result].second!!.invoke()
            }
        }
    }
}