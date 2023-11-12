package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.EnumMap;
import java.util.Map;

public class GiveawayEvent {

    private static final int GIVEAWAY_PRICE_CRITERIA = 120_000;
    private static final Map<Menu, Integer> GIVEAWAY_MENU = new EnumMap<>(Menu.class) {
        {
            put(Menu.CHAMPAGNE, 1);
        }
    };

    private final String name = "증정 이벤트";
    private final Map<Menu, Integer> giveaway = new EnumMap<>(Menu.class);
    private final Order order;

    public GiveawayEvent(Order order) {
        this.order = order;
        initGiveaway(order);
    }

    private void initGiveaway(Order order) {
        if (order.isOver(GIVEAWAY_PRICE_CRITERIA)) {
            for (Menu menu : GIVEAWAY_MENU.keySet()) {
                giveaway.put(menu, GIVEAWAY_MENU.get(menu));
            }
        }
        giveaway.put(Menu.NONE, 0);
    }

    public int calculateGiveawayPrice() {
        int giveawayPrice = 0;
        for (Menu menu : giveaway.keySet()) {
            giveawayPrice += menu.calculatePrice(giveaway.get(menu));
        }
        return giveawayPrice;
    }
}
