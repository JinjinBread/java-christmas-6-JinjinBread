package christmas.domain.benefit;

import christmas.domain.Category;
import christmas.domain.Order;
import christmas.domain.calendar.December;

public class WeekendDiscount extends Benefit {

    private static final int WEEKEND_DISCOUNT_PRICE = 2_023;
    private static final Category WEEKEND_DISCOUNT_CATEGORY = Category.MAIN;

    private final String title = "주말 할인";
    private final December december;
    private final Order order;

    public WeekendDiscount(December december, Order order) {
        this.december = december;
        this.order = order;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int calculateBenefitAmount() {
        if (december.isWeekend()) {
            int mainCount = order.countCategoryMenu(WEEKEND_DISCOUNT_CATEGORY);
            return mainCount * WEEKEND_DISCOUNT_PRICE * -1;
        }
        return 0;
    }

    @Override
    public boolean isGiveawayEvent() {
        return false;
    }

}
