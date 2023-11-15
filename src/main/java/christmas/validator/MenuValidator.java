package christmas.validator;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MenuValidator {

    private static final String EMPTY = "";
    private static final String NUMERIC_REGX = "\\d+";
    private static final int MAX_ORDER_COUNT = 20;
    private static final String INVALID_INPUT_MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ONLY_DRINK_ERROR_MESSAGE = "[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.";
    private static final String EXCEED_MAX_ORDER_COUNT_ERROR_MESSAGE = "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.  다시 입력해 주세요.";

    public static void validateContainsEmpty(String[] inputs) {
        if (Arrays.asList(inputs).contains(EMPTY))
            throw new IllegalArgumentException(INVALID_INPUT_MENU_ERROR_MESSAGE);
    }

    public static void validateSplitSize(String[] splitOrderMenu) {
        if (splitOrderMenu.length != 2)
            throw new IllegalArgumentException(INVALID_INPUT_MENU_ERROR_MESSAGE);
    }

    public static void validateValidOrderMenu(String menuName, String menuCount) {
        validateExistMenu(menuName);
        validatePositiveNumber(menuCount);
    }

    private static void validateExistMenu(String menuName) {
        if (!Menu.existMenu(menuName))
            throw new IllegalArgumentException(INVALID_INPUT_MENU_ERROR_MESSAGE);
    }

    private static void validatePositiveNumber(String menuCount) {
        if (!menuCount.matches(NUMERIC_REGX) || (Integer.parseInt(menuCount) < 1))
            throw new IllegalArgumentException(INVALID_INPUT_MENU_ERROR_MESSAGE);
    }

    public static void validateDuplicateMenu(List<String> menuNames) {
        List<String> distinctMenuNames = menuNames.stream().distinct().toList();
        if (menuNames.size() != distinctMenuNames.size())
            throw new IllegalArgumentException(INVALID_INPUT_MENU_ERROR_MESSAGE);
    }

    public static void validateOnlyDrink(Map<Menu, Integer> orderMenu) {
        if (isOnlyDrink(orderMenu))
            throw new IllegalArgumentException(ONLY_DRINK_ERROR_MESSAGE);
    }

    private static boolean isOnlyDrink(Map<Menu, Integer> orderMenu) {
        List<Category> categoryOfOrderMenu = getCategoryOfOrderMenu(orderMenu);
        int drinkCategoryCount = 0;

        for (Category orderMenuCategory : categoryOfOrderMenu) {
            if (orderMenuCategory.equals(Category.DRINK))
                drinkCategoryCount++;
        }

        return drinkCategoryCount == categoryOfOrderMenu.size();
    }

    private static List<Category> getCategoryOfOrderMenu(Map<Menu, Integer> orderMenu) {
        List<Category> categoryOfOrderMenu = new ArrayList<>();

        for (Menu menu : orderMenu.keySet()) {
            categoryOfOrderMenu.add(Category.getCategoryByMenu(menu));
        }
        return categoryOfOrderMenu;
    }

    public static void validateMaxOrderCount(Map<Menu, Integer> orderMenu) {
        if(isOverMaxOrderCount(orderMenu))
            throw new IllegalArgumentException(EXCEED_MAX_ORDER_COUNT_ERROR_MESSAGE);
    }

    private static boolean isOverMaxOrderCount(Map<Menu, Integer> orderMenu) {
        int totalOrderCount = 0;

        for (Menu menu : orderMenu.keySet()) {
            totalOrderCount += orderMenu.get(menu);
        }
        return totalOrderCount > MAX_ORDER_COUNT;
    }

}
