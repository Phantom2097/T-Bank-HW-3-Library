package data.entites

import presentation.colors.Colors.ANSI_RED
import presentation.colors.Colors.ANSI_RESET

interface Readable {
    fun readInTheReadingRoom(): String = "${ANSI_RED}Нельзя взять в зал\n$ANSI_RESET"
    fun takeToHome(): String = "${ANSI_RED}Нельзя взять домой\n$ANSI_RESET"
    fun returnInLibrary(): String
}