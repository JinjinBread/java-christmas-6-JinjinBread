package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.calendar.December;

import java.util.List;

public interface Discount {

    int CHRISTMAS_DISCOUNT_EVENT_START_DATE = 1;
    int START_DISCOUNT_PRICE = 1_000;
    int ADD_DISCOUNT_PRICE = 100;

    int WEEK_DISCOUNT_PRICE = 2_023;

    int SPECIAL_DISCOUNT_PRICE = 1_000;

    int PRICE_CRITERIA = 120_000;
    List<Menu> GIVEAWAY_MENU = List.of(Menu.CHAMPAGNE);
    List<Integer> GIVEAWAY_MENU_COUNT = List.of(1);

    String getName();

    int calculateDiscountAmount();

    boolean isEventApplied();
}