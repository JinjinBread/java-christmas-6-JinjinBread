package christmas.domain.discount;

import christmas.domain.benefit.SpecialDiscount;
import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialDiscountTest {

    @Test
    @DisplayName("달력에 별이 있는 날이면 특별 할인을 받을 수 있다")
    void can_special_discount_if_star_day() {

        December december = new December(25);
        SpecialDiscount specialDiscount = new SpecialDiscount(december);

        int discountAmount = specialDiscount.calculateBenefitAmount();

        assertThat(discountAmount).isEqualTo(1000);
    }


}