package presentation.main

import data.ItemsInLibrary.addItemBook
import data.ItemsInLibrary.addItemDisk
import data.ItemsInLibrary.addItemNewspaper
import data.ItemsInLibrary.getItemsCounter
import data.Position
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


private fun createBooks() {
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
    addItemBook(
        BookImpl(
            name = "Kotlin Design Patterns and Best Practices",
            id = getItemsCounter(),
            availability = false,
            position = Position.IN_READING_ROOM
        ).apply {
            author = "Alexey Soshin, Anton Arhipov"
            numberOfPages = 356
        })
    addItemBook(
        BookImpl(
            name = "Евгений Онегин",
            id = getItemsCounter(),
            availability = false,
            position = Position.HOME
        ).apply {
            author = "Пушкин А.С."
            numberOfPages = 320
        })
    addItemBook(
        BookImpl(
            name = "Алые Плинтуса",
            id = getItemsCounter(),
            availability = true
        ).apply {
            author = "Саша Зелёный"
        })
    addItemBook(
        BookImpl(
            name = "Война и привет",
            id = getItemsCounter(),
            availability = true
        ))
}

private fun createNewspapers() {
    addItemNewspaper(
        NewspaperImpl(
            name = "Русская правда",
            id = getItemsCounter(),
            availability = false,
            position = Position.IN_READING_ROOM
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
    addItemNewspaper(
        NewspaperImpl(
            name = "Русская ложь",
            id = getItemsCounter(),
            availability = true,
        ))
}

private fun createDisks() {
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
            position = Position.HOME
        )
    )
}