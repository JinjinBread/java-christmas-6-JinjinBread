package christmas.domain.benefit;

import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialDiscountTest {

    @Test
    @DisplayName("달력에 별이 있는 날이면 특별 할인을 받을 수 있다")
    void calculateBenefitAmount_Special_Day() {

        December december = new December(25);
        Benefit specialDiscount = new SpecialDiscount(december);

        int discountAmount = specialDiscount.calculateBenefitAmount();

        assertThat(discountAmount).isEqualTo(-1000);
    }

    @Test
    @DisplayName("달력에 별이 없는 날이면 특별 할인을 받을 수 없다")
    void calculateBenefitAmount_Ordinary_Day() {

        December december = new December(26);
        Benefit specialDiscount = new SpecialDiscount(december);

        int discountAmount = specialDiscount.calculateBenefitAmount();

        assertThat(discountAmount).isEqualTo(0);
    }


}