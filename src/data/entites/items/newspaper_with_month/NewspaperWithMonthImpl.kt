package data.entites.items.newspaper_with_month

import domain.LibraryService
import data.entites.items.LibraryItem
import data.entites.items.newspaper.NewspaperImpl
import data.entites.items.newspaper_with_month.Month.UNKNOWN

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
        return "Выпуск: $tempIssueNumber газеты ${item.name} за $tempMonth с id: ${item.id} доступен: $tempAvailability\n"
    }
}