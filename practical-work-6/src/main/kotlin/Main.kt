import controller.DaggerAppComponent

// База данных тарифных планов оператора. Поля: название, тип вещания (обычный/HD), флаг общедоступности.

fun main() {
    val app = DaggerAppComponent.create().getApp()
    app.run()
}