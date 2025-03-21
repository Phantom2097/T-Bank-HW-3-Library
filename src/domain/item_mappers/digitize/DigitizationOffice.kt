package domain.item_mappers.digitize

import data.entites.library.Showable
import data.entites.library.items.book.BookImpl
import data.entites.library.items.disk.Disk
import data.entites.library.items.newspaper.NewspaperImpl
import presentation.colors.Colors.ANSI_PURPLE
import presentation.colors.Colors.ANSI_RESET

sealed interface DigitizationOffice {
    class DigitalItem(val item: Showable, private val type: String? = "CD"    ) {
        override fun toString(): String {
            return "\nОцифрованный предмет библиотеки, тип диска $type:\n" +
                    ANSI_PURPLE + item.fullInformation() + ANSI_RESET
        }
    }
    class DigitizeBook(
        private val book: BookImpl,
        override var type: String? = "CD"
    ) : DigitizationOffice, Disk {
        override fun toDigitize(): DigitalItem {
            return DigitalItem(book, type)
        }
    }

    class DigitizeNewspaper(
        private val newspaper: NewspaperImpl,
        override var type: String? = "CD"
    ) : DigitizationOffice, Disk {
        override fun toDigitize(): DigitalItem {
            return DigitalItem(newspaper, type)
        }
    }

    fun toDigitize(): DigitalItem = when (this) {
        is DigitizeBook -> this.toDigitize()
        is DigitizeNewspaper -> this.toDigitize()
    }
}



