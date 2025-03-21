package presentation.show_manager

fun getItemCount(): Int? {

    println("Введите количество, которое Менеджер должен приобрести\n" +
            "Нажмите Enter для выхода")

    return (readlnOrNull()?.run {
        if (isBlank()) return null
        else toIntOrNull()
    } ?: -1)
}
