package domain.item_mappers.shop_to_library

import data.entites.library.items.LibraryItem
import data.entites.shop.ShopItem

fun ShopItem.toLibraryItem() = LibraryItem (this.name, this.id)
