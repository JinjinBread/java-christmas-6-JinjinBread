package christmas.domain.benefit;

import java.text.DecimalFormat;

public abstract class Benefit {

    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public abstract String getTitle();
    public abstract int calculateBenefitAmount();

    public boolean isApplied() { return calculateBenefitAmount() != 0; }

    public abstract boolean isGiveawayEvent();

    @Override
    public String toString() {
        return getTitle() + ": " +
                decimalFormat.format(calculateBenefitAmount()) + "원";
    }
}
