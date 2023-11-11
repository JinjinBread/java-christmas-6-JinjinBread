package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WeekendDiscountTest {

    @Test
    @DisplayName("주말 할인 금액을 계산할 수 있다")
    void calculate_weekend_discount_amount() {

        December december = new December(1);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 8);
                put(Menu.CHOCOLATE_CAKE, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        Discount weekendDiscount = new WeekendDiscount(december, order);

        int discountAmount = weekendDiscount.calculateDiscountAmount();

        assertThat(discountAmount).isEqualTo(16184);
    }

    @Test
    @DisplayName("평일이면 주말 할인을 받을 수 없다")
    void cant_weekend_discount_if_weekday() {

        December december = new December(27);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 2);
                put(Menu.CHOCOLATE_CAKE, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        Discount weekendDiscount = new WeekendDiscount(december, order);

        int discountAmount = weekendDiscount.calculateDiscountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }

}