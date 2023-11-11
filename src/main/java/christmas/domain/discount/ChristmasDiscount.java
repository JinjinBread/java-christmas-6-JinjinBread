package christmas.domain.discount;

import christmas.domain.calendar.December;

public class ChristmasDiscount implements Discount {

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
                    (december.calculateDateDifference(CHRISTMAS_DISCOUNT_EVENT_START_DATE)) * ADD_DISCOUNT_PRICE);
        return 0;
    }

    @Override
    public boolean isEventApplied() {
        return calculateDiscountAmount() != 0;
    }
}
