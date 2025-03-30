package data.entites.shop.disk

import data.entites.library.items.LibraryItem
import data.entites.library.items.disk.DiskImpl
import data.entites.library.items.disk.Type
import data.entites.shop.Shop
import data.entites.shop.disk.DiskShop.DiskShopConsts.DISK_SHOP_ID
import data.entites.shop.disk.DiskShop.DiskShopConsts.START_COUNTER_INDEX
import data.entites.shop.disk.DiskShop.DiskShopConsts.START_TYPE_INDEX
import domain.LibraryService

private typealias DiskShopType = Shop<DiskImpl>

object DiskShop : DiskShopType {

    private var counter = START_COUNTER_INDEX

    override fun sell(): DiskImpl {
        return DiskImpl(
            LibraryItem(
                name = "Диск из магазина $counter",
                id = DISK_SHOP_ID + counter++,
                availability = true,
            ),
            LibraryService()
        ).apply {
            val typeSize = Type.entries.size
            type = Type.entries[(START_TYPE_INDEX ..< typeSize).random()]
        }
    }

    private object DiskShopConsts {
        const val START_TYPE_INDEX = 0
        const val START_COUNTER_INDEX = 0
        const val DISK_SHOP_ID = 2000
    }
}