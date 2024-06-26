package christmas.domain.benefit;

import christmas.domain.menu.GiveawayMenu;
import christmas.domain.order.Order;

import java.util.ArrayList;
import java.util.List;

public class GiveawayEvent extends Benefit {

    private static final int THRESHOLD = 120_000;
    private final String title = "증정 이벤트";
    private final Order order;
    private final List<GiveawayMenu> giveawayMenus = new ArrayList<>();

    public GiveawayEvent(Order order) {
        this.order = order;
        initGiveawayMenu();
    }

    public void initGiveawayMenu() {
        if (order.calculateTotalOrderAmount() >= THRESHOLD)
            giveawayMenus.addAll(List.of(GiveawayMenu.values()));
    }

    public String getTitle() {
        return title;
    }

    public List<GiveawayMenu> getGiveawayMenus() {
        return giveawayMenus;
    }

    @Override
    public int calculateBenefitAmount() {
        int giveawayPrice = 0;
        for (GiveawayMenu giveawayMenu : giveawayMenus) {
            giveawayPrice += giveawayMenu.getGiveawayPrice();
        }
        return giveawayPrice * -1;
    }

    @Override
    public boolean isGiveawayEvent() {
        return true;
    }

}
