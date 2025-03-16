package data

import data.entites.items.book.BookImpl
import data.entites.items.disk.DiskImpl
import data.entites.items.newspaper.NewspaperImpl
import presentation.colors.Colors.ANSI_RED
import presentation.colors.Colors.ANSI_RESET

object LibraryRepository {
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

    // Newspaper
    fun addItemNewspaper(newspaper: NewspaperImpl) { _newspapersList.add(newspaper) }
    fun getNewspapersInLibrary(): List<NewspaperImpl> = _newspapersList.ifEmpty {
        println(ANSI_RED + "На данный момент в библиотеке нет ни одной газеты 🤷‍♂️\n" + ANSI_RESET)
        emptyList()
    }

    // Disk
    fun addItemDisk(disk: DiskImpl) { _disksList.add(disk) }
    fun getDisksInLibrary(): List<DiskImpl> = _disksList.ifEmpty {
        println(ANSI_RED + "На данный момент в библиотеке нет ни одного диска 🤷‍♂️\n" + ANSI_RESET)
        emptyList()
    }

    // ItemsCounter
    fun getItemsCounter() = itemsCounter++
}