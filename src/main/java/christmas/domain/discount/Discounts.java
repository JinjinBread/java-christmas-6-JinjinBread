package christmas.domain.discount;

import java.util.*;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public int calculateTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Discount discount : discounts) {
            totalDiscountAmount += discount.calculateDiscountAmount();
        }
        return totalDiscountAmount;
    }

    public void getTotalDiscountDetails(Map<String, Integer> totalBenefits) {

        for (Discount discount : discounts) {
            int discountAmount = discount.calculateDiscountAmount();
            if (discountAmount != 0)
                totalBenefits.put(discount.getName(), discount.calculateDiscountAmount());
        }
    }

}
