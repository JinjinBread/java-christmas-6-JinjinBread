package christmas.domain.benefit;

import christmas.domain.calendar.December;

public class ChristmasDiscount extends Benefit {

    private static final int CHRISTMAS_DISCOUNT_EVENT_START_DATE = 1;
    private static final int START_DISCOUNT_PRICE = 1_000;
    private static final int ADD_DISCOUNT_PRICE = 100;

    private final String title = "크리스마스 디데이 할인";
    private final December december;

    public ChristmasDiscount(December december) {
        this.december = december;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int calculateBenefitAmount() {
        if (december.isChristmasPeriod())
            return (START_DISCOUNT_PRICE +
                    (december.calculateDateDifference(CHRISTMAS_DISCOUNT_EVENT_START_DATE)) * ADD_DISCOUNT_PRICE) * -1;
        return 0;
    }

    @Override
    public boolean isGiveawayEvent() {
        return false;
    }

}
