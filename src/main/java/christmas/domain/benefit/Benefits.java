package christmas.domain.benefit;

import christmas.domain.menu.GiveawayMenu;

import java.util.*;

public class Benefits {

    private final List<Benefit> benefits;

    public Benefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public int calculateTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Benefit benefit : benefits) {
            if (benefit.isGiveawayEvent()){
                continue;
            }
            totalDiscountAmount += benefit.calculateBenefitAmount();
        }
        return totalDiscountAmount;
    }

    public int calculateTotalBenefitsAmount() {
        int totalDiscountAmount = 0;
        for (Benefit benefit : benefits) {
            totalDiscountAmount += benefit.calculateBenefitAmount();
        }
        return totalDiscountAmount;
    }

    public List<GiveawayMenu> getGiveawayMenus() {
        for (Benefit benefit : benefits) {
            if (benefit.isGiveawayEvent()) {
                GiveawayEvent giveawayEvent = (GiveawayEvent) benefit;
                return giveawayEvent.getGiveawayMenus();
            }
        }
        return Collections.emptyList(); // 총 주문 금액이 10,000원이 넘지 않는 경우
    }

    public List<String> getBenefitDetails() {
        List<String> totalBenefits = new ArrayList<>();

        for (Benefit benefit : benefits) {
            if (benefit.isApplied())
                totalBenefits.add(benefit.toString());
        }

        return totalBenefits;
    }

}