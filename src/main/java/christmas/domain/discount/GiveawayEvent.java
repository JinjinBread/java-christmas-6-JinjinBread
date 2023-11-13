package christmas.domain.discount;

import christmas.domain.GiveawayMenu;
import christmas.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GiveawayEvent {

    private final String name = "증정 이벤트";
    private final Order order;
    private final List<GiveawayMenu> giveawayMenus = new ArrayList<>();

    public GiveawayEvent(Order order) {
        this.order = order;
        initGiveawayMenu();
    }

    public String getName() {
        return name;
    }

    public List<GiveawayMenu> getGiveawayMenus() {
        return giveawayMenus;
    }

    public void initGiveawayMenu() {
        if (order.isOver(120_000))
            giveawayMenus.addAll(List.of(GiveawayMenu.values()));
    }

    public int calculateGiveawayPrice() {
        int giveawayPrice = 0;
        for (GiveawayMenu giveawayMenu : giveawayMenus) {
            giveawayPrice += giveawayMenu.getGiveawayPrice();
        }
        return giveawayPrice;
    }

    public void getGiveawayDetails(Map<String, Integer> totalBenefits) {
        int giveawayPrice = calculateGiveawayPrice();
        if (giveawayPrice != 0)
            totalBenefits.put(name, giveawayPrice);
    }

}
