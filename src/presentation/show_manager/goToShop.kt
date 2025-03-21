package presentation.show_manager

import data.entites.shop.Shop
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW


fun <T> goToShop(shop: Shop<T>) {
    while (true) {
        val num = getItemCount() ?: return

        if (num == -1) {
            println("$ANSI_GREEN*Неверное число*$ANSI_RESET")
            println(ANSI_YELLOW + "Попробуйте ещё раз\n" + ANSI_RESET)
            continue
        }

        getShopItem(shop, num)
        return
    }
}