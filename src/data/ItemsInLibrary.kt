package data

import data.entites.items.LibraryItem
import data.entites.items.book.BookImpl
import data.entites.items.disk.DiskImpl
import data.entites.items.newspaper.NewspaperImpl
import presentation.colors.Colors.ANSI_RED
import presentation.colors.Colors.ANSI_RESET

object ItemsInLibrary {

    private val _booksList by lazy { mutableListOf<BookImpl>() }
    private val _disksList by lazy { mutableListOf<DiskImpl>() }
    private val _newspapersList by lazy { mutableListOf<NewspaperImpl>() }

    private var itemsCounter = 0

    // Book
    fun addItemBook(book: BookImpl) { _booksList.add(book) }
    fun getBooksInLibrary(): List<BookImpl> = _booksList.ifEmpty {
        println(ANSI_RED + "На данный момент в библиотеке нет ни одной книги 🤷‍♂️\n" + ANSI_RESET)
        emptyList()
    }
//    fun setAvailabilityBook(id: Int, availability: Boolean) { _booksMap[id].availability = availability }
//    fun setBookPosition(num: Int, position: Position) { _booksList[num].position = position }

    // Newspaper
    fun addItemNewspaper(newspaper: NewspaperImpl) { _newspapersList.add(newspaper) }
    fun getNewspapersInLibrary(): List<NewspaperImpl> = _newspapersList.ifEmpty {
        println(ANSI_RED + "На данный момент в библиотеке нет ни одной газеты 🤷‍♂️\n" + ANSI_RESET)
        emptyList()
    }
//    fun setAvailabilityNewspaper(id: Int, availability: Boolean) { _newspapersMap[id].availability = availability }
//    fun setNewspaperPosition(num: Int, position: Position) { _newspapersList[num].position = position }

    // Disk
    fun addItemDisk(disk: DiskImpl) { _disksList.add(disk) }
    fun getDisksInLibrary(): List<DiskImpl> = _disksList.ifEmpty {
        println(ANSI_RED + "На данный момент в библиотеке нет ни одного диска 🤷‍♂️\n" + ANSI_RESET)
        emptyList()
    }
//    fun setAvailabilityDisk(id: Int, availability: Boolean) { _disksList[id].availability = availability }
//    fun setDiskPosition(num: Int, position: Position) { _disksList[num].position = position }

    // ItemsCounter
    fun getItemsCounter() = itemsCounter++

    fun <T : LibraryItem> setPosition(num: Int, position: Position, item: T) {
        when (item) {
            is BookImpl -> _booksList[num].position = position
            is NewspaperImpl -> if (position != Position.HOME) _newspapersList[num].position = position
            is DiskImpl -> if (position != Position.IN_READING_ROOM) _disksList[num].position = position
            else -> println("Неизвестный тип элемента")
        }
    }
}