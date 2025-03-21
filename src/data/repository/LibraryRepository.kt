package data.repository

import data.entites.library.items.book.BookImpl
import data.entites.library.items.disk.DiskImpl
import data.entites.library.items.newspaper.NewspaperImpl
import presentation.colors.Colors.ANSI_CYAN
import presentation.colors.Colors.ANSI_RED
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW

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

    fun <LibraryType> addItem(item: LibraryType) {
        when (item) {
            is BookImpl -> _booksList.add(item)
            is NewspaperImpl-> _newspapersList.add(item)
            is DiskImpl -> _disksList.add(item)
            else -> {
                println(ANSI_RED + "Подборки для этого предмета в библиотеке нет!!!" + ANSI_RESET)
            }
        }
    }

    inline fun <reified T> getItem(items: List<T>, num: Int): T? {
        return items.getOrElse(num) {
            println(ANSI_YELLOW + "Неверный порядковый номер\n" + ANSI_CYAN + "\tПопробуйте ещё раз\n" + ANSI_RESET)
            null
        }
    }

    // ItemsCounter
    fun getItemsCounter() = itemsCounter++
}