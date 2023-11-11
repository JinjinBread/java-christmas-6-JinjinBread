package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.calendar.December;

public class WeekdayDiscount implements Discount {


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
            return dessertCount * WEEK_DISCOUNT_PRICE;
        }
        return 0;
    }

    @Override
    public boolean isEventApplied() {
        return calculateDiscountAmount() != 0;
    }
}
