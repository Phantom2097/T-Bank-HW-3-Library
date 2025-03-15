package data.entites

import presentation.colors.Colors.ANSI_RED
import presentation.colors.Colors.ANSI_RESET

internal interface Readable {
    fun readInTheReadingRoom(): String = "${ANSI_RED}Нельзя взять в зал\n$ANSI_RESET"
}