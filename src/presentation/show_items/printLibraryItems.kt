package presentation.show_items

import data.repository.LibraryRepository.getBooksInLibrary
import data.repository.LibraryRepository.getDisksInLibrary
import data.repository.LibraryRepository.getNewspapersInLibrary


fun printLibraryItems(itemsType: Int) {
    when (itemsType) {
        1 -> selectItem { getBooksInLibrary() }
        2 -> selectItem { getNewspapersInLibrary() }
        3 -> selectItem { getDisksInLibrary() }
    }
}


