package presentation.show_manager

import data.entites.shop.Shop
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW
import presentation.show_manager.GoToShopConsts.INVALID_INDEX


fun <T> goToShop(shop: Shop<T>) {
    while (true) {
        val num = getItemCount() ?: return

        if (num == INVALID_INDEX) {
            val message = buildString {
                append(ANSI_GREEN)
                append("*Неверное число*\n")
                append(ANSI_YELLOW)
                append("Попробуйте ещё раз\n")
                append(ANSI_RESET)
            }

            println(message)
            continue
        }

        getShopItem(shop, num)
        return
    }
}

private object GoToShopConsts {
    const val INVALID_INDEX = -1
}