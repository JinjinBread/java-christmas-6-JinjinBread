package christmas.domain.benefit;

import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class WeekendDiscountTest {

    @Test
    @DisplayName("주말 할인 금액을 계산할 수 있다")
    void calculateBenefitAmount_December_1st() {

        December december = new December(1);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 5);
                put(Menu.CHOCOLATE_CAKE, 1);
                put(Menu.RED_WINE, 1);
            }
        });

        Benefit weekendDiscount = new WeekendDiscount(december, order);

        int discountAmount = weekendDiscount.calculateBenefitAmount();

        assertThat(discountAmount).isEqualTo(-10115);
    }

    @Test
    @DisplayName("주말이면 주말 할인을 받을 수 있다")
    void isApplied_Weekend() {

        December december = new December(29);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 2);
                put(Menu.CHOCOLATE_CAKE, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        Benefit weekendDiscount = new WeekendDiscount(december, order);

        boolean applied = weekendDiscount.isApplied();

        assertThat(applied).isTrue();
    }

    @Test
    @DisplayName("평일이면 주말 할인을 받을 수 없다")
    void isApplied_Weekday() {

        December december = new December(27);
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.CAESAR_SALAD, 1);
                put(Menu.T_BONE_STEAK, 2);
                put(Menu.CHOCOLATE_CAKE, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        Benefit weekendDiscount = new WeekendDiscount(december, order);

        boolean applied = weekendDiscount.isApplied();

        assertThat(applied).isFalse();
    }

}