package data.entites.shop.disk

import data.entites.library.items.LibraryItem
import data.entites.library.items.disk.DiskImpl
import data.entites.shop.Shop
import domain.LibraryService

private typealias DiskShopType = Shop<DiskImpl>

object DiskShop : DiskShopType {

    private var counter = 0

    override fun sell(): DiskImpl {
        return DiskImpl(
            LibraryItem(
                name = "Диск из магазина $counter",
                id = 2000 + counter++,
                availability = true,
            ),
            LibraryService()
        ).apply {
            type = listOf("DVD", "CD").random()
        }
    }
}