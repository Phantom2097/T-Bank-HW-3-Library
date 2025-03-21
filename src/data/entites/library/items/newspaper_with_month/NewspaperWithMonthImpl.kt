package data.entites.library.items.newspaper_with_month

import domain.LibraryService
import data.entites.library.items.LibraryItem
import data.entites.library.items.newspaper.NewspaperImpl
import data.entites.library.items.newspaper_with_month.Month.UNKNOWN
import presentation.colors.Colors.ANSI_BLUE
import presentation.colors.Colors.ANSI_RESET

class NewspaperWithMonthImpl(
    private val item: LibraryItem,
    libraryService: LibraryService
) : NewspaperImpl(item, libraryService),
    NewspaperWithMonth {

    override var issueMonth: Month = UNKNOWN

    override fun fullInformation(): String = this.toString()

    override fun toString(): String {
        val tempAvailability = if (item.availability) "Да" else "Нет"
        val tempMonth = issueMonth.getMonth()
        val tempIssueNumber = issueNumber ?: "*неизвестно*"
        return "Выпуск: $tempIssueNumber газеты ${item.name}" +
                ANSI_BLUE + " за $tempMonth" + ANSI_RESET +
                " с id: ${item.id} доступен: $tempAvailability\n"
    }
}