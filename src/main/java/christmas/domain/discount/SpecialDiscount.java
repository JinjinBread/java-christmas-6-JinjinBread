package christmas.domain.discount;

import christmas.domain.calendar.December;

public class SpecialDiscount implements Discount {

    private final String name = "특별 할인";
    private final December december;

    public SpecialDiscount(December december) {
        this.december = december;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateDiscountAmount() {
        if (december.isSpecialDay())
            return SPECIAL_DISCOUNT_PRICE;
        return 0;
    }

    @Override
    public boolean isEventApplied() {
        return calculateDiscountAmount() != 0;
    }
}
