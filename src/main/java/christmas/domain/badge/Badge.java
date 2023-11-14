package christmas.domain.badge;

import java.util.Comparator;
import java.util.stream.Stream;

public enum Badge {

    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    NONE("없음", 0);

    private final String name;
    private final int standard;

    Badge(String name, int standard) {
        this.name = name;
        this.standard = standard;
    }

    private int getStandard() {
        return standard;
    }

    public static Badge getBadgeByTotalBenefitAmount(int totalBenefitAmount) {
        return Stream.of(values())
                .sorted(Comparator.comparingInt(Badge::getStandard).reversed())
                .filter(badge -> !badge.equals(NONE) && totalBenefitAmount >= badge.standard)
                .findFirst()
                .orElse(NONE);
    }

}
