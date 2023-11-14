package christmas.service;

import christmas.domain.badge.Badge;
import christmas.domain.benefit.*;
import christmas.domain.calendar.December;
import christmas.domain.order.Order;

import java.util.ArrayList;
import java.util.List;

public class PlannerService {

    private static final int THRESHOLD = 10_000;

    public Benefits generateBenefits(December december, Order order) {
        List<Benefit> benefits = initBenefits(december, order);
        return new Benefits(benefits);
    }

    private List<Benefit> initBenefits(December december, Order order) {
        List<Benefit> benefits = new ArrayList<>();

        if (order.calculateTotalOrderAmount() >= THRESHOLD) {
            benefits.add(new ChristmasDiscount(december));
            benefits.add(new WeekdayDiscount(december, order));
            benefits.add(new WeekendDiscount(december, order));
            benefits.add(new SpecialDiscount(december));
            benefits.add(new GiveawayEvent(order));
        }

        return benefits;
    }

    public int calculateDiscountedPaymentAmount(Order order, Benefits benefits) {
        int totalOrderAmount = order.calculateTotalOrderAmount();
        int totalDiscountAmount = benefits.calculateTotalDiscountAmount();
        return totalOrderAmount + totalDiscountAmount;
    }

    public String getEventBadge(int totalBenefitAmount) {
        return Badge.getBadgeByTotalBenefitAmount(totalBenefitAmount).getName();
    }

}
