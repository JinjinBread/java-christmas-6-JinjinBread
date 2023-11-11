package christmas.domain.discount;

import christmas.domain.calendar.December;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountTest {

    @Test
    @DisplayName("크리스마스_디데이_할인_이벤트의_할인_금액을_구할_수_있다")
    void calculate_christmas_discount_amount() {

        December december = new December(5);
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(december);

        int discountAmount = christmasDiscount.calculateDiscountAmount();

        assertThat(discountAmount).isEqualTo(1400);
    }

    @Test
    @DisplayName("크리스마스 기간이 아니면 크리스마스 할인을 받을 수 없다")
    void no_christmas_discount_if_not_christmas_period() {

        December december = new December(26);
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(december);

        boolean eventApplied = christmasDiscount.isEventApplied();

        assertThat(eventApplied).isFalse();
    }
}