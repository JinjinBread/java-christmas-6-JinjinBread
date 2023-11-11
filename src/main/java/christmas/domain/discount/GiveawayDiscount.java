package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.EnumMap;
import java.util.Map;

public class GiveawayDiscount implements Discount {

    private final String name = "증정 이벤트";
    private final Map<Menu, Integer> giveaway = new EnumMap<>(Menu.class);
    private Order order;

    public GiveawayDiscount(Order order) {
        this.order = order;
        initGiveaway(order);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateDiscountAmount() {
        int giveawayPrice = 0;
        for (Menu menu : giveaway.keySet()) {
            giveawayPrice += menu.calculatePrice(giveaway.get(menu));
        }
        return giveawayPrice;
    }

    private void initGiveaway(Order order) {
        if (order.isOver(GIVEAWAY_PRICE_CRITERIA)) {
            for (int i = 0; i < GIVEAWAY_MENU.size(); i++) {
                giveaway.put(GIVEAWAY_MENU.get(i), GIVEAWAY_MENU_COUNT.get(i));
            }
        }
        giveaway.put(Menu.NONE, 0);
    }

    @Override
    public boolean isEventApplied() {
        return calculateDiscountAmount() != 0;
    }
}
