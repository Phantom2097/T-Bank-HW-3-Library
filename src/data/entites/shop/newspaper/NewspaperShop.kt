package data.entites.shop.newspaper

import data.entites.library.items.LibraryItem
import data.entites.library.items.newspaper.NewspaperImpl
import data.entites.library.items.newspaper_with_month.Month
import data.entites.library.items.newspaper_with_month.NewspaperWithMonthImpl
import data.entites.shop.Shop
import data.entites.shop.newspaper.NewspaperShop.NewspaperShopConsts.END_ISSUE_NUMBER
import data.entites.shop.newspaper.NewspaperShop.NewspaperShopConsts.NEWSPAPER_SHOP_ID
import data.entites.shop.newspaper.NewspaperShop.NewspaperShopConsts.START_COUNTER_INDEX
import data.entites.shop.newspaper.NewspaperShop.NewspaperShopConsts.START_ISSUE_NUMBER
import domain.LibraryService

private typealias NewspaperShopType = Shop<NewspaperImpl>

object NewspaperShop : NewspaperShopType {

    private var counter = START_COUNTER_INDEX

    override fun sell(): NewspaperImpl {
        return NewspaperWithMonthImpl(
            LibraryItem(
                name = "Газета из магазина $counter",
                id = NEWSPAPER_SHOP_ID + counter++,
                availability = true,
            ),
            LibraryService()
        ).apply {
            issueNumber = (START_ISSUE_NUMBER ..< END_ISSUE_NUMBER).random()
            issueMonth = Month.entries.random()
        }
    }

    private object NewspaperShopConsts {
        const val START_COUNTER_INDEX = 0
        const val NEWSPAPER_SHOP_ID = 3000
        const val START_ISSUE_NUMBER = 10000
        const val END_ISSUE_NUMBER = 100000
    }
}