package data.entites.shop.newspaper

import data.entites.library.items.LibraryItem
import data.entites.library.items.newspaper.NewspaperImpl
import data.entites.library.items.newspaper_with_month.Month
import data.entites.library.items.newspaper_with_month.NewspaperWithMonthImpl
import data.entites.shop.Shop
import domain.LibraryService

private typealias NewspaperShopType = Shop<NewspaperImpl>

object NewspaperShop : NewspaperShopType {

    private var counter = 0

    override fun sell(): NewspaperImpl {
        return NewspaperWithMonthImpl(
            LibraryItem(
                name = "Книга из магазина $counter",
                id = 3000 + counter++,
                availability = true,
            ),
            LibraryService()
        ).apply {
            issueNumber = (10000 ..< 100000).random()
            issueMonth = Month.entries.random()
        }
    }
}