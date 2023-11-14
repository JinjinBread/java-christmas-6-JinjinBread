package christmas.domain.badge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @Test
    @DisplayName("고객의 총 혜택 금액이 9,000원인 경우 별 배지를 부여받을 수 있다.")
    void getBadgeByTotalBenefitAmount_9000_Star() {
        int totalBenefitAmount = -9_000;

        Badge badgeByTotalBenefitAmount = Badge.getBadgeByTotalBenefitAmount(totalBenefitAmount);

        Assertions.assertThat(badgeByTotalBenefitAmount).isEqualTo(Badge.STAR);
    }

    @Test
    @DisplayName("고객의 총 혜택 금액이 12,000원인 경우 트리 배지를 부여받을 수 있다.")
    void getBadgeByTotalBenefitAmount_12000_Tree() {
        int totalBenefitAmount = -12_000;

        Badge badgeByTotalBenefitAmount = Badge.getBadgeByTotalBenefitAmount(totalBenefitAmount);

        Assertions.assertThat(badgeByTotalBenefitAmount).isEqualTo(Badge.TREE);
    }

    @Test
    @DisplayName("고객의 총 혜택 금액이 25,000원인 경우 산타 배지를 부여받을 수 있다.")
    void getBadgeByTotalBenefitAmount_25000_Santa() {
        int totalBenefitAmount = -25_000;

        Badge badgeByTotalBenefitAmount = Badge.getBadgeByTotalBenefitAmount(totalBenefitAmount);

        Assertions.assertThat(badgeByTotalBenefitAmount).isEqualTo(Badge.SANTA);
    }

    @Test
    @DisplayName("고객의 총 혜택 금액이 5,000원 미만인 경우 산타 배지를 부여받을 수 없다.")
    void getBadgeByTotalBenefitAmount_4999_None() {
        int totalBenefitAmount = 0;

        Badge badgeByTotalBenefitAmount = Badge.getBadgeByTotalBenefitAmount(totalBenefitAmount);

        Assertions.assertThat(badgeByTotalBenefitAmount).isEqualTo(Badge.NONE);
    }

}