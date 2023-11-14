package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.calendar.December;

import java.util.ArrayList;
import java.util.List;

public class Benefits {

    private final December december;
    private final Order order;
    private final List<Benefit> benefits = new ArrayList<>();
    private final int totalDiscountAmount;
    private final int totalBenefitsAmount;

    public Benefits(December december, Order order) {
        this.december = december;
        this.order = order;
        initBenefits();
        this.totalDiscountAmount = calculateTotalDiscountAmount();
        this.totalBenefitsAmount = calculateTotalBenefitsAmount();
    }

    private void initBenefits() {
        if (order.isMoreThan(10_000)) {
            benefits.add(new ChristmasDiscount(december));
            benefits.add(new WeekdayDiscount(december, order));
            benefits.add(new WeekendDiscount(december, order));
            benefits.add(new SpecialDiscount(december));
            benefits.add(new GiveawayEvent(order));
        }
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public int getTotalBenefitsAmount() {
        return totalBenefitsAmount;
    }

    private int calculateTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Benefit benefit : benefits) {
            if (benefit.isGiveawayEvent()){
                continue;
            }
            totalDiscountAmount += benefit.calculateBenefitAmount();
        }
        return totalDiscountAmount;
    }

    private int calculateTotalBenefitsAmount() {
        int totalDiscountAmount = 0;
        for (Benefit benefit : benefits) {
            totalDiscountAmount += benefit.calculateBenefitAmount();
        }
        return totalDiscountAmount;
    }

//    public List<GiveawayMenu> getGiveawayMenus() {
//
//        return giveawayEvent.getGiveawayMenus();
//    }

//    public Map<String, Integer> getBenefitsDetails() {
//        Map<String, Integer> totalBenefits = new LinkedHashMap<>();
//        discounts.getTotalDiscountDetails(totalBenefits);
//        giveawayEvent.getGiveawayDetails(totalBenefits);
//        return totalBenefits;
//    }

}