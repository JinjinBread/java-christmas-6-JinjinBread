package christmas.domain.order;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;

import java.util.Map;

public class Order {

    private final Map<Menu, Integer> orderMenu;
    private final int totalOrderAmount;

    public Order(Map<Menu, Integer> orderMenu) {
        this.orderMenu = orderMenu;
        this.totalOrderAmount = calculateTotalOrderAmount();
    }

    public Map<Menu, Integer> getOrderMenu() {
        return orderMenu;
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

    private int calculateTotalOrderAmount() {

        int totalOrderAmount = 0;

        for (Menu menu : orderMenu.keySet()) {
            Integer menuCount = orderMenu.get(menu);
            totalOrderAmount += menu.calculatePrice(menuCount);
        }

        return totalOrderAmount;
    }

    public int calculateDiscountedPayment(int totalDiscountAmount) {
        return totalOrderAmount + totalDiscountAmount;
    }

    public int countCategoryMenu(Category category) {
        int count = 0;
        for (Menu menu : orderMenu.keySet()) {
            if (Category.isCategoryMenu(menu, category))
                count += orderMenu.get(menu);
        }
        return count;
    }

    public boolean isTotalOrderAmountMoreThan(int number) {
        return totalOrderAmount >= number;
    }

}
