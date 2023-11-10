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

    public boolean isOver(int number) {
        return number >= calculateTotalOrderAmount();
    }

}
