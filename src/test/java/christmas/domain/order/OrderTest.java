package christmas.domain.order;

import christmas.domain.menu.Menu;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void 총_주문_금액을_계산할_수_있다() {
        Map<Menu, Integer> orderMenu = new EnumMap<>(Menu.class);
        orderMenu.put(Menu.BARBECUE_RIBS, 1);
        orderMenu.put(Menu.CHOCOLATE_CAKE, 2);
        Order order = new Order(orderMenu);

        int totalOrderAmount = order.calculateTotalOrderAmount();

        assertThat(totalOrderAmount).isEqualTo(84_000);
    }

}