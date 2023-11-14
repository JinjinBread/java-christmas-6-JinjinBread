package christmas.domain.benefit;

import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class WeekdayDiscountTest {

    @Test
    @DisplayName("평일 할인 금액을 계산할 수 있다")
    void calculateBenefitAmount_December_3rd() {

        December december = new December(3);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 1);
                put(Menu.CHOCOLATE_CAKE, 2);
                put(Menu.RED_WINE, 1);
            }
        });
        Benefit weekdayDiscount = new WeekdayDiscount(december, order);

        int discountAmount = weekdayDiscount.calculateBenefitAmount();

        assertThat(discountAmount).isEqualTo(-4046);
    }

    @Test
    @DisplayName("주말이면 평일 할인을 받을 수 없다")
    void isApplied_Weekend() {

        December december = new December(1);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 1);
                put(Menu.CHOCOLATE_CAKE, 2);
                put(Menu.RED_WINE, 1);
            }
        });
        Benefit weekdayDiscount = new WeekdayDiscount(december, order);

        boolean applied = weekdayDiscount.isApplied();

        assertThat(applied).isFalse();
    }

}