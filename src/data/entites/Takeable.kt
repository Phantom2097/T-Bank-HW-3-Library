package data.entites

import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_RED

interface Takeable {
    fun takeToHome(): String = ANSI_RED + "Нельзя взять домой\n" + ANSI_RESET
}