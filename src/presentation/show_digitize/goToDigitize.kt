package presentation.show_digitize

import data.repository.LibraryRepository.getBooksInLibrary
import data.repository.LibraryRepository.getNewspapersInLibrary
import domain.item_mappers.digitize.DigitizationOffice.DigitizeBook
import domain.item_mappers.digitize.DigitizationOffice.DigitizeNewspaper

fun goToDigitize(itemType: Int) {
    when (itemType) {
        1 -> {
//            while (true) {
                val book = selectItemForDigitize { getBooksInLibrary() } ?: return
                val dBook = DigitizeBook(book).toDigitize()
                println(dBook)
//            return true
//            }
        }
        2 -> {
//            while (true) {
                val newspaper = selectItemForDigitize { getNewspapersInLibrary() } ?: return
                val dNewspaper = DigitizeNewspaper(newspaper).toDigitize()
                println(dNewspaper)
//            return true
//            }
        }
        else -> return
    }
}