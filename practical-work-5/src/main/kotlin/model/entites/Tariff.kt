package model.entites

class Tariff(
    var id: Int?,
    var name: String,
    var broadcastType: BroadcastType = BroadcastType.BASIC,
    var isPublic: Boolean = true
)
