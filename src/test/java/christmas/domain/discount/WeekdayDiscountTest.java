package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.benefit.WeekdayDiscount;
import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class WeekdayDiscountTest {

    @Test
    @DisplayName("평일 할인 금액을 계산할 수 있다")
    void calculate_weekday_discount_amount() {

        December december = new December(3);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 1);
                put(Menu.CHOCOLATE_CAKE, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        Discount weekdayDiscount = new WeekdayDiscount(december, order);

        int discountAmount = weekdayDiscount.calculateDiscountAmount();

        assertThat(discountAmount).isEqualTo(2023);
    }

    @Test
    @DisplayName("주말이면 평일 할인을 받을 수 없다")
    void cant_weekday_discount_if_weekend() {

        December december = new December(1);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 1);
                put(Menu.CHOCOLATE_CAKE, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        Discount weekdayDiscount = new WeekdayDiscount(december, order);

        int discountAmount = weekdayDiscount.calculateDiscountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }

}