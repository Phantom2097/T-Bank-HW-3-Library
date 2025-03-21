package data.entites.shop.book

import data.entites.library.items.LibraryItem
import data.entites.library.items.book.BookImpl
import data.entites.shop.Shop
import domain.LibraryService

private typealias BookShopType = Shop<BookImpl>

object BookShop : BookShopType {

    private var counter = 0

    override fun sell(): BookImpl {
        return BookImpl(
            LibraryItem(
                name = "Книга из магазина $counter",
                id = 1000 + counter++,
                availability = true,
            ),
            LibraryService()
        ).apply {
            this.author = "МАГАЗИН"
            this.numberOfPages = Int.MAX_VALUE
        }
    }
}