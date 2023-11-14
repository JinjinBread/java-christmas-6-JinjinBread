package christmas.domain.benefit;

import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasDiscountTest {

    @Test
    @DisplayName("크리스마스 할인 이벤트의 할인 금액을 구할 수 있다")
    void calculateBenefitAmount_December_5th() {

        December december = new December(5);
        Benefit christmasDiscount = new ChristmasDiscount(december);

        int discountAmount = christmasDiscount.calculateBenefitAmount();

        assertThat(discountAmount).isEqualTo(-1400);
    }

    @Test
    @DisplayName("크리스마스 기간이 아니면 크리스마스 할인 이벤트가 적용되지 않는다")
    void isApplied_December_26th() {

        December december = new December(26);
        Benefit christmasDiscount = new ChristmasDiscount(december);

        boolean applied = christmasDiscount.isApplied();

        assertThat(applied).isFalse();
    }

}