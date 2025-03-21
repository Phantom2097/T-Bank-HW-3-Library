package presentation.show_items

fun getItemNumber(): Int? {
    println("\nВведите номер для дальнейших действий\nНажмите Enter для выхода")

    return (readlnOrNull()?.run {
        if (isBlank()) return null
        else toIntOrNull()
    } ?: 0) - 1
}

