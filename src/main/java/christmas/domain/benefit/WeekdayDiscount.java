package christmas.domain.benefit;

import christmas.domain.menu.Category;
import christmas.domain.order.Order;
import christmas.domain.calendar.December;

public class WeekdayDiscount extends Benefit {

    private static final int WEEKDAY_DISCOUNT_PRICE = 2_023;
    private static final Category WEEKDAY_DISCOUNT_CATEGORY = Category.DESSERT;

    private final String title = "평일 할인";
    private final December december;
    private final Order order;

    public WeekdayDiscount(December december, Order order) {
        this.december = december;
        this.order = order;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int calculateBenefitAmount() {
        if (december.isWeekday()) {
            int dessertCount = order.countCategoryMenu(WEEKDAY_DISCOUNT_CATEGORY);
            return dessertCount * WEEKDAY_DISCOUNT_PRICE * -1;
        }
        return 0;
    }

    @Override
    public boolean isGiveawayEvent() {
        return false;
    }

}
