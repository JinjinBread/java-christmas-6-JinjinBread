package christmas.domain;

import java.util.Map;

public class Order {

    private final Map<Menu, Integer> orderMenu;

    public Order(Map<Menu, Integer> orderMenu) {
        this.orderMenu = orderMenu;
    }

    public int calculateTotalOrderAmount() {

        int totalOrderAmount = 0;

        for (Menu menu : orderMenu.keySet()) {
            Integer menuCount = orderMenu.get(menu);
            totalOrderAmount += menu.calculatePrice(menuCount);
        }

        return totalOrderAmount;
    }

    public int countCategoryMenu(Category category) {
        int count = 0;
        for (Menu menu : orderMenu.keySet()) {
            if (Category.isCategoryMenu(menu, category))
                count++;
        }
        return count;
    }

    public boolean isOver(int number) {
        return number >= calculateTotalOrderAmount();
    }

}
