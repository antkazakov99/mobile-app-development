package controller

import model.entites.BroadcastType

// todo Избавиться от utils
class Utils {
    val boolValues = mapOf(
        true to "Да",
        false to "Нет"
    )

    val broadcastTypes = mapOf(
        BroadcastType.BASIC to "Базовый",
        BroadcastType.HD to "HD"
    )
}