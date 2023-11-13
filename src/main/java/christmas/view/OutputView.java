package christmas.view;

import christmas.domain.GiveawayMenu;
import christmas.domain.Menu;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printIntroduce() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printStartEventPreview(int visitDate) {
        System.out.println("12월 " + visitDate +  "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printOrderMenu(Map<Menu, Integer> orderMenu) {
        System.out.println("<주문 메뉴>");
        for (Menu menu : orderMenu.keySet()) {
            System.out.println(menu.getMenuName() + " " + orderMenu.get(menu) + "개");
        }
        System.out.println();
    }

    public void printTotalOrderAmount(int totalOrderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(totalOrderAmount) + "원");
        System.out.println();
    }

    public void printGiveawayMenu(List<GiveawayMenu> giveawayMenus) {
        System.out.println("<증정 메뉴>");

        if (giveawayMenus.isEmpty()) {
            System.out.println("없음");
            System.out.println();
            return;
        }

        for (GiveawayMenu giveawayMenu : giveawayMenus) {
            System.out.println(giveawayMenu.getMenuName() + " " + giveawayMenu.getMenuCount() + "개");
        }

        System.out.println();
    }

    public void printBenefits(Map<String, Integer> benefits) {
        System.out.println("<혜택 내역>");

        if (benefits.isEmpty()) {
            System.out.println("없음");
            System.out.println();
            return;
        }

        for (String benefit : benefits.keySet()) {
            Integer benefitAmount = benefits.get(benefit);
            System.out.println(benefit + ": " + decimalFormat.format(benefitAmount) + "원");
        }

        System.out.println();
    }

    public void printTotalBenefitsAmount(int totalBenefitsAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println(decimalFormat.format(totalBenefitsAmount) + "원");
        System.out.println();
    }

    public void printDiscountedPayment(int discountedPayment) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(decimalFormat.format(discountedPayment) + "원");
        System.out.println();
    }

    public void printBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }


}
