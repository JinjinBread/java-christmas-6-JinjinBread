package christmas.domain.benefit;

import christmas.domain.menu.GiveawayMenu;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GiveawayEventTest {

    @Test
    @DisplayName("할인 전 총주문 금액이 12만 원 미만이면 증정품을 받을 수 없다.")
    void getGiveawayMenus_TotalOrderAmount_Less_Than_120000_Empty() {
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.TAPAS, 1);
                put(Menu.ZERO_COLA, 1);
            }
        });
        GiveawayEvent giveawayEvent = new GiveawayEvent(order);

        List<GiveawayMenu> giveawayMenus = giveawayEvent.getGiveawayMenus();

        assertThat(giveawayMenus).isEmpty();
    }

    @Test
    @DisplayName("할인 전 총주문 금액이 12만 원 이상이면 증정품을 받을 수 없다.")
    void getGiveawayMenus_TotalOrderAmount_More_Than_120000_Empty() {
        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.BARBECUE_RIBS, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        GiveawayEvent giveawayEvent = new GiveawayEvent(order);

        List<GiveawayMenu> giveawayMenus = giveawayEvent.getGiveawayMenus();

        assertThat(giveawayMenus).isNotEmpty();
    }

    @Test
    @DisplayName("증정품의 가격을 계산할 수 있다.")
    void calculateBenefitAmount() {

        Order order = new Order(new HashMap<Menu, Integer>() {
            {
                put(Menu.BARBECUE_RIBS, 1);
                put(Menu.RED_WINE, 2);
            }
        });
        GiveawayEvent giveawayEvent = new GiveawayEvent(order);

        int benefitAmount = giveawayEvent.calculateBenefitAmount();

        assertThat(benefitAmount).isEqualTo(-25000);

    }


}