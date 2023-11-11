package christmas.domain.discount;

import christmas.domain.calendar.December;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpecialDiscountTest {

    @Test
    @DisplayName("달력에 별이 있는 날이면 특별 할인을 받을 수 있다")
    void can_special_discount_if_star_day() {

        December december = new December(25);
        SpecialDiscount specialDiscount = new SpecialDiscount(december);

        int discountAmount = specialDiscount.calculateDiscountAmount();

        assertThat(discountAmount).isEqualTo(1000);
    }


}