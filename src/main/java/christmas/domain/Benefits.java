package christmas.domain;

import christmas.domain.discount.Discounts;
import christmas.domain.discount.GiveawayEvent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Benefits {

    private final Discounts discounts;
    private final GiveawayEvent giveawayEvent;

    public Benefits(Discounts discounts, GiveawayEvent giveawayEvent) {
        this.discounts = discounts;
        this.giveawayEvent = giveawayEvent;
    }

    public List<GiveawayMenu> getGiveawayMenus() {
        return giveawayEvent.getGiveawayMenus();
    }

    public int calculateTotalBenefitsAmount() {
        return discounts.calculateTotalDiscountAmount() + giveawayEvent.calculateGiveawayPrice();
    }

    public Map<String, Integer> getTotalBenefits() {
        Map<String, Integer> totalBenefits = new LinkedHashMap<>();
        discounts.getTotalDiscountDetails(totalBenefits);
        giveawayEvent.getGiveawayDetails(totalBenefits);
        return totalBenefits;
    }

}
