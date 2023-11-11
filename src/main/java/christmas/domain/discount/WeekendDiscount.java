package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.calendar.December;

public class WeekendDiscount implements Discount {


    private final String name = "주말 할인";
    private final December december;
    private final Order order;

    public WeekendDiscount(December december, Order order) {
        this.december = december;
        this.order = order;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateDiscountAmount() {
        if (december.isWeekend()) {
            int mainCount = order.countCategoryMenu(WEEKEND_DISCOUNT_CATEGORY);
            return mainCount * WEEK_DISCOUNT_PRICE;
        }
        return 0;
    }

    @Override
    public boolean isEventApplied() {
        return calculateDiscountAmount() != 0;
    }
}
