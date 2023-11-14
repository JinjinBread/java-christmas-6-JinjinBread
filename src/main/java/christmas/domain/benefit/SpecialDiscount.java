package christmas.domain.benefit;

import christmas.domain.calendar.December;

public class SpecialDiscount extends Benefit {

    private static final int SPECIAL_DISCOUNT_PRICE = 1_000;

    private final String title = "특별 할인";
    private final December december;

    public SpecialDiscount(December december) {
        this.december = december;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int calculateBenefitAmount() {
        if (december.isSpecialDay())
            return SPECIAL_DISCOUNT_PRICE * -1;
        return 0;
    }

    @Override
    public boolean isGiveawayEvent() {
        return false;
    }

}
