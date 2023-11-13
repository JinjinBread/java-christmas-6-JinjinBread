package christmas.domain;

import java.util.Map;

public class Order {

    private final Map<Menu, Integer> orderMenu;

    public Order(Map<Menu, Integer> orderMenu) {
        this.orderMenu = orderMenu;
    }

    public Map<Menu, Integer> getOrderMenu() {
        return orderMenu;
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
                count += orderMenu.get(menu);
        }
        return count;
    }

    public boolean isOver(int number) {
        return calculateTotalOrderAmount() >= number;
    }

}
