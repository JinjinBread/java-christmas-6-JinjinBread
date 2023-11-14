package christmas.view;

import christmas.domain.benefit.Benefit;
import christmas.domain.menu.GiveawayMenu;
import christmas.domain.menu.Menu;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    private static final String LEFT_ANGLE_BRACKETS = "<";
    private static final String RIGHT_ANGLE_BRACKETS = ">";
    private static final String BLANK = " ";
    private static final String COUNT = "개";
    private static final String WON = "원";
    private static final String NOTHING = "없음";
    private static final String INTRODUCE_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DECEMBER_MESSAGE = "12월 ";
    private static final String START_PREVIEW_MESSAGE = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "주문 메뉴";
    private static final String TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_MESSAGE = "할인 전 총주문 금액";
    private static final String GIVEAWAY_MENU_MESSAGE = "증정 메뉴";
    private static final String BENEFIT_DETAILS_MESSAGE = "혜택 내역";
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = "총혜택 금액";
    private static final String DISCOUNTED_PAYMENT_AMOUNT_MESSAGE = "할인 후 예상 결제 금액";
    private static final String EVENT_BADGE_MESSAGE = "이벤트 배지";

    public void printIntroduce() {
        System.out.println(INTRODUCE_MESSAGE);
    }

    public void printStartEventPreview(int visitDate) {
        System.out.println(DECEMBER_MESSAGE + visitDate + START_PREVIEW_MESSAGE);
        System.out.println();
    }

    public void printOrderMenu(Map<Menu, Integer> orderMenu) {
        System.out.println(LEFT_ANGLE_BRACKETS + ORDER_MENU_MESSAGE + RIGHT_ANGLE_BRACKETS);
        for (Menu menu : orderMenu.keySet()) {
            System.out.println(menu.getMenuName() + BLANK + orderMenu.get(menu) + COUNT);
        }
        System.out.println();
    }

    public void printTotalOrderAmount(int totalOrderAmount) {
        System.out.println(LEFT_ANGLE_BRACKETS + TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_MESSAGE + RIGHT_ANGLE_BRACKETS);
        System.out.println(decimalFormat.format(totalOrderAmount) + WON);
        System.out.println();
    }

    public void printGiveawayMenu(List<GiveawayMenu> giveawayMenus) {
        System.out.println(LEFT_ANGLE_BRACKETS + GIVEAWAY_MENU_MESSAGE + RIGHT_ANGLE_BRACKETS);

        if (giveawayMenus.isEmpty()) {
            System.out.println(NOTHING);
            System.out.println();
            return;
        }

        for (GiveawayMenu giveawayMenu : giveawayMenus) {
            System.out.println(giveawayMenu.getMenuName() + BLANK + giveawayMenu.getMenuCount() + COUNT);
        }

        System.out.println();
    }

    public void printBenefits(List<String> benefits) {
        System.out.println(LEFT_ANGLE_BRACKETS + BENEFIT_DETAILS_MESSAGE + RIGHT_ANGLE_BRACKETS);

        if (benefits.isEmpty()) {
            System.out.println(NOTHING);
            System.out.println();
            return;
        }

        for (String benefit : benefits) {
            System.out.println(benefit);
        }

        System.out.println();
    }

    public void printTotalBenefitsAmount(int totalBenefitsAmount) {
        System.out.println(LEFT_ANGLE_BRACKETS + TOTAL_BENEFIT_AMOUNT_MESSAGE + RIGHT_ANGLE_BRACKETS);
        System.out.println(decimalFormat.format(totalBenefitsAmount) + WON);
        System.out.println();
    }

    public void printDiscountedPayment(int discountedPayment) {
        System.out.println(LEFT_ANGLE_BRACKETS + DISCOUNTED_PAYMENT_AMOUNT_MESSAGE + RIGHT_ANGLE_BRACKETS);
        System.out.println(decimalFormat.format(discountedPayment) + WON);
        System.out.println();
    }

    public void printBadge(String badge) {
        System.out.println(LEFT_ANGLE_BRACKETS + DECEMBER_MESSAGE + EVENT_BADGE_MESSAGE + RIGHT_ANGLE_BRACKETS);
        System.out.println(badge);
    }


}
