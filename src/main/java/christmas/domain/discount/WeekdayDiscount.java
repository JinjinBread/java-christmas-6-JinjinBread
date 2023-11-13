package christmas.domain.discount;

import christmas.domain.Category;
import christmas.domain.Order;
import christmas.domain.calendar.December;

public class WeekdayDiscount implements Discount {

    private static final int WEEKDAY_DISCOUNT_PRICE = 2_023;
    private static final Category WEEKDAY_DISCOUNT_CATEGORY = Category.DESSERT;

    private final String name = "평일 할인";
    private final December december;
    private final Order order;

    public WeekdayDiscount(December december, Order order) {
        this.december = december;
        this.order = order;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateDiscountAmount() {
        if (december.isWeekday()) {
            int dessertCount = order.countCategoryMenu(WEEKDAY_DISCOUNT_CATEGORY);
            return dessertCount * WEEKDAY_DISCOUNT_PRICE * -1;
        }
        return 0;
    }

}
