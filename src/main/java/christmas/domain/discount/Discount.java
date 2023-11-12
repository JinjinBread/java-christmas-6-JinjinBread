package christmas.domain.discount;

import christmas.domain.Category;
import christmas.domain.Menu;

import java.util.List;

public interface Discount {

    int CHRISTMAS_DISCOUNT_EVENT_START_DATE = 1;
    int START_DISCOUNT_PRICE = 1_000;
    int ADD_DISCOUNT_PRICE = 100;

    int WEEK_DISCOUNT_PRICE = 2_023;
    Category WEEKDAY_DISCOUNT_CATEGORY = Category.DESSERT;
    Category WEEKEND_DISCOUNT_CATEGORY = Category.MAIN;

    int SPECIAL_DISCOUNT_PRICE = 1_000;

    String getName();

    int calculateDiscountAmount();

    boolean isEventApplied();
}