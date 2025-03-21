package presentation.show_manager

import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW

fun showShops() {
    while (true) {
        textForShowShops()
        val num = getShopNumber()
        if (num == -1) {
            println("$ANSI_GREEN*Неверное число*$ANSI_RESET")
            println(ANSI_YELLOW + "Попробуйте ещё раз\n" + ANSI_RESET)
            continue
        }
        val exit = selectShop(num)
        if (exit) return
    }
}

private fun textForShowShops() {
    println("""
        Введите номер магазина, в который должен пойти менеджер
            1 - Магазин книг
            2 - Газетный киоск
            3 - Магазин дисков
            4 - Выйти в главное меню
    """.trimIndent())
}

private fun getShopNumber(): Int {
    return readlnOrNull()?.toIntOrNull() ?: -1
}