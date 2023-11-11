package christmas.domain.discount;

import christmas.domain.Order;

import java.util.List;

public class Discounts {

    private List<Discount> discounts;
    private int date;
    private Order order;

    public Discounts(int date, Order order) {
        this.date = date;
        this.order = order;
    }

//    private void initDiscounts() {
//        discounts.add(new ChristmasDiscount());
//        discounts.add(new WeekDayDiscount());
//        discounts.add(new WeekendDiscount());
//        discounts.add(new SpecialDiscount());
//        discounts.add(new GiveawayDiscount());
//    }




}
