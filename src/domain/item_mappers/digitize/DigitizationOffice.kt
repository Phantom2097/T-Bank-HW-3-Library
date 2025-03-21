package domain.item_mappers.digitize

import data.entites.library.Showable
import data.entites.library.items.book.BookImpl
import data.entites.library.items.disk.Disk
import data.entites.library.items.newspaper.NewspaperImpl
import presentation.colors.Colors.ANSI_PURPLE
import presentation.colors.Colors.ANSI_RESET

sealed interface DigitizationOffice {
    data class DigitalItem(val item: Showable, private val type: String? = "CD"): Showable {
        override fun briefInformation(): String {
            return item.briefInformation() + ANSI_PURPLE + "\n\t\t**Оцифрована на CD**" + ANSI_RESET
        }

        override fun fullInformation(): String {
            return this.toString()
        }

        override fun toString(): String {
            return ANSI_PURPLE + "Оцифрованный предмет библиотеки, тип диска $type:\n" + ANSI_RESET +
                    item.fullInformation()
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



