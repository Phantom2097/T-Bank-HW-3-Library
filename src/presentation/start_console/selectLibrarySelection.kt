package presentation.start_console

import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW

private typealias MethodType = (Int) -> Unit

internal fun selectLibrarySelection(method: MethodType): Boolean {
    return when (val elementType = readlnOrNull()?.toIntOrNull()) {
        null -> {
            println(ANSI_YELLOW + "Попробуйте ещё раз\n" + ANSI_RESET)
            false
        }
        4 -> TODO("Сделать реализацию Магазина и менеджера")
        5 -> true
        else -> {
            method(elementType)
            false
        }
    }
}