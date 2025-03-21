package presentation.show_digitize

import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW

fun showStartDigitize() {
    while (true) {
        textForShowStartDigitize()


        val num = getDigitizeType()

        if (num == -1) {
            println("$ANSI_GREEN*Неверное число*$ANSI_RESET")
            println(ANSI_YELLOW + "Попробуйте ещё раз\n" + ANSI_RESET)
            continue
        }

        val exit = goToDigitize(num)
        if (exit) return
    }
}

private fun getDigitizeType(): Int {
    return readlnOrNull()?.toIntOrNull() ?: -1
}

private fun textForShowStartDigitize() {
    println("""
        Выберите что хотите оцифровать
            1 - Книги
            2 - Газеты
            3 - Показать оцифрованные предметы
            4 - Выйти в главное меню
    """.trimIndent())
}