package presentation.show_items

import data.entites.library.Showable
import presentation.colors.Colors.ANSI_BLUE
import presentation.colors.Colors.ANSI_RESET

fun List<Showable>.showItems() {
    forEachIndexed { i, item ->
        println(ANSI_BLUE + "\t${i + 1} - " + ANSI_RESET + item.briefInformation())
    }
}

