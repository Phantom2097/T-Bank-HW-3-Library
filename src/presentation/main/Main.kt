package presentation.main

import data.ItemsInLibrary.addItemBook
import data.ItemsInLibrary.addItemDisk
import data.ItemsInLibrary.addItemNewspaper
import data.ItemsInLibrary.getItemsCounter
import data.entites.items.book.BookImpl
import data.entites.items.disk.DiskImpl
import data.entites.items.newspaper.NewspaperImpl
import presentation.start_console.showConsoleStartLibraryUI

fun main() {
    createBooks()
    createNewspapers()
    createDisks()

    showConsoleStartLibraryUI()
}


fun createBooks() {
    addItemBook(
        BookImpl(
            name = "Котлин для профессионалов",
            id = getItemsCounter(),
            availability = true,
        ).apply {
            author = "Джош Скин, Дэвид Грэнхол, Эндрю Бэйли"
            numberOfPages = 560
        })
    addItemBook(
        BookImpl(
            name = "Маугли",
            id = getItemsCounter(),
            availability = false,
        ).apply {
            author = "Джозеф Киплинг"
            numberOfPages = 202
        })
}

fun createNewspapers() {
    addItemNewspaper(
        NewspaperImpl(
            name = "Русская правда",
            id = getItemsCounter(),
            availability = false,
        ).apply {
            issueNumber = 794
        })
    addItemNewspaper(
        NewspaperImpl(
            name = "Русская правда",
            id = getItemsCounter(),
            availability = true,
        ).apply {
            issueNumber = 795
        })
    addItemNewspaper(
        NewspaperImpl(
            name = "Русская правда",
            id = getItemsCounter(),
            availability = true,
        ).apply {
            issueNumber = 796
        })
}

fun createDisks() {
    addItemDisk(
        DiskImpl(
            name = "Дэдпул и Росомаха",
            id = getItemsCounter(),
            availability = true,
        ).apply {
            type = "DVD"
        })

    addItemDisk(
        DiskImpl(
            name = "Какая-то песня",
            id = getItemsCounter(),
            availability = true,
        ).apply {
            type = "CD"
        })

    addItemDisk(
        DiskImpl(
            name = "Просто диск",
            id = getItemsCounter(),
            availability = false,
        )
    )
}