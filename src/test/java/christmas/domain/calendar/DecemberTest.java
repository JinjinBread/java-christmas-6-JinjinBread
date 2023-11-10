package christmas.domain.calendar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecemberTest {

    @Test
    void 무슨_날인지_모두_출력() {
        December december = new December(25);

        boolean isChristmasPeriod = december.isChristmasPeriod();
        boolean isSpecialDay = december.isSpecialDay();
        boolean isWeekDay = december.isWeekday();
        boolean isWeekend = december.isWeekend();

        Assertions.assertThat(isChristmasPeriod).isEqualTo(true);
        Assertions.assertThat(isSpecialDay).isEqualTo(true);
        Assertions.assertThat(isWeekDay).isEqualTo(true);
        Assertions.assertThat(isWeekend).isEqualTo(false);
    }

    @Test
    void 유효하지_않은_날짜_생성() {
        Assertions.assertThatThrownBy(() -> new December(33))
                .isInstanceOf(IllegalArgumentException.class);
    }

}