package christmas.service;

import christmas.domain.benefit.Benefits;
import christmas.domain.order.Order;

public class PlannerService {

    public int calculateDiscountedPaymentAmount(Order order, Benefits benefits) {
        int totalOrderAmount = order.calculateTotalOrderAmount();
        int totalDiscountAmount = benefits.calculateTotalDiscountAmount();
        return totalDiscountAmount + totalDiscountAmount;
    }

}
