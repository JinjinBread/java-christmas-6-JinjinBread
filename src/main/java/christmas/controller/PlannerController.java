package christmas.controller;

import christmas.domain.calendar.December;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.service.PlannerService;
import christmas.validator.MenuValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PlannerController {

    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = "-";

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final PlannerService plannerService = new PlannerService();

    public void startPlanner() {

        outputView.printIntroduce();

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
        MenuValidator.validateContainsEmpty(firstSplitStringOrderMenu);

        for (String splitStringOrderMenu : firstSplitStringOrderMenu) {
            MenuValidator.validateContainsEmpty(firstSplitStringOrderMenu);
            MenuValidator.validateSplitSize(splitStringOrderMenu);

            String[] secondSplitStringOrderMenu = splitStringOrderMenu.split(SECOND_DELIMITER, -1);
            String menuName = secondSplitStringOrderMenu[0];
            String menuCount = secondSplitStringOrderMenu[1];

            orderMenuNames.add(menuName);

            MenuValidator.validateValidOrderMenu(menuName, menuCount);
            orderMenu.put(Menu.getMenu(menuName), Integer.parseInt(menuCount));
        }

        MenuValidator.validateDuplicateMenu(orderMenuNames);
        MenuValidator.validateOnlyDrink(orderMenu);
        // 메뉴의 개수가 20개가 초과됐는지 검증

        return orderMenu;
    }



}