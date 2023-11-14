package christmas.controller;

import christmas.domain.benefit.Benefits;
import christmas.domain.calendar.December;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.service.PlannerService;
import christmas.validator.MenuValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.*;

public class PlannerController {

    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = "-";

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final PlannerService plannerService = new PlannerService();

    public void startPlanner() {

        outputView.printIntroduce();

        December december = generateDecember();
        Order order = generateOrder();
        Benefits benefits = plannerService.generateBenefits(december, order);

        outputView.printStartEventPreview(december.getDate());
        givePreview(order, benefits);
    }

    private December generateDecember() {
        try {
            int visitDate = inputView.readDate();
            return new December(visitDate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateDecember();
        }
    }

    private Order generateOrder() {
        try {
            String stringOrderMenu = inputView.readOrderMenu();
            Map<Menu, Integer> orderMenu = convertStringToMap(stringOrderMenu);
            return new Order(orderMenu);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateOrder();
        }
    }

    private Map<Menu, Integer> convertStringToMap(String stringOrderMenu) {
        Map<Menu, Integer> orderMenu = new EnumMap<>(Menu.class);
        List<String> orderMenuNames = new ArrayList<>();

        String[] firstSplitStringOrderMenu = stringOrderMenu.split(FIRST_DELIMITER, -1);
        validateMenuInputForm(firstSplitStringOrderMenu);

        for (String splitStringOrderMenu : firstSplitStringOrderMenu) {
            String[] secondSplitStringOrderMenu = splitStringOrderMenu.split(SECOND_DELIMITER, -1);
            validateDuplicateMenuName(orderMenuNames, secondSplitStringOrderMenu[0]);
            putOrderMenu(secondSplitStringOrderMenu, orderMenu);
        }

        MenuValidator.validateOnlyDrink(orderMenu);
        MenuValidator.validateMaxOrderCount(orderMenu);
        return orderMenu;
    }

    private void validateMenuInputForm(String[] firstSplitStringOrderMenu) {
        MenuValidator.validateContainsEmpty(firstSplitStringOrderMenu);

        for (String splitStringOrderMenu : firstSplitStringOrderMenu) {
            String[] secondSplitStringOrderMenu = splitStringOrderMenu.split(SECOND_DELIMITER, -1);
            MenuValidator.validateContainsEmpty(secondSplitStringOrderMenu);
            MenuValidator.validateSplitSize(secondSplitStringOrderMenu);
        }
    }

    private void validateDuplicateMenuName(List<String> orderMenuNames, String menuName) {
        orderMenuNames.add(menuName);
        MenuValidator.validateDuplicateMenu(orderMenuNames);
    }

    private void putOrderMenu(String[] secondSplitStringOrderMenu, Map<Menu, Integer> orderMenu) {
        String menuName = secondSplitStringOrderMenu[0];
        String menuCount = secondSplitStringOrderMenu[1];

        MenuValidator.validateValidOrderMenu(menuName, menuCount);
        orderMenu.put(Menu.getMenu(menuName), Integer.parseInt(menuCount));
    }

    private void givePreview(Order order, Benefits benefits) {
        outputView.printOrderMenu(order.getOrderMenu());
        outputView.printTotalOrderAmount(order.calculateTotalOrderAmount());
        outputView.printGiveawayMenu(benefits.getGiveawayMenus());
        outputView.printBenefits(benefits.getBenefitDetails());
        outputView.printTotalBenefitsAmount(benefits.calculateTotalBenefitsAmount());
        outputView.printDiscountedPayment(plannerService.calculateDiscountedPaymentAmount(order, benefits));
        outputView.printBadge(plannerService.getEventBadge(benefits.calculateTotalBenefitsAmount()));
    }

}