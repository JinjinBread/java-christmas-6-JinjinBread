package christmas.domain.benefit;

public abstract class Benefit {

    public abstract String getTitle();
    public abstract int calculateBenefitAmount();

    public boolean isApplied() { return calculateBenefitAmount() != 0; }

    public abstract boolean isGiveawayEvent();
}
