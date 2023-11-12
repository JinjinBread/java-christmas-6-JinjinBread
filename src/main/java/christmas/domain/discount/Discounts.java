package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.Menu;
import christmas.domain.calendar.December;

import java.util.*;

public class Discounts {

    private final List<Discount> discounts = new ArrayList<>();
    private final December december;
    private final Order order;

    public Discounts(December december, Order order) {
        this.december = december;
        this.order = order;
        initDiscounts();
    }

    private void initDiscounts() {
        discounts.add(new ChristmasDiscount(december));
        discounts.add(new WeekdayDiscount(december, order));
        discounts.add(new WeekendDiscount(december, order));
        discounts.add(new SpecialDiscount(december));
    }

    public int calculateTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Discount discount : discounts) {
            totalDiscountAmount += discount.calculateDiscountAmount();
        }
        return totalDiscountAmount;
    }





}
