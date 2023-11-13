package christmas.domain.discount;

import christmas.domain.calendar.December;

public class SpecialDiscount implements Discount {

    private static final int SPECIAL_DISCOUNT_PRICE = 1_000;

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
            return SPECIAL_DISCOUNT_PRICE * -1;
        return 0;
    }

}
