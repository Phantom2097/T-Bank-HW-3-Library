package presentation.start_console

import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW
import presentation.show_digitize.showStartDigitize
import presentation.show_manager.showShops

private typealias MethodType = (Int) -> Unit

internal fun selectLibrarySelection(method: MethodType): Boolean {
    return when (val elementType = readlnOrNull()?.toIntOrNull()) {
        null -> {
            println(ANSI_YELLOW + "Попробуйте ещё раз\n" + ANSI_RESET)
            false
        }
        // Покпка менеджером товаров в соотв. магазине
        4 -> {
            showShops()
            false
        }
        //  Оцифровка предметов
        5 -> {
            showStartDigitize()
            false
        }
        6 -> true
        else -> {
            method(elementType)
            false
        }
    }
}