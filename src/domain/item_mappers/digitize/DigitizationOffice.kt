package domain.item_mappers.digitize

import data.entites.library.Showable
import data.entites.library.items.book.BookImpl
import data.entites.library.items.newspaper.NewspaperImpl
import domain.item_mappers.digitize.DigitizationOffice.DigitalType.CD
import presentation.colors.Colors.ANSI_PURPLE
import presentation.colors.Colors.ANSI_RESET

sealed interface DigitizationOffice {
    data class DigitalItem(val item: Showable, private val type: DigitalType = CD): Showable {
        override fun briefInformation(): String {
            return buildString {
                append(item.briefInformation())
                append(ANSI_PURPLE)
                append("\n\t\t**Оцифрована на ${type.getDigitalType()}**")
                append(ANSI_RESET)
            }
        }

        override fun fullInformation(): String {
            return this.toString()
        }

        override fun toString(): String {
            return buildString {
                append(ANSI_PURPLE)
                append("Оцифрованный предмет библиотеки, тип диска $type:\n")
                append(ANSI_RESET)
                append(item.fullInformation())
            }
        }
    }
    class DigitizeBook(
        private val book: BookImpl,
        private var type: DigitalType = CD
    ) : DigitizationOffice {
        override fun toDigitize(): DigitalItem {
            return DigitalItem(book, type)
        }
    }

    class DigitizeNewspaper(
        private val newspaper: NewspaperImpl,
        private var type: DigitalType = CD
    ) : DigitizationOffice {
        override fun toDigitize(): DigitalItem {
            return DigitalItem(newspaper, type)
        }
    }

    enum class DigitalType(private val type: String) {
        CD("CD");

        fun getDigitalType() = type
    }

    fun toDigitize(): DigitalItem = when (this) {
        is DigitizeBook -> this.toDigitize()
        is DigitizeNewspaper -> this.toDigitize()
    }
}