fun main() {
    val secondsAgo = 60 * 11

    println("был(а) ${agoToText(secondsAgo)}")
}

fun agoToText(seconds: Int): String = when {
    seconds < 61 -> "только что"
    seconds < (60 * 60 + 1) -> "${minutesToText(seconds / 60)} назад"
    seconds <= 24 * 60 * 60 -> "${hoursToText(seconds / (60 * 60))} назад"
    seconds <= 2 * 24 * 60 * 60 -> "сегодня"
    seconds <= 3 * 24 * 60 * 60 -> "вчера"
    else -> "давно"
}

fun minutesToText(minutes: Int): String = "$minutes " +
        timeToText(minutes, "минуту", "минуты", "минут")

fun hoursToText(hours: Int): String = "$hours " +
        timeToText(hours, "час", "часа", "часов")

fun timeToText(
    count: Int,
    textRemainderDiv1: String,
    textRemainderDiv234: String,
    textRemainderDivElse: String
): String {
    val remainderDivision = count % 10
    return when {
        remainderDivision == 1 && count % 100 != 11 -> textRemainderDiv1
        remainderDivision in 2..4 -> textRemainderDiv234
        else -> textRemainderDivElse
    }
}