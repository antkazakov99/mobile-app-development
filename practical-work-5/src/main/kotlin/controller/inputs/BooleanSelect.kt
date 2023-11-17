package controller.inputs

import controller.Utils

class BooleanSelect(
    private var printSelectItems: (List<String>) -> Unit = {},
    private var invalidInput: () -> Unit = {},
    private var input: AbstractInput,
    private var boolValues: Map<Boolean, String> = Utils().boolValues
) {

    public fun run(): Boolean {
        val menuItems = boolValues.toList()
        val result = Select(menuItems.map { it.second }, printSelectItems, invalidInput, input).run()
        return menuItems[result].first
    }
}