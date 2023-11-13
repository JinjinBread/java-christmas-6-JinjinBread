package christmas.domain.discount;

import christmas.domain.calendar.December;

public class ChristmasDiscount implements Discount {

    private static final int CHRISTMAS_DISCOUNT_EVENT_START_DATE = 1;
    private static final int START_DISCOUNT_PRICE = 1_000;
    private static final int ADD_DISCOUNT_PRICE = 100;

    private final String name = "크리스마스 디데이 할인";
    private final December december;

    public ChristmasDiscount(December december) {
        this.december = december;
    }

    public String getName() {
        return name;
    }

    @Override
    public int calculateDiscountAmount() {
        if (december.isChristmasPeriod())
            return (START_DISCOUNT_PRICE +
                    (december.calculateDateDifference(CHRISTMAS_DISCOUNT_EVENT_START_DATE)) * ADD_DISCOUNT_PRICE) * -1;
        return 0;
    }

}
