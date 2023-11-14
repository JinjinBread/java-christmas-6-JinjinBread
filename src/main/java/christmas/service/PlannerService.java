package christmas.service;

import christmas.domain.benefit.Benefits;
import christmas.domain.order.Order;

public class PlannerService {

    public int calculateDiscountedPaymentAmount(Order order, Benefits benefits) {
        int totalOrderAmount = order.getTotalOrderAmount();
        int totalDiscountAmount = benefits.getTotalDiscountAmount();
        return totalDiscountAmount + totalDiscountAmount;
    }

}
